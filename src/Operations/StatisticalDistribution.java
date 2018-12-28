package Operations;

import Attributes.CourtType;
import Judgments.Judgment;

import java.io.IOException;
import java.nio.file.Path;
import java.text.DateFormatSymbols;
import java.util.*;

public class StatisticalDistribution extends AbstractOperation{

    private static HashMap<CourtType, Integer> byCourtTypes(HashMap<String, Judgment> judgments){
        HashMap<CourtType,Integer> result = new HashMap<>();
        Set<Judgment> judgmentsInSet = new HashSet<>(judgments.values());
        for(CourtType court: CourtType.values()){
            result.put(court,0);
        }
        for(Judgment judgment: judgmentsInSet){
            int w = result.remove(judgment.getCourtType());
            w++;
            result.put(judgment.getCourtType(),w);
        }

        return result;
    }

    private static int[] byMonth(HashMap<String, Judgment> judgments){
        int[] result = new int[12];
        Calendar cal = Calendar.getInstance();
        Set<Judgment> judgmentsInSet = new HashSet<>(judgments.values());
        for(Judgment judgment: judgmentsInSet){
            cal.setTime(judgment.getJudgmentDate());
             result[cal.get(Calendar.MONTH)]++;
        }

        return result;
    }

    private static HashMap<Integer, Integer> byJuryCount(HashMap<String, Judgment> judgments){
        HashMap<Integer, Integer> jury = new HashMap<>();
        Set<Judgment> judgmentsInSet = new HashSet<>(judgments.values());

        for(Judgment judgment: judgmentsInSet){
            int judgesCount = judgment.getJudges().size();
            if(!jury.containsKey(judgesCount)){
                jury.put(judgesCount,0);
            }
            int temp = jury.remove(judgesCount) + 1;
            jury.put(judgesCount, temp);

        }

        return jury;
    }

    public static void runByCourtTypes(HashMap<String, Judgment> judgments, Path history) throws IOException {
        HashMap<CourtType, Integer> stats = StatisticalDistribution.byCourtTypes(judgments);
        String res;
        for(CourtType courtType: stats.keySet()){
            res = courtType + ": " + stats.get(courtType);
            generateToOutput(res,history);
        }
    }

    public static void runByMonth(HashMap<String, Judgment> judgments, Path history) throws IOException  {
        int[] stats = StatisticalDistribution.byMonth(judgments);
        String res;
        for(int i = 0; i<12; i++){
            res = new DateFormatSymbols().getMonths()[i] + ": " + stats[i];
            generateToOutput(res,history);
        }
    }

    public static void runByJuryCount(HashMap<String, Judgment> judgments, Path history) throws IOException {
        HashMap<Integer, Integer> stats = StatisticalDistribution.byJuryCount(judgments);
        String res;
        for (Integer count: stats.keySet()){
            res = count + ": " + stats.get(count);
            generateToOutput(res,history);
        }
    }
}
