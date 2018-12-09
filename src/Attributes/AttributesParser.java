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

    public static JudgmentType judgmentTypeParser(String arg){
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

    public static PersonnelType personnelTypeParser(String arg){
        if(arg==null)return null;
        switch(arg){
            case "ONE_PERSON":
                return PersonnelType.ONE_PERSON;
            case "THREE_PERSON":
                return PersonnelType.THREE_PERSON;
            case "FIVE_PERSON":
                return PersonnelType.FIVE_PERSON;
            case "SEVEN_PERSON":
                return PersonnelType.SEVEN_PERSON;
            case "ALL_COURT":
                return PersonnelType.ALL_COURT;
            case "ALL_CHAMBER":
                return PersonnelType.ALL_CHAMBER;
            case "JOINED_CHAMBERS":
                return PersonnelType.JOINED_CHAMBERS;
        }
        return PersonnelType.ONE_PERSON;
    }

    public static SourceCode sourceCodeParser(String arg){
        switch(arg){
            case "COMMON_COURT":
                return SourceCode.COMMON_COURT;
            case "SUPREME_COURT":
                return SourceCode.SUPREME_COURT;
            case "CONSTITUTIONAL_TRIBUNAL":
                return SourceCode.CONSTITUTIONAL_TRIBUNAL;
            case "NATIONAL_APPEAL_CHAMBER":
                return SourceCode.NATIONAL_APPEAL_CHAMBER;
        }
        return SourceCode.COMMON_COURT;
    }

    public static SpecialRole specialRoleParser(String arg){
        switch(arg){
            case "PRESIDING_JUDGE":
                return SpecialRole.PRESIDING_JUDGE;
            case "REPORTING_JUDGE":
                return SpecialRole.REPORTING_JUDGE;
            case "REASONS_FOR_JUDGMENT_AUTHOR":
                return SpecialRole.REASONS_FOR_JUDGMENT_AUTHOR;
        }
        return SpecialRole.PRESIDING_JUDGE;
    }
}
