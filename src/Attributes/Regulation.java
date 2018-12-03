package Attributes;

import org.json.simple.JSONObject;

public class Regulation implements IJudgmentAttribute{
    public String journalTitle = "";
    public int journalYear;
    public int journalNo;
    public int journalEntry;
    public String text = "";

    public void read(JSONObject object){
        this.journalTitle = (String)object.get("journalTitle");
        this.journalYear = (int)(long)object.get("journalYear");
        this.journalNo = (int)(long)object.get("journalNo");
        this.journalEntry = (int)(long)object.get("journalEntry");
        this.text = (String)object.get("text");
        //return this;
    }

}
