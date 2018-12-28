package Judgments;

import Attributes.CourtCase;
import Attributes.IJudgmentAttribute;
import SharedObjects.IBaseChangeObserver;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.awt.image.ImageObserver;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//JudgmentReader will read judgment
public class JudgmentReader {
    private String direction;
    private JSONParser parser = new JSONParser();
    private int judgmentsCount = 0;
    private JSONArray  itemsArray = new JSONArray();
    private HashMap<String,Judgment> judgments = new HashMap<>();
    private JudgmentFactory  judgmentFactory;

    public JudgmentReader(String path, IBaseChangeObserver observer){
        judgmentFactory= new JudgmentFactory(observer);
        this.direction = path;
    }

    public HashMap<String,Judgment> readAllFiles()throws ParseException, IOException {
        File direction = new File(this.direction);
        for (File judgmentsFile : direction.listFiles()) {
            this.readArray(judgmentsFile.getAbsolutePath());
            this.readAllItems();
        }
        return this.judgments;
    }

    private void readArray(String path)throws ParseException, IOException {
        JSONObject object = (JSONObject)this.parser.parse(new FileReader(path));
        this.itemsArray = (JSONArray)object.get("items");
        this.judgmentsCount = this.itemsArray.size();
    }

    private void readAllItems(){
        for(int i=0; i<this.judgmentsCount; i++){
            this.readSingleItem(i);
        }
    }

    private void readSingleItem(int i){
        JSONObject item = (JSONObject)this.itemsArray.get(i);

        Judgment judgment = judgmentFactory.createJudgmentFromJSONObject(item);
        for(String id: judgment.getCourtCases()) {
            this.judgments.put(id, judgment);
        }
    }
}
