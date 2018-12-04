package Attributes;

import org.json.simple.JSONObject;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class JudgmentSource extends JudgmentAttribute{
    SourceCode code;
    String judgmentUrl;
    String judgmentId;
    String publisher;
    String reviser;
    Date publicationDate;

    public JudgmentSource(){
        identifier = "source";
    }

    public JudgmentAttribute read(JSONObject object){
        JudgmentSource source = new JudgmentSource();
        source.code = AttributesParser.sourceCodeParser((String)object.get("code"));
        source.judgmentUrl = (String)object.get("judgmentUrl");
        source.publisher = (String)object.get("publisher");
        source.judgmentId = (String)object.get("judgmentId");
        source.reviser = (String)object.get("reviser");
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
        try {
            source.publicationDate = format.parse((String) object.get("publicationDate"));
        }catch(ParseException e){
            System.out.println(e.getMessage());
        }
        return source;
    }
}
