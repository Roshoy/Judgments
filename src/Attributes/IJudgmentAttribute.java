package Attributes;

import org.json.simple.JSONObject;

public interface IJudgmentAttribute {
    IJudgmentAttribute read(JSONObject object);
    String getIdentifier();
}
