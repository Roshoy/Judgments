package Judgments;

import Attributes.*;

import java.util.*;

public class Judgment {

    private CourtType courtType;
    private List<String> courtCases = new ArrayList<>();
    private List<IJudgmentAttribute> judges = new ArrayList<>();
    private String textContent = new String();
    private List<IJudgmentAttribute> referencedRegulations = new ArrayList<>();
    private Date judgmentDate = null;


    @Override
    public String toString() {


        String res = "";
        res += "courtType: " + this.getCourtType().toString() + '\n';
        res += "courtCases: " + this.getCourtCases().size() + '\n';
        res += "judges: " + this.getJudges().size() + '\n';
        res += "textContent: " + this.getTextContent() + '\n';
        res += "referencedRegulations: "+ this.getReferencedRegulations().size() + '\n';
        res += "referencedCourtCases: " + this.getReferencedRegulations().size() + '\n';

        res += "judgmentDate: " + this.getJudgmentDate().toString() + '\n';

        return res;
    }

    public CourtType getCourtType() {
        return courtType;
    }

    public void setCourtType(CourtType courtType) {
        this.courtType = courtType;
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


    public String getTextContent() {
        return textContent;
    }

    public void setTextContent(String textContent) {
        this.textContent = textContent;
    }


    public List<IJudgmentAttribute> getReferencedRegulations() {
        return referencedRegulations;
    }

    public void setReferencedRegulations(List<IJudgmentAttribute> referencedRegulations) {
        this.referencedRegulations = referencedRegulations;
    }

    public Date getJudgmentDate() {
        return judgmentDate;
    }

    public void setJudgmentDate(Date judgmentDate) {
        this.judgmentDate = judgmentDate;
    }
}
