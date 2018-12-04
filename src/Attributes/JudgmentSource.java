package Attributes;

import org.json.simple.JSONObject;

import java.util.Date;

public class JudgmentSource extends JudgmentAttribute{
    SourceCode code;
    String judgmentUrl;
    String judgmentId;
    String publisher;
    String reviser;
    Date publicationDate;

    private String identifier = "source";

    public String getIdentifier() {
        return identifier;
    }

    public static JudgmentAttribute read(JSONObject object){
        JudgmentSource source = new JudgmentSource();
        source.code = AttributesParser.sourceCodeParser((String)object.get("code"));
        source.judgmentUrl = (String)object.get("judgmentUrl");
        source.publisher = (String)object.get("publisher");
        source.judgmentId = (String)object.get("judgmentId");
        source.reviser = (String)object.get("reviser");
        source.publicationDate = (Date)object.get("publicationDate");
        return source;
    }
}
