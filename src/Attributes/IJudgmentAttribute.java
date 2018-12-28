package Attributes;

import org.json.simple.JSONObject;

public interface IJudgmentAttribute {
    IJudgmentAttribute readFromJson(JSONObject object);
    String getIdentifier();
}
