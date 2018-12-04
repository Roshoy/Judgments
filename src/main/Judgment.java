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
    public JudgmentSource source = new JudgmentSource();
    public List<String> courtReporters = new ArrayList<>();
    public String decision = new String();
    public String summary = new String();
    public String textContent = new String();
    public List<String> legalBases = new ArrayList<>();
    public List<Regulation> referencedRegulations = new ArrayList<>();
    public List<String> keywords = new ArrayList<>(); // how those keywords are built?
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

        objArray = (JSONArray) object.get("judges");
        for(Object obj: objArray){
            Judge judge = new Judge();
            judge.read((JSONObject)obj);
            this.judges.add(judge);
        }

        this.source.read((JSONObject)object.get("source"));

        objArray = (JSONArray) object.get("courtReporters");
        for(Object obj: objArray){
            this.courtReporters.add((String)obj);
        }

        this.decision = (String)object.get("decision");

        this.summary = (String)object.get("summary");

        this.textContent = (String)object.get("textContent");

        objArray = (JSONArray) object.get("legalBases");
        for(Object obj: objArray){
            this.legalBases.add((String)obj);
        }

        objArray = (JSONArray) object.get("referencedRegulations");
        for(Object obj: objArray){
            Regulation reg = new Regulation();
            reg.read((JSONObject)obj);
            this.referencedRegulations.add(reg);
        }

        objArray = (JSONArray) object.get("keywords");
        for(Object obj: objArray){
            this.keywords.add((String)obj);
        }

        //// czy tu nie można IAtribute z metodą read(JSONObject)?
        //// a potem łatwo sprawdzać kolejne pola
    }

    private void readAttributeList(JSONObject object, List<JudgmentAttribute> attributes, String name, Class c){
        JSONArray objArray = (JSONArray) object.get(name);
        for(Object obj: objArray){
            attributes.add(JudgmentAttribute.read((JSONObject)obj));
        }
    }

    @Override
    public String toString() {
        String res = "";
        res += "id: " + String.valueOf(this.id) + '\n';
        res += "courtType: " + this.courtType.toString() + '\n';
        return res;
    }
}
