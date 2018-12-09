package SharedObjects;

import Attributes.IJudgmentAttribute;
import Attributes.JudgmentAttribute;

import java.util.HashMap;
import java.util.HashSet;

public class SharedObjectsBase implements IBaseChangeObserver {
    //HashMap <Identifier of judgment attribute , HashSet <IJudgmentAttribute>> base
    private HashMap<String, HashMap<Integer,IJudgmentAttribute>> base = new HashMap<>();

    public SharedObjectsBase(){
        base.put("courtCases",new HashMap<>());
        base.put("referencedRegulations",new HashMap<>());
        base.put("referencedCourtCases",new HashMap<>());
        base.put("judges",new HashMap<>());
        base.put("source",new HashMap<>());

    }

    @Override
    public IJudgmentAttribute updateBase(IJudgmentAttribute object) {
        if(!object.getIdentifier().equals("dissentingOpinions")) {
            if( base.get(object.getIdentifier()).containsKey(object.hashCode()))
                return base.get(object.getIdentifier()).get(object.hashCode());
           base.get(object.getIdentifier()).put(object.hashCode(),object);
        }
        return object;

    }
}
