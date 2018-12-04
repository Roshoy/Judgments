package main;

import Attributes.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Judgment {
    public long id = -1;
    public CourtType courtType;
    public JudgmentType judgmentType;
    public List<String> courtCases = new ArrayList<>();
    public List<IJudgmentAttribute> judges = new ArrayList<>();
    public JudgmentSource source = new JudgmentSource();
    public List<String> courtReporters = new ArrayList<>();
    public String decision = new String();
    public String summary = new String();
    public String textContent = new String();
    public List<String> legalBases = new ArrayList<>();
    public List<IJudgmentAttribute> referencedRegulations = new ArrayList<>();
    public List<String> keywords = new ArrayList<>(); // how those keywords are built?
    public List<IJudgmentAttribute> referencedCourtCases = new ArrayList<>();
    public Date receiptDate = new Date();
    public String meansOfAppeal = new String();
    public String judgmentResult = new String();
    public List<String> lowerCourtJudgments = new ArrayList<>();
    public PersonnelType personnelType;
    public HashMap<Integer,String> judgmentForm = new HashMap<>();
    public Integer divisionID = null;
    public List<Integer> chambers = new ArrayList<>();
    public List<IJudgmentAttribute> dissentingOpinions = new ArrayList<>();

    public void readJudgment(JSONObject object){
        this.id = (long)object.get("id");

        this.courtType = AttributesParser.courtTypeParser((String)object.get("courtType"));

        this.judgmentType = AttributesParser.judgmentTypeParser((String)object.get("judgmentType"));

        readAttributeList(object,"referencedCourtCases", new CourtCase());

        readAttributeList(object, "judges", new Judge());
        this.source.read((JSONObject)object.get("source"));

        readStringList(object,"courtReporters","courtReporters");

        this.decision = (String)object.get("decision");

        this.summary = (String)object.get("summary");
        this.textContent = (String)object.get("textContent");
        readStringList(object, "legalBases","legalBases");
        readAttributeList(object,"referencedRegulations", new Regulation());
        readStringList(object,"keywords","keywords");

        DateFormat format = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
        try {
            receiptDate = format.parse((String) object.get("receiptDate"));
        }catch(ParseException e){
            System.out.println(e.getMessage());
        }

        this.meansOfAppeal = (String)object.get("meansOfAppeal");
        this.judgmentResult = (String)object.get("judgmentResult");

        //
//        objArray = (JSONArray) object.get("courtReporters");
//        for(Object obj: objArray){
//            this.courtReporters.add((String)obj);
//        }
//
//        this.decision = (String)object.get("decision");
//
//        this.summary = (String)object.get("summary");
//
//        this.textContent = (String)object.get("textContent");
//
//        objArray = (JSONArray) object.get("legalBases");
//        for(Object obj: objArray){
//            this.legalBases.add((String)obj);
//        }
//
//        objArray = (JSONArray) object.get("referencedRegulations");
//        for(Object obj: objArray){
//            Regulation reg = new Regulation();
//            reg.read((JSONObject)obj);
//            this.referencedRegulations.add(reg);
//        }
//
//        objArray = (JSONArray) object.get("keywords");
//        for(Object obj: objArray){
//            this.keywords.add((String)obj);
//        }
//
//        //// czy tu nie można IAtribute z metodą read(JSONObject)?
        //// a potem łatwo sprawdzać kolejne pola
    }

    private void readAttributeList(JSONObject object,  String attribute, JudgmentAttribute temp){
        List<IJudgmentAttribute> attributes = new ArrayList<>();
        try {
            attributes = (ArrayList<IJudgmentAttribute>) this.getClass().getField(attribute).get(this);
        }catch (NoSuchFieldException | IllegalAccessException e){
            System.out.println(e.getMessage());
        }
        JSONArray objArray = (JSONArray) object.get(temp.getIdentifier());
        for(Object obj: objArray){
            attributes.add(temp.read((JSONObject)obj));
        }
    }

    private void readStringList(JSONObject object,  String attribute, String identifier){
        List<String> attributes = new ArrayList<>();
        try {
            attributes = (ArrayList<String>) this.getClass().getField(attribute).get(this);
        }catch (NoSuchFieldException | IllegalAccessException e){
            System.out.println(e.getMessage());
        }
        String str = new String();
        JSONArray objArray = (JSONArray) object.get(identifier);
        for(Object obj: objArray){
            attributes.add((String)obj);
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
