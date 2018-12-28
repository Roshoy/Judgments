package Judgments;

import SharedObjects.IBaseChangeObserver;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class JudgmentReadFromJson {
    private JSONParser parser = new JSONParser();
    private HashMap<String,Judgment> judgments;
    private JudgmentFactoryFromJson judgmentFactoryFromJson;

    public JudgmentReadFromJson(HashMap<String,Judgment> judgments, IBaseChangeObserver observer){
        this.judgments = judgments;
        this.judgmentFactoryFromJson = new JudgmentFactoryFromJson(observer);
    }

    public void readAllItems(String path)throws ParseException, IOException {
        JSONObject object = (JSONObject)this.parser.parse(new FileReader(path));
        JSONArray itemsArray = (JSONArray)object.get("items");

        int judgmentsCount = itemsArray.size();
        for(int i=0; i<judgmentsCount; i++){
            this.readBySingleItem(i, itemsArray);
        }
    }

    private void readBySingleItem(int i, JSONArray itemsArray){
        JSONObject item = (JSONObject)itemsArray.get(i);

        Judgment judgment = judgmentFactoryFromJson.createJudgmentFromJSONObject(item);
        for(String id: judgment.getCourtCases()) {
            this.judgments.put(id, judgment);
        }
    }
}
