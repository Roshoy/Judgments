package Attributes;

public enum JudgmentType {
    DECISION, // postanowienie
    RESOLUTION, // uchwała
    SENTENCE, // wyrok
    REGULATION, // zarządzenie
    REASONS; // uzasadnienie, system źródłowy orzeczeń sądów powszechnych czasem dzieli orzeczenie na dwa odrębne: orzeczenie i jego uzasadnienie
    public String toString(){
        switch(this){
            case REASONS:
                return "REASONS";
            case DECISION:
                return "DECISION";
            case SENTENCE:
                return "SENTENCE";
            case REGULATION:
                return "REGULATION";
            case RESOLUTION:
                return "RESOLUTION";
        }
        return "NON";
    }


}
