package Attributes;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.List;
/////would not be common
public class Opinion extends JudgmentAttribute {
    private String textContent = new String();
    private List<String> authors = new ArrayList<>();

    public Opinion(){
        identifier = "dissentingOpinions";
    }

    public JudgmentAttribute read(JSONObject object){
        Opinion opinion = new Opinion();
        opinion.textContent = (String)object.get("textContent");
        JSONArray objArray = (JSONArray) object.get("authors");
        for(Object obj: objArray){
            opinion.getAuthors().add((String)obj);
        }
        return opinion;
    }

    public String getTextContent() {
        return textContent;
    }

    public List<String> getAuthors() {
        return authors;
    }
}
