package Operations;

import Attributes.IJudgmentAttribute;
import Attributes.Judge;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class JudgesStats{

    public static int judgmentsOfJudge(String name, HashMap<String, IJudgmentAttribute> judges){
        Judge temp = new Judge();
        temp.setName(name);
        return ((Judge)judges.get(temp.hashCode())).judgmentsIds.size();
    }

    public static List<Judge> topNJudges(int n, HashMap<String, IJudgmentAttribute> judges){

        if(judges.isEmpty() || n<=0)return new LinkedList<>();

        List<Judge> result = new LinkedList<>();

        for(IJudgmentAttribute judge: judges.values()){
            for(int i=0;i<n;i++){
                if(result.get(i).judgmentsIds.size()<((Judge)judge).judgmentsIds.size()){
                    result.add(i,(Judge)judge);
                }
            }
        }
        return result;
    }
}
