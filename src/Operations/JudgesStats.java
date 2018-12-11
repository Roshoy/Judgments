package Operations;

import Attributes.IJudgmentAttribute;
import Attributes.Judge;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class JudgesStats extends Operation{
    public JudgesStats(HashMap<String, HashMap<Integer,IJudgmentAttribute>> base){
        setBase(base);
    }

    public int judgmentsOfJudge(String name){
        Judge temp = new Judge();
        temp.setName(name);
        return ((Judge)getGivenBase("judges").get(temp.hashCode())).judgmentsIds.size();
    }

    public List<Judge> topNJudges(int n){
        HashMap<Integer,IJudgmentAttribute> judges = getGivenBase("judges");
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
