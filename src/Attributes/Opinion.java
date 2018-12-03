package Attributes;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Opinion implements IJudgmentAttribute {
    public String textContent = new String();
    public List<String> authors = new ArrayList<>();

    public void read(JSONObject object){
        this.textContent = (String)object.get("textContent");
        JSONArray objArray = (JSONArray) object.get("authors");
        for(Object obj: objArray){
            this.authors.add((String)obj);
        }
    }
}
