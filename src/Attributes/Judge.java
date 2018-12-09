package Attributes;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Judge extends JudgmentAttribute {
    private String name;
    private String function;
    private List<SpecialRole> specialRoles = new ArrayList<>();

    public Judge(){
        identifier = "judges";
    }
    public JudgmentAttribute read(JSONObject object){
        Judge judge = new Judge();
        judge.name = (String)object.get("name");
        judge.function = (String)object.get("function");
        JSONArray objArray = (JSONArray) object.get("specialRoles");
        for(Object obj: objArray){
            judge.getSpecialRoles().add(AttributesParser.specialRoleParser((String)obj));
        }
        return judge;
    }

    @Override
    public String toString() {
        String r = "";
        r = r + "Name: " + this.getName() + '\n';
        r = r + "Function: " + this.getFunction() + '\n';
        r += "Special Roles: ";
        for(SpecialRole sr : this.getSpecialRoles()){
            r = "/n- "+sr.toString();
        }
        return r;
    }

    @Override

    public boolean equals(Object obj) {
        if(obj == null) return false;
        if(!(obj instanceof Judge)) return false;
        return ((Judge) obj).getName().equals(this.getName()) ;
    }

    @Override
    public int hashCode() {
        int result=0;

        for (int i = 0; i< this.getName().length(); i++){
            result += this.getName().charAt(i)*73^(i);
        }

        return result;
    }


    public String getName() {
        return name;
    }

    public String getFunction() {
        return function;
    }

    public List<SpecialRole> getSpecialRoles() {
        return specialRoles;
    }
}
