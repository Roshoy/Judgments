package Atributes;

import java.util.LinkedList;
import java.util.List;

public class Judge {
    public String name;
    public String function;
    public List<SpecialRole> specialRoles = new LinkedList<>();

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
}
