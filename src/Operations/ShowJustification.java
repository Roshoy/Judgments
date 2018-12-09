package Operations;

import Judgments.Judgment;

import java.util.HashMap;

public class ShowJustification extends Operation{
    public ShowJustification(HashMap<Long,Judgment> judgments){
        setJudgments(judgments);
    }

    public String justification(int id){
        Judgment judgment = getJudgment(id);
        return judgment.getTextContent();
    }
}
