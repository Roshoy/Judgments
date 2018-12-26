package Operations;

import Judgments.Judgment;

import java.util.HashMap;

public class ShowJustification{

    public static String justification(String id, HashMap<String,Judgment> judgments){
        Judgment judgment = judgments.get(id);
        return judgment.getTextContent();
    }
}
