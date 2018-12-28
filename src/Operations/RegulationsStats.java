package Operations;

import Attributes.IJudgmentAttribute;
import Attributes.Regulation;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class RegulationsStats extends AbstractOperation {
    private static List<Regulation> topNRegulations(HashMap<Integer,IJudgmentAttribute> regulations){
        int n = 10;
        n=n<regulations.size() ? n : regulations.size();
        List<Regulation> result = new ArrayList<>();
        for(IJudgmentAttribute judge: regulations.values()){
            for(int i=0;i<n && i<=result.size();i++){
                if(i==result.size() || result.get(i).judgmentsIds.size()<((Regulation)judge).judgmentsIds.size()){
                    result.add(i,(Regulation)judge);
                    i=n;
                }
            }
        }
        return result.subList(0,n);
    }

    public static void runTopNRegulation(HashMap<Integer, IJudgmentAttribute> regulations,
                                         Path history) throws IOException {
        List<Regulation> result = RegulationsStats.topNRegulations(regulations);
        String res;
        for(int i=0; i<result.size(); i++){
            res = (i+1) + ". " + result.get(i).getJournalTitle();
            generateToOutput(res, history);
        }
    }
}
