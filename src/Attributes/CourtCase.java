package Attributes;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class CourtCase implements IJudgmentAttribute {
    public String caseNumber = new String();
    public boolean generated = false;
    public List<Long> judgmentIds = new ArrayList<>();


    public void read(JSONObject object){
        this.caseNumber = (String)object.get("caseNumber");
        this.generated = (boolean)object.get("generated");
        JSONArray objArray = (JSONArray) object.get("judgmentIds");
        for(Object obj: objArray){
            this.judgmentIds.add((Long)obj);
        }
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof CourtCase)){
            return false;
        }
        return ((CourtCase) obj).caseNumber.equals(this.caseNumber);
    }
}
