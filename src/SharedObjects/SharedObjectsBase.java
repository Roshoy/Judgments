package SharedObjects;

import Attributes.IJudgmentAttribute;
import Attributes.Regulation;
import org.jline.utils.Levenshtein;

import java.util.Collection;
import java.util.HashMap;


public class SharedObjectsBase implements IBaseChangeObserver {
    //HashMap <Identifier of judgment attribute , HashSet <IJudgmentAttribute>> base
    private HashMap<String, HashMap<Integer,IJudgmentAttribute>> base = new HashMap<>();

    public SharedObjectsBase(){
        this.base.put("referencedRegulations",new HashMap<>());
//        base.put("referencedCourtCases",new HashMap<>());
        this.base.put("judges",new HashMap<>());
//        base.put("source",new HashMap<>());

    }


    public IJudgmentAttribute updateBaseJudges(IJudgmentAttribute object) {

            if( this.base.get(object.getIdentifier()).containsKey(object.hashCode()))
                return this.base.get(object.getIdentifier()).get(object.hashCode());
           this.base.get(object.getIdentifier()).put(object.hashCode(),object);

        return object;

    }

    public IJudgmentAttribute updateBaseRegulations (IJudgmentAttribute object){
        String title = ((Regulation)object).getJournalTitle();
        int distEq1 = 0;
        int minLevDist = 5;
        IJudgmentAttribute closest = null;
        Collection<IJudgmentAttribute> collection = this.base.get(object.getIdentifier()).values();
        for(IJudgmentAttribute regInBase: collection){
            int distance = Levenshtein.distance(title,((Regulation)regInBase).getJournalTitle());
            if(distance < minLevDist){
                minLevDist = distance;
                closest = regInBase;
            }
            if(distance == 1)distEq1++;
            if(distance == 0)return closest;
        }
        if(distEq1 >1) System.out.println("Dużo podobnych!");
        if(minLevDist<=2 && distEq1 < 3)return closest;
        this.base.get(object.getIdentifier()).put(object.hashCode(),object);
        return object;

    }

    public HashMap<Integer, IJudgmentAttribute> getRegulations(){
        return base.get("referencedRegulations");
    }

    public HashMap<Integer, IJudgmentAttribute> getJudges() {
        return base.get("judges");
    }
}
