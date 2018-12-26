package Operations;

import Attributes.CourtType;
import Judgments.Judgment;

import java.util.*;

public class StatisticalDistribution{

    public static HashMap<CourtType, Integer> byCourtTypes(HashMap<String, Judgment> judgments){
        HashMap<CourtType,Integer> result = new HashMap<>();
        for(Judgment judgment: judgments.values()){
            int w = result.remove(judgment.getCourtType());
            w++;
            result.put(judgment.getCourtType(),w);
        }

        return result;
    }

    public static int[] byMonth(HashMap<String, Judgment> judgments){
        int[] result = new int[12];
        Calendar cal = Calendar.getInstance();

        for(Judgment judgment: judgments.values()){
            cal.setTime(judgment.getJudgmentDate());
             result[cal.get(Calendar.MONTH)]++;
        }

        return result;
    }

    public static HashMap<Integer, Integer> byJuryCount(HashMap<String, Judgment> judgments){
        HashMap<Integer, Integer> jury = new HashMap<>();
        for(Judgment judgment: judgments.values()){
            int judgesCount = judgment.getJudges().size();
            if(!jury.containsKey(judgesCount)){
                jury.put(judgesCount,1);
            }
            int temp = jury.remove(judgesCount);
            temp ++;
            jury.put(judgesCount, jury.remove(judgesCount)+1);
        }

        return jury;
    }
}
