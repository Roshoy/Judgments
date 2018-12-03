package main;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

//JudgmentReader will read judgment
public class JudgmentReader {
    private String direction;
    private JSONParser parser = new JSONParser();
    private int judgmentsCount = 0;
    private JSONArray  itemsArray = new JSONArray();
    public List<Judgment> judgments = new ArrayList<>();

    public JudgmentReader(String path){
        this.direction = path;
    }

    public List<Judgment> readAllFiles()throws ParseException, IOException {
        File direction = new File(this.direction);
        for (File judgmentsFile : direction.listFiles()) {
            System.out.println(judgmentsFile.getAbsolutePath());
            this.readArray(judgmentsFile.getAbsolutePath());
            this.readAllItems();
        }
        return this.judgments;
    }

    public void readArray(String path)throws ParseException, IOException {
        JSONObject object = (JSONObject)this.parser.parse(new FileReader(path));
        this.itemsArray = (JSONArray)object.get("items");
        this.judgmentsCount = this.itemsArray.size();
    }

    public void readAllItems(){
        for(int i=0; i<this.judgmentsCount; i++){
            this.readSingleItem(i);
        }
    }

    public void readSingleItem(int i){
        JSONObject item = (JSONObject)this.itemsArray.get(i);
        //System.out.println((String)item.get("courtType"));
        Judgment judgment = new Judgment();
        judgment.readJudgment(item);
        this.judgments.add(judgment);
    }
}
