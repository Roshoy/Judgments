package Attributes;

public enum SpecialRole {
    PRESIDING_JUDGE, // przewodniczacy składu sędziowskiego
    REPORTING_JUDGE, // sędzia sprawozdawca
    REASONS_FOR_JUDGMENT_AUTHOR; // autor uzasadnienia

    public String toString(){
        switch(this){
            case PRESIDING_JUDGE:
                return "PRESIDING_JUDGE";
            case REPORTING_JUDGE:
                return "REPORTING_JUDGE";
            case REASONS_FOR_JUDGMENT_AUTHOR:
                return "REASONS_FOR_JUDGMENT_AUTHOR";
        }
        return "NON";
    }
}
