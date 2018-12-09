package Attributes;

import org.json.simple.JSONObject;

public class Regulation extends JudgmentAttribute{
    private String journalTitle = "";
    private int journalYear;
    private int journalNo;
    private int journalEntry;
    private String text = "";

    public Regulation(){
        identifier = "referencedRegulations";
    }

    public JudgmentAttribute read(JSONObject object){
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
        return this.getJournalEntry() *5101 + this.getJournalYear() *5101^2 + this.getJournalNo() *5101^3;
    }

    public String getJournalTitle() {
        return journalTitle;
    }

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
