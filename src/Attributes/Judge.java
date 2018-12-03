package Attributes;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Judge implements IJudgmentAttribute {
    public String name;
    public String function;
    public List<SpecialRole> specialRoles = new ArrayList<>();

    public void read(JSONObject object){
        this.name = (String)object.get("name");
        this.function = (String)object.get("function");
        JSONArray objArray = (JSONArray) object.get("specialRoles");
        for(Object obj: objArray){
            this.specialRoles.add((SpecialRole) obj);
        }
    }

    @Override
    public String toString() {
        String r = "";
        r = r + "Name: " + this.name + '\n';
        r = r + "Function: " + this.function + '\n';
        r += "Special Roles: ";
        for(SpecialRole sr : this.specialRoles){
            r = "/n- "+sr.toString();
        }
        return r;
    }

    @Override
    //equals when name and function are equal
    public boolean equals(Object obj) {
        if(!(obj instanceof Judge)) return false;
        return ((Judge)obj).name.equals(this.name) &&
                ((Judge)obj).function.equals(this.function);
    }
}
