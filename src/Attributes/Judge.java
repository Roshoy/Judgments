package Attributes;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Judge extends JudgmentAttribute {
    private String name;
    public List<String> judgmentsIds = new LinkedList<>();

    public Judge(){
        identifier = "judges";
    }
    public JudgmentAttribute readFromJson(JSONObject object){
        Judge judge = new Judge();
        judge.name = (String)object.get("name");
        JSONArray objArray = (JSONArray) object.get("specialRoles");
        return judge;
    }

    @Override
    public String toString() {
        String r = "";
        r = r + "Name: " + this.getName() + '\n';
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

    public void setName(String name){
        this.name = name;
    }
}
