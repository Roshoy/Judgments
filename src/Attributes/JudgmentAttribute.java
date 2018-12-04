package Attributes;

import org.json.simple.JSONObject;

abstract public class JudgmentAttribute implements IJudgmentAttribute {
    protected String identifier;
    public String getIdentifier(){return this.identifier;}
}
