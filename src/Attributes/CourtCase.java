package Attributes;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class CourtCase extends JudgmentAttribute {
    private String caseNumber = "";
    private boolean generated = false;
    private List<Long> judgmentIds = new ArrayList<>();


     public CourtCase(String id){
        this.identifier = id;
    }

    public IJudgmentAttribute read(JSONObject object){
        CourtCase courtCase = new CourtCase(this.identifier);
        courtCase.setCaseNumber((String)object.get("caseNumber"));
        if(object.containsKey("generated")) courtCase.setGenerated((boolean)object.get("generated"));
        if(object.containsKey("judgmentIds")){
            JSONArray objArray = (JSONArray) object.get("judgmentIds");
            for (Object obj : objArray) {
                courtCase.getJudgmentIds().add((Long) obj);
            }
        }

        return courtCase;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof CourtCase)) {
            return false;
        }
        return ((CourtCase) obj).getCaseNumber().equals(this.getCaseNumber());
    }

    @Override
    public int hashCode() {
         int result=0;

         for (int i = 0; i< this.getCaseNumber().length(); i++){
             result += this.getCaseNumber().charAt(i)*73^(i);
         }

         return result;
    }

    public String getCaseNumber() {
        return caseNumber;
    }

    public void setCaseNumber(String caseNumber) {
        this.caseNumber = caseNumber;
    }

    public boolean isGenerated() {
        return generated;
    }

    public void setGenerated(boolean generated) {
        this.generated = generated;
    }

    public List<Long> getJudgmentIds() {
        return judgmentIds;
    }

    public void setJudgmentIds(List<Long> judgmentIds) {
        this.judgmentIds = judgmentIds;
    }
}
