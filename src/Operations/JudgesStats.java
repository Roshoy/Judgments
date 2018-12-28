package Operations;

import Attributes.IJudgmentAttribute;
import Attributes.Judge;

import java.io.IOException;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class JudgesStats extends AbstractOperation {

    private static int judgmentsOfJudge(String name, HashMap<Integer, IJudgmentAttribute> judges){
        Judge temp = new Judge();
        temp.setName(name);
        if(!judges.containsKey(temp.hashCode()))return 0;
        return ((Judge)judges.get(temp.hashCode())).judgmentsIds.size();
    }

    private static List<Judge> topNJudges(int n, HashMap<Integer, IJudgmentAttribute> judges){
        n = n<judges.size() ? n : judges.size();
        if(judges.isEmpty() || n<=0)return new LinkedList<>();

        List<Judge> result = new LinkedList<>();

        for(IJudgmentAttribute judge: judges.values()){

            for(int i=0;i<n && i<=result.size();i++){

                if(i==result.size() || result.get(i).judgmentsIds.size()<((Judge)judge).judgmentsIds.size()){

                    result.add(i,(Judge)judge);
                    i=n;
                }
            }

        }
        return result.subList(0,n);
    }

    public static void runJudgmentsOfJudge(String[] args, HashMap<Integer,
            IJudgmentAttribute> judges, Path history) throws IOException {
        String res;
        if(args == null || args.length < 1){
            res = "Za mało argumentów, co najmniej " + 1;
            generateToOutput(res,history);
            return;
        }
        for(String arg: args) {
            res = "Dla " + arg + " liczba orzeczeń to: " + JudgesStats.judgmentsOfJudge(arg, judges);
            generateToOutput(res, history);
        }
    }

    public static void runTopNJudges(HashMap<Integer, IJudgmentAttribute> judges, Path history) throws IOException {
        int n = 10;
        List<Judge> result = JudgesStats.topNJudges(n,judges);
        n = n>result.size() ? n : result.size();
        String res;
        for(int i=0; i<n; i++){
            res = (i+1) + ". " + result.get(i).getName();
            generateToOutput(res,history);
        }
    }
}
