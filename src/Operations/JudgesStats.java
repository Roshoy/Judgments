package Operations;

import Attributes.IJudgmentAttribute;
import Attributes.Judge;

import java.util.HashMap;

public class JudgesStats extends Operation{
    public JudgesStats(HashMap<String, HashMap<Integer,IJudgmentAttribute>> base){
        setBase(base);
    }

    public int judgmentsOfJudge(String name){
        Judge temp = new Judge();
        temp.setName(name);
        return ((Judge)getGivenBase("judges").get(temp.hashCode())).judgmentsIds.size();
    }

    public Judge[] topNJudges(int n){
        HashMap<Integer,IJudgmentAttribute> judges = getGivenBase("judges");
        if(judges.isEmpty() || n<=0)return new Judge[0];
        if(judges.size()<n) n = judges.size();
        Judge[] result = new Judge[n];
        Judge temp = new Judge();

        for(int i=0; i<n; i++){
            result[i] = temp;
        }

        for(IJudgmentAttribute judge: judges.values()){
            for(int i=0;i<n;i++){
                if(result[i].judgmentsIds.size()<((Judge)judge).judgmentsIds.size()){
                    result[i] = (Judge)judge;
                }
            }
        }
        return result;
    }
}
