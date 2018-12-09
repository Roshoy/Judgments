package Operations;

import Attributes.IJudgmentAttribute;
import Judgments.Judgment;

import java.util.HashMap;

abstract class Operation {
    HashMap<Long, Judgment> judgments;
    private HashMap<String, HashMap<Integer, IJudgmentAttribute>> base = new HashMap<>();

    public void setBase(HashMap<String, HashMap<Integer, IJudgmentAttribute>> base) {
        this.base = base;
    }

    public HashMap<Integer, IJudgmentAttribute> getGivenBase(String idenitfier) {
        return this.base.get(idenitfier);
    }

    public void setJudgments(HashMap<Long, Judgment> judgments) {
        this.judgments = judgments;
    }

    protected Judgment getJudgment(int id){
        return judgments.get((long)id);
    }
}
