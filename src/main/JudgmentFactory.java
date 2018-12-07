package main;

import Attributes.*;
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

    public Judgment createJudgmentFromJSONObject(JSONObject object) {
        this.object = object;
        Judgment result = new Judgment();
        result.id = (long) object.get("id");
        result.courtType = AttributesParser.courtTypeParser((String) object.get("courtType"));
        result.judgmentType = AttributesParser.judgmentTypeParser((String) object.get("judgmentType"));
        result.referencedCourtCases = readAttributeList(new CourtCase());
        result.judges = readAttributeList(new Judge());
        result.source.read((JSONObject) object.get("source"));
        result.courtReporters = readStringList("courtReporters");
        result.decision = (String) object.get("decision");
        result.summary = (String) object.get("summary");
        result.textContent = (String) object.get("textContent");
        result.legalBases = readStringList("legalBases");
        result.referencedRegulations = readAttributeList(new Regulation());
        result.keywords = readStringList("keywords");
        result.receiptDate = readDate("receiptDate");
        result.meansOfAppeal = (String) object.get("meansOfAppeal");
        result.judgmentResult = (String) object.get("judgmentResult");

//        public HashMap<Integer,String> judgmentForm = new HashMap<>(); why hash map?
//        public List<Integer> chambers = new ArrayList<>();

        result.lowerCourtJudgments = readStringList("lowerCourtJudgments");
        result.personnelType = AttributesParser.personnelTypeParser((String) object.get("personnelType"));
        result.divisionID = (Integer) object.get("divisionId");
        result.dissentingOpinions = readAttributeList(new Opinion());

        return result;
    }
    private List<IJudgmentAttribute> readAttributeList(JudgmentAttribute temp){
        List<IJudgmentAttribute> attributes = new ArrayList<>();
        JSONArray objArray = (JSONArray) this.object.get(temp.getIdentifier());
        for(Object obj: objArray){
            attributes.add(temp.read((JSONObject)obj));
        }
        return attributes;
    }

    private List<String> readStringList( String identifier){
        List<String> attributes = new ArrayList<>();
        JSONArray objArray = (JSONArray) object.get(identifier);
        for(Object obj: objArray){
            attributes.add((String)obj);
        }
        return attributes;
    }

    private Date readDate(String identifier){
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
        try {
            return format.parse((String) object.get("receiptDate"));
        }catch(ParseException e){
            System.out.println(e.getMessage());
        }finally {
            return null;
        }
    }
}
