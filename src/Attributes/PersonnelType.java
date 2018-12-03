package Attributes;

public enum PersonnelType {
    ONE_PERSON, // skład jednoosobowy
    THREE_PERSON, // trzyosobowy
    FIVE_PERSON, // pięcioosobowy
    SEVEN_PERSON, // siedmioosobowy
    ALL_COURT, // skład całego Sądu Najwyższego
    ALL_CHAMBER, // skład pełnej izby
    JOINED_CHAMBERS; // skład połączonych izb

    @Override
    public String toString() {
        switch(this){
            case ONE_PERSON:
                return "ONE_PERSON";
            case THREE_PERSON:
                return "THREE_PERSON";
            case FIVE_PERSON:
                return "FIVE_PERSON";
            case SEVEN_PERSON:
                return "SEVEN_PERSON";
            case ALL_COURT:
                return "ALL_COURT";
            case ALL_CHAMBER:
                return "ALL_CHAMBER";
            case JOINED_CHAMBERS:
                return "JOINED_CHAMBERS";
        }
        return "NON";
    }
}
