package Atributes;


public class AtributesParser {
    public CourtType courtTypeParser(String arg){
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

    public JudgmentType judgmentTypeParser(String arg){
        switch(arg){
            case "REASONS":
                return JudgmentType.REASONS;
            case "DECISION":
                return JudgmentType.DECISION;
            case "SENTENCE":
                return JudgmentType.SENTENCE;
            case "REGULATION":
                return JudgmentType.REGULATION;
            case "RESOLUTION":
                return JudgmentType.RESOLUTION;
        }
        return JudgmentType.DECISION;
    }
}
