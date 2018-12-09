package SharedObjects;

import Attributes.IJudgmentAttribute;
import Attributes.JudgmentAttribute;

import java.util.HashMap;
import java.util.HashSet;

public class SharedObjectsBase implements IBaseChangeObserver {
    //HashMap <Identifier of judgment attribute , HashSet <IJudgmentAttribute>> base
    private HashMap<String, HashSet<IJudgmentAttribute>> base = new HashMap<>();
    private HashSet<IJudgmentAttribute> courtCases = new HashSet<>(); // najpierw tylko courtcases ogarniam

    public SharedObjectsBase(){
        base.put("courtCases",new HashSet<>());
        base.put("referencedRegulations",new HashSet<>());
        base.put("referencedCourtCases",new HashSet<>());
        base.put("judges",new HashSet<>());
        base.put("source",new HashSet<>());

    }

    @Override
    public void updateBase(IJudgmentAttribute object) {
        if(!object.getIdentifier().equals("dissentingOpinions")) {
           base.get(object.getIdentifier()).add(object);
        }

    }
}
