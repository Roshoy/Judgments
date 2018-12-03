package Attributes;

public enum SourceCode {
    COMMON_COURT, // sąd powszechny
    SUPREME_COURT, // Sąd Najwyższy
    CONSTITUTIONAL_TRIBUNAL, // Trybunał Konstytucyjny
    NATIONAL_APPEAL_CHAMBER; // Krajowa Izba Odwoławcza
    public String toString(){
        switch(this){
            case COMMON_COURT:
                return "COMMON_COURT";
            case SUPREME_COURT:
                return "SUPREME_COURT";
            case CONSTITUTIONAL_TRIBUNAL:
                return "CONSTITUTIONAL_TRIBUNAL";
            case NATIONAL_APPEAL_CHAMBER:
                return "NATIONAL_APPEAL_CHAMBER";
        }
        return "NON";
    }
}
