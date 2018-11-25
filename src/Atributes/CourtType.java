package Atributes;

public enum CourtType {
    COMMON, // sąd powszechny
    SUPREME, // Sąd Najwyższy
    ADMINISTRATIVE, // sąd administracyjny
    CONSTITUTIONAL_TRIBUNAL, // Trybunał Konstytucyjny
    NATIONAL_APPEAL_CHAMBER; // Krajowa Izba Odwoławcza

    public String toString(){
        switch(this){
            case COMMON:
                return "COMMON";
            case SUPREME:
                return "SUPREME";
            case ADMINISTRATIVE:
                return "ADMINISTRATIVE";
            case CONSTITUTIONAL_TRIBUNAL:
                return "CONSTITUTIONAL_TRIBUNAL";
            case NATIONAL_APPEAL_CHAMBER:
                return "NATIONAL_APPEAL_CHAMBER";
        }
        return "NON";
    }

}
