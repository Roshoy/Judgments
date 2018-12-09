package Attributes;

import org.json.simple.JSONObject;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class JudgmentSource extends JudgmentAttribute{
    private SourceCode code;
    private String judgmentUrl;
    private String judgmentId;
    private String publisher;
    private String reviser;
    private Date publicationDate;

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
            if(((String) object.get("publicationDate")).equals(""))
                source.publicationDate = format.parse("0000-00-00");
            else
                source.publicationDate = format.parse((String) object.get("publicationDate"));
        }catch(ParseException e){
            System.out.println(e.getMessage());
        }
        return source;
    }

    @Override
    public String toString() {
        if (this.getCode() == null)return "NULL";
        return this.getCode().toString();
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null)return false;
        if(!(obj instanceof JudgmentSource))return false;
        return ((JudgmentSource) obj).getJudgmentId().equals(this.getJudgmentId());
    }

    @Override
    public int hashCode() {
        int result=0;

        for (int i = 0; i< this.getJudgmentId().length(); i++){
            result += this.getJudgmentId().charAt(i)*73^(i);
        }

        return result;
    }

    public SourceCode getCode() {
        return code;
    }

    public String getJudgmentUrl() {
        return judgmentUrl;
    }

    public String getJudgmentId() {
        return judgmentId;
    }

    public String getPublisher() {
        return publisher;
    }

    public String getReviser() {
        return reviser;
    }

    public Date getPublicationDate() {
        return publicationDate;
    }
}
