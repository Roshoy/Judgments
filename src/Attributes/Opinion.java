package Attributes;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Opinion extends JudgmentAttribute {
    public String textContent = new String();
    public List<String> authors = new ArrayList<>();

    public static JudgmentAttribute read(JSONObject object){
        Opinion opinion = new Opinion();
        opinion.textContent = (String)object.get("textContent");
        JSONArray objArray = (JSONArray) object.get("authors");
        for(Object obj: objArray){
            opinion.authors.add((String)obj);
        }
        return opinion;
    }
}
