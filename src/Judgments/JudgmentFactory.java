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

class JudgmentFactory {
    private JSONObject object;
    private IBaseChangeObserver observer;

    public JudgmentFactory(IBaseChangeObserver observer){
        this.observer = observer;
    }

    public Judgment createJudgmentFromJSONObject(JSONObject object) {
        this.object = object;
        Judgment result = new Judgment();

        result.setCourtType(AttributesParser.courtTypeParser((String) object.get("courtType")));
        result.setCourtCases(readCourtCasesList("courtCases"));
        result.setJudges(readAttributeList(new Judge()));
        updateJudges(result);
        result.setTextContent((String) object.get("textContent"));
        result.setReferencedRegulations(readAttributeList(new Regulation()));

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
            ((Judge)judge).judgmentsIds.add(judgment.getCourtCases().get(0));
        }
    }

    private void updateRegulations(Judgment judgment){
        for(IJudgmentAttribute regulation: judgment.getReferencedRegulations()){
            ((Regulation)regulation).judgmentsIds.add(judgment.getCourtCases().get(0));
        }
    }

    private List<String> readCourtCasesList(String identifier){
        List<String> attributes = new ArrayList<>();
        JSONArray objArray = (JSONArray) object.get(identifier);
        for(Object obj: objArray){
            attributes.add((String)((JSONObject)obj).get("caseNumber"));
        }
        return attributes;
    }


    private Date readDate(String identifier){
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);

        try {

            if(!object.containsKey(identifier) || ((String) object.get(identifier)).equals("") ) {
                return format.parse("0000-00-00");
            }else {
                return format.parse((String) object.get(identifier));
            }
        }catch(ParseException e){
            System.out.println(e.getMessage());
        }
        return null;

    }
}
