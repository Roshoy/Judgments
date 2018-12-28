package Attributes;

import org.json.simple.JSONObject;

import java.util.LinkedList;
import java.util.List;

public class Regulation extends JudgmentAttribute{
    private String journalTitle = "";
    private int journalYear;
    private int journalNo;
    private int journalEntry;
    private String text = "";
    public List<String> judgmentsIds = new LinkedList<>();

    public Regulation(){
        identifier = "referencedRegulations";
    }

    public JudgmentAttribute readFromJson(JSONObject object){
        Regulation regulation = new Regulation();
        regulation.journalTitle = (String)object.get("journalTitle");
        regulation.journalYear = (int)(long)object.get("journalYear");
        regulation.journalNo = (int)(long)object.get("journalNo");
        regulation.journalEntry = (int)(long)object.get("journalEntry");
        regulation.text = (String)object.get("text");
        return regulation;
    }

    @Override

    public boolean equals(Object obj) {
        if(obj == null) return false;
        if(!(obj instanceof Regulation)) return false;
        return ((Regulation) obj).getJournalNo() == this.getJournalNo() &&
                ((Regulation) obj).getJournalYear() == this.getJournalYear() &&
                ((Regulation) obj).getJournalEntry() == this.getJournalEntry();
    }

    @Override
    public int hashCode() {
        int result=0;
        for (int i = 0; i< this.journalTitle.length(); i++){
            result += this.journalTitle.charAt(i)*73^(i);
        }
        return result;
    }

    public String getJournalTitle() {
        return journalTitle;
    }

    public void setJournalTitle(String journalTitle){this.journalTitle = journalTitle; };

    public int getJournalYear() {
        return journalYear;
    }

    public int getJournalNo() {
        return journalNo;
    }

    public int getJournalEntry() {
        return journalEntry;
    }

    public String getText() {
        return text;
    }
}
