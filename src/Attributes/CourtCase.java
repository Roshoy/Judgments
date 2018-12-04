package Attributes;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class CourtCase extends JudgmentAttribute {
    public String caseNumber = new String();
    public boolean generated = false;
    public List<Long> judgmentIds = new ArrayList<>();

     public CourtCase(){
        this.identifier = "referencedCourtCases";
    }

    public IJudgmentAttribute read(JSONObject object){
        CourtCase courtCase = new CourtCase();
        System.out.println((String)object.get("caseNumber"));
        courtCase.caseNumber = (String)object.get("caseNumber");
        courtCase.generated = (boolean)object.get("generated");
        JSONArray objArray = (JSONArray) object.get("judgmentIds");
        for(Object obj: objArray){
            courtCase.judgmentIds.add((Long)obj);
        }
        return courtCase;
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof CourtCase)){
            return false;
        }
        return ((CourtCase) obj).caseNumber.equals(this.caseNumber);
    }
}