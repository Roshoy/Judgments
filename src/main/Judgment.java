package main;

import Attributes.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.*;

public class Judgment {
    public long id = -1;
    public CourtType courtType;
    public JudgmentType judgmentType;
    public List<CourtCase> courtCases = new ArrayList<>();
    public List<Judge> judges = new ArrayList<>();
    public JudgmentSource source;
    public List<String> courtReporters = new ArrayList<>();
    public String decision = new String();
    public String summary = new String();
    public String textContent = new String();
    public List<String> legalBases = new ArrayList<>();
    public List<Regulation> referencedRegulations = new ArrayList<>();
    public HashMap<Integer,String> keywords = new HashMap<>(); // how those keywords are built?
    public List<CourtCase> referencedCourtCases = new ArrayList<>();
    public Date receiptDate = new Date();
    public String meansOfAppeal = new String();
    public String judgmentResult = new String();
    public List<String> lowerCourtJudgments = new ArrayList<>();
    public PersonnelType personnelType;
    public HashMap<Integer,String> judgmentForm = new HashMap<>();
    public Integer divisionID = null;
    public List<Integer> chambers = new ArrayList<>();
    public List<Opinion> dissentingOpinions = new ArrayList<>();

    public void readJudgment(JSONObject object){
        this.id = (long)object.get("id");
        this.courtType = AttributesParser.courtTypeParser((String)object.get("courtType"));
        this.judgmentType = AttributesParser.judgmentTypeParser((String)object.get("judgmentType"));
        JSONArray objArray = (JSONArray) object.get("courtCases");
        for(Object obj: objArray){
            CourtCase cCase = new CourtCase();
            cCase.read((JSONObject)obj);
            this.courtCases.add(cCase);
        }
        //// czy tu nie można IAtribute z metodą read(JSONObject)?
        //// a potem łatwo sprawdzać kolejne pola
    }
//
//    private <T> void readAttributeList(JSONObject object, List<IJudgmentAttribute> attributes){
//        JSONArray objArray = (JSONArray) object.get("courtCases");
//        for(Object obj: objArray){
//            IJudgmentAttribute cCase = new T();
//            cCase.read((JSONObject)obj);
//            attributes.add(cCase);
//        }
//    }

    @Override
    public String toString() {
        String res = "";
        res += "id: " + String.valueOf(this.id) + '\n';
        res += "courtType: " + this.courtType.toString() + '\n';
        return res;
    }
}
