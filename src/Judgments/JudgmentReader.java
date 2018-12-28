package Judgments;

import SharedObjects.IBaseChangeObserver;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

//JudgmentReader will read judgment
public class JudgmentReader {

    private HashMap<String,Judgment> judgments = new HashMap<>();
    private JudgmentReadFromJson jsonJudgmentReader;
    private JudgmentReadFromHtml htmlJudgmentReader;

    public JudgmentReader(IBaseChangeObserver observer){
        jsonJudgmentReader = new JudgmentReadFromJson(judgments,observer);
        htmlJudgmentReader = new JudgmentReadFromHtml(judgments, observer);
    }

    public HashMap<String,Judgment> readFromPath(String path)throws ParseException, IOException {
        File direction = new File(path);
        readAllFiles(direction);

        return this.judgments;
    }

    public void readAllFiles(File direction)throws ParseException, IOException {

        if(direction.isDirectory()) {
            for (File judgmentsFile : direction.listFiles()) {
                readAllFiles(judgmentsFile);
            }
        }else{
            System.out.println(direction.getAbsolutePath());
            if(direction.getName().endsWith(".json")){
                this.jsonJudgmentReader.readAllItems(direction.getAbsolutePath());

            }else {

                if(direction.getName().endsWith(".html")){

                    this.htmlJudgmentReader.readItem(direction.getAbsolutePath());
                }
            }

        }
    }

}
