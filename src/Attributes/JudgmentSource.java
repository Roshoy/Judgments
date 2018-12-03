package Attributes;

import org.json.simple.JSONObject;

import java.util.Date;

public class JudgmentSource implements IJudgmentAttribute{
    SourceCode code;
    String judgmentUrl;
    String judgmentId;
    String publisher;
    String reviser;
    Date publicationDate;

    public void read(JSONObject object){
        this.code = AttributesParser.sourceCodeParser((String)object.get("code"));
        this.judgmentUrl = (String)object.get("judgmentUrl");
        this.publisher = (String)object.get("publisher");
        this.judgmentId = (String)object.get("judgmentId");
        this.reviser = (String)object.get("reviser");
        this.publicationDate = (Date)object.get("publicationDate");
    }
}
