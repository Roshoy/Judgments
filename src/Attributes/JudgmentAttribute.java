package Attributes;

import org.json.simple.JSONObject;

public class JudgmentAttribute {
    public static String identifier="";
    static JudgmentAttribute read(JSONObject object){
        return new JudgmentAttribute();
    };
}
