package CommandParser;

public enum Command {
    RUBRUM,
    CONTENT,     //wyświetlenie uzasadnienia (czyli treści pola textContent lub treść od słowa "UZASADNIENIE")
    JUDGDE,       //wyświetlał liczbę orzeczeń dla wybranego sędziego
    JUDGES,      //wyświetla 10 sędziów, którzy wydali najwięcej orzeczeń
    MONTHS,      //wyświetlał liczbę orzeczeń w poszczególnych miesiącach (rozkład statystyczny)
    COURTS,      //wyświetlał liczbę orzeczeń ze względu na typ sądu (rozkład statystyczny)
    REGULATIONS, //wyświetlał 10 najczęściej przywoływanych ustaw
    JURY;

    @Override
    public String toString() {
        return this.name().toLowerCase();
    }

}
