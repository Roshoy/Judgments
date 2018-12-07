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


    @Override
    public String toString() {
        String res = "";
        res += "id: " + String.valueOf(this.id) + '\n';
        res += "courtType: " + this.courtType.toString() + '\n';
        return res;
    }
}
