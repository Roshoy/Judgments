package Operations;

import Attributes.CourtType;
import Judgments.Judgment;

import java.util.Calendar;
import java.util.HashMap;

public class StatisticalDistribution extends Operation {
    public StatisticalDistribution(HashMap<Long, Judgment> judgments){
        setJudgments(judgments);
    }

    public HashMap<CourtType, Integer>byCourtTypes(){
        HashMap<CourtType,Integer> result = new HashMap<>();
        for(Judgment judgment: this.judgments.values()){
            int w = result.remove(judgment.getCourtType());
            w++;
            result.put(judgment.getCourtType(),w);
        }

        return result;
    }

    public int[] byMonth(){
        int[] result = new int[12];
        Calendar cal = Calendar.getInstance();

        for(Judgment judgment: this.judgments.values()){
            cal.setTime(judgment.getJudgmentDate());
             result[cal.get(Calendar.MONTH)]++;
        }

        return result;
    }
}
