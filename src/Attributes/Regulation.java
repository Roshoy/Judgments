package Attributes;

import org.json.simple.JSONObject;

public class Regulation extends JudgmentAttribute{
    public String journalTitle = "";
    public int journalYear;
    public int journalNo;
    public int journalEntry;
    public String text = "";

    public static JudgmentAttribute read(JSONObject object){
        Regulation regulation = new Regulation();
        regulation.journalTitle = (String)object.get("journalTitle");
        regulation.journalYear = (int)(long)object.get("journalYear");
        regulation.journalNo = (int)(long)object.get("journalNo");
        regulation.journalEntry = (int)(long)object.get("journalEntry");
        regulation.text = (String)object.get("text");
        return regulation;
    }

}
