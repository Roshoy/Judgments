package Attributes;


public class AttributesParser {
    public static CourtType courtTypeParser(String arg){
        switch(arg){
            case "COMMON":
                return CourtType.COMMON;
            case "SUPREME":
                return CourtType.SUPREME;
            case "ADMINISTRATIVE":
                return CourtType.ADMINISTRATIVE;
            case "CONSTITUTIONAL_TRIBUNAL":
                return CourtType.CONSTITUTIONAL_TRIBUNAL;
            case "NATIONAL_APPEAL_CHAMBER":
                return CourtType.NATIONAL_APPEAL_CHAMBER;
        }
        return CourtType.COMMON;
    }

}
