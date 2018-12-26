package Judgments;

import Attributes.*;

import java.util.*;

public class Judgment {
    private long id = -1;
    private CourtType courtType;
    private JudgmentType judgmentType;
    private List<String> courtCases = new ArrayList<>();
    private List<IJudgmentAttribute> judges = new ArrayList<>();
    private JudgmentSource source = new JudgmentSource();
    private List<String> courtReporters = new ArrayList<>();
    private String decision = new String();
    private String summary = new String();
    private String textContent = new String();
    private List<String> legalBases = new ArrayList<>();
    private List<IJudgmentAttribute> referencedRegulations = new ArrayList<>();
    private List<String> keywords = new ArrayList<>(); // how those keywords are built?
    private List<IJudgmentAttribute> referencedCourtCases = new ArrayList<>();
    private Date receiptDate = new Date();
//    private String meansOfAppeal = new String();
//    private String judgmentResult = new String();
//    private List<String> lowerCourtJudgments = new ArrayList<>();
//    private PersonnelType personnelType;
//    private String judgmentForm = new String();
//    private Integer divisionID = null;
//    private List<Integer> chambers = new ArrayList<>();
//    private List<IJudgmentAttribute> dissentingOpinions = new ArrayList<>();
    private Date judgmentDate = null;


    @Override
    public String toString() {


        String res = "";
        res += "id: " + String.valueOf(this.getId()) + '\n';
        res += "courtType: " + this.getCourtType().toString() + '\n';
        res += "judgmentType: " + this.getJudgmentType().toString() + '\n';
        res += "courtCases: " + this.getCourtCases().size() + '\n';
        res += "judges: " + this.getJudges().size() + '\n';
        res += "source: " + this.getSource().toString() + '\n';
        res += "courtReporters: " + this.getCourtReporters().size() + '\n';
        res += "decision: " + this.getDecision() + '\n';
        res += "summary: " + this.getSummary() + '\n';
        res += "textContent: " + this.getTextContent() + '\n';
        res += "legalBases: " + this.getLegalBases().size() +'\n';
        res += "referencedRegulations: "+ this.getReferencedRegulations().size() + '\n';
        res += "keywords: " + this.getKeywords().size() + '\n';
        res += "referencedCourtCases: " + this.getReferencedRegulations().size() + '\n';
        res += "receiptDate: " + (this.getReceiptDate()).toString() + '\n';
//        res += "meansOfAppeal: " + this.getMeansOfAppeal() + '\n';
//        res += "judgmentResoult: " + this.getJudgmentResult() + '\n';
//        res += "lowerCourtJudgments: " + this.getLowerCourtJudgments().size() +'\n';
//        if(this.getPersonnelType() != null)
//            res += "personelType: " + this.getPersonnelType().toString() + '\n';
//        res += "judgmentForm: " + this.getJudgmentForm() + '\n';
//        res += "divisionId: " + this.getDivisionID() + '\n';
//        res += "chambers: " + this.getChambers().size() + '\n';
//        res += "dissentingOpinions: " + this.getDissentingOpinions().size() + '\n';
        res += "judgmentDate: " + this.getJudgmentDate().toString() + '\n';

        return res;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public CourtType getCourtType() {
        return courtType;
    }

    public void setCourtType(CourtType courtType) {
        this.courtType = courtType;
    }

    public JudgmentType getJudgmentType() {
        return judgmentType;
    }

    public void setJudgmentType(JudgmentType judgmentType) {
        this.judgmentType = judgmentType;
    }

    public List<String> getCourtCases() {
        return courtCases;
    }

    public void setCourtCases(List<String> courtCases) {
        this.courtCases = courtCases;
    }

    public List<IJudgmentAttribute> getJudges() {
        return judges;
    }

    public void setJudges(List<IJudgmentAttribute> judges) {
        this.judges = judges;
    }

    public JudgmentSource getSource() {
        return source;
    }

    public void setSource(JudgmentSource source) {
        this.source = source;
    }

    public List<String> getCourtReporters() {
        return courtReporters;
    }

    public void setCourtReporters(List<String> courtReporters) {
        this.courtReporters = courtReporters;
    }

    public String getDecision() {
        return decision;
    }

    public void setDecision(String decision) {
        this.decision = decision;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getTextContent() {
        return textContent;
    }

    public void setTextContent(String textContent) {
        this.textContent = textContent;
    }

    public List<String> getLegalBases() {
        return legalBases;
    }

    public void setLegalBases(List<String> legalBases) {
        this.legalBases = legalBases;
    }

    public List<IJudgmentAttribute> getReferencedRegulations() {
        return referencedRegulations;
    }

    public void setReferencedRegulations(List<IJudgmentAttribute> referencedRegulations) {
        this.referencedRegulations = referencedRegulations;
    }

    public List<String> getKeywords() {
        return keywords;
    }

    public void setKeywords(List<String> keywords) {
        this.keywords = keywords;
    }

    public List<IJudgmentAttribute> getReferencedCourtCases() {
        return referencedCourtCases;
    }

    public void setReferencedCourtCases(List<IJudgmentAttribute> referencedCourtCases) {
        this.referencedCourtCases = referencedCourtCases;
    }

    public Date getReceiptDate() {
        return receiptDate;
    }

    public void setReceiptDate(Date receiptDate) {
        this.receiptDate = receiptDate;
    }
//
//    public String getMeansOfAppeal() {
//        return meansOfAppeal;
//    }
//
//    public void setMeansOfAppeal(String meansOfAppeal) {
//        this.meansOfAppeal = meansOfAppeal;
//    }
//
//    public String getJudgmentResult() {
//        return judgmentResult;
//    }
//
//    public void setJudgmentResult(String judgmentResult) {
//        this.judgmentResult = judgmentResult;
//    }
//
//    public List<String> getLowerCourtJudgments() {
//        return lowerCourtJudgments;
//    }
//
//    public void setLowerCourtJudgments(List<String> lowerCourtJudgments) {
//        this.lowerCourtJudgments = lowerCourtJudgments;
//    }
//
//    public PersonnelType getPersonnelType() {
//        return personnelType;
//    }
//
//    public void setPersonnelType(PersonnelType personnelType) {
//        this.personnelType = personnelType;
//    }
//
//    public String getJudgmentForm() {
//        return judgmentForm;
//    }
//
//    public void setJudgmentForm(String judgmentForm) {
//        this.judgmentForm = judgmentForm;
//    }
//
//    public Integer getDivisionID() {
//        return divisionID;
//    }
//
//    public void setDivisionID(Integer divisionID) {
//        this.divisionID = divisionID;
//    }
//
//    public List<Integer> getChambers() {
//        return chambers;
//    }
//
//    public void setChambers(List<Integer> chambers) {
//        this.chambers = chambers;
//    }
//
//    public List<IJudgmentAttribute> getDissentingOpinions() {
//        return dissentingOpinions;
//    }
//
//    public void setDissentingOpinions(List<IJudgmentAttribute> dissentingOpinions) {
//        this.dissentingOpinions = dissentingOpinions;
//    }

    public Date getJudgmentDate() {
        return judgmentDate;
    }

    public void setJudgmentDate(Date judgmentDate) {
        this.judgmentDate = judgmentDate;
    }
}
