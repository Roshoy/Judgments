package Judgments;

import Attributes.*;
import SharedObjects.IBaseChangeObserver;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class JudgmentFactory {
    private JSONObject object;
    private IBaseChangeObserver observer;

    public JudgmentFactory(IBaseChangeObserver observer){
        this.observer = observer;
    }

    public Judgment createJudgmentFromJSONObject(JSONObject object) {
        this.object = object;
        Judgment result = new Judgment();
        result.setId((long) object.get("id"));
        result.setCourtType(AttributesParser.courtTypeParser((String) object.get("courtType")));
        result.setJudgmentType(AttributesParser.judgmentTypeParser((String) object.get("judgmentType")));
        result.setCourtCases(readStringList("courtCases"));
        result.setReferencedCourtCases(readAttributeList(new CourtCase("referencedCourtCases")));
        result.setJudges(readAttributeList(new Judge()));
        updateJudges(result);
        result.getSource().read((JSONObject) object.get("source"));
        result.setCourtReporters(readStringList("courtReporters"));
        result.setDecision((String) object.get("decision"));
        result.setSummary((String) object.get("summary"));
        result.setTextContent((String) object.get("textContent"));
        result.setLegalBases(readStringList("legalBases"));
        result.setReferencedRegulations(readAttributeList(new Regulation()));
        result.setKeywords(readStringList("keywords"));
        result.setReceiptDate(readDate("receiptDate"));
//        result.setMeansOfAppeal((String) object.get("meansOfAppeal"));
//        result.setJudgmentResult((String) object.get("judgmentResult"));
//
//        if(this.object.containsKey("judgmentForm"))
//            result.setJudgmentForm((String)((JSONObject)this.object.get("judgmentForm")).get("name"));
//
//        if(this.object.containsKey("chambers")) {
//            JSONArray objArray = (JSONArray) object.get("chambers");
//            for (Object obj : objArray) {
//                result.getChambers().add((int) (long) ((JSONObject) obj).get("id"));
//            }
//        }
//
//        result.setLowerCourtJudgments(readStringList("lowerCourtJudgments"));
//        result.setPersonnelType(AttributesParser.personnelTypeParser((String) object.get("personnelType")));
//        if(this.object.containsKey("divisionId"))
//            result.setDivisionID((Integer) ((JSONObject)object.get("divisionId")).get("id"));
//        if(this.object.containsKey("dissentingOpinions"))
//            result.setDissentingOpinions(readAttributeList(new Opinion()));
        result.setJudgmentDate(readDate("judgmentDate"));
        updateRegulations(result);

        return result;
    }
    private List<IJudgmentAttribute> readAttributeList(JudgmentAttribute template){
        List<IJudgmentAttribute> attributes = new ArrayList<>();
        JSONArray objArray = (JSONArray) this.object.get(template.getIdentifier());
        for(Object obj: objArray){
            IJudgmentAttribute temp = template.read((JSONObject)obj);
            temp = observer.updateBase(temp);
            attributes.add(temp);
        }

        return attributes;
    }

    private void updateJudges(Judgment judgment){
        for(IJudgmentAttribute judge: judgment.getJudges()){
            ((Judge)judge).judgmentsIds.add(judgment.getId());
        }
    }

    private void updateRegulations(Judgment judgment){
        for(IJudgmentAttribute regulation: judgment.getReferencedRegulations()){
            ((Regulation)regulation).judgmentsIds.add(judgment.getId());
        }
    }

    private List<String> readStringList( String identifier){
        List<String> attributes = new ArrayList<>();
        JSONArray objArray = (JSONArray) object.get(identifier);
        for(Object obj: objArray){
            attributes.add((String)obj);
        }
        return attributes;
    }
    private List<String> readTwoStepStringList( String identifier1, String identifier2){
        List<String> attributes = new ArrayList<>();
        JSONArray objArray = (JSONArray) object.get(identifier1);
        for(Object obj: objArray){
            attributes.add((String)((JSONObject)obj).get(identifier2));
        }
        return attributes;
    }

    private Date readDate(String identifier){
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);

        try {

            if(!object.containsKey(identifier) || ((String) object.get(identifier)).equals("") ) {
                return format.parse("0000-00-00");
            }else {
              //  System.out.println("goodie");
                return format.parse((String) object.get(identifier));
            }
        }catch(ParseException e){
            System.out.println(e.getMessage());
        }
        return null;

    }
}
