package CommandReading;

import Judgments.Judgment;
import Operations.*;
import SharedObjects.IBaseChangeObserver;
import SharedObjects.SharedObjectsBase;

import java.io.IOException;
import java.nio.file.Path;
import java.util.HashMap;

public enum Command {
    RUBRUM,      //wyświetla rubrum wybranych spraw
    CONTENT,     //wyświetlenie uzasadnienia (czyli treści pola textContent lub treść od słowa "UZASADNIENIE")
    JUDGE,       //wyświetlał liczbę orzeczeń dla wybranego sędziego
    JUDGES,      //wyświetla 10 sędziów, którzy wydali najwięcej orzeczeń
    MONTHS,      //wyświetlał liczbę orzeczeń w poszczególnych miesiącach (rozkład statystyczny)
    COURTS,      //wyświetlał liczbę orzeczeń ze względu na typ sądu (rozkład statystyczny)
    REGULATIONS, //wyświetlał 10 najczęściej przywoływanych ustaw
    JURY,        //wyświetla liczbę orzeczeń na daną liczność składu sędziowskiego
    HELP;

    public void run(String[] args, HashMap<String, Judgment> judgments, IBaseChangeObserver commonDataBase,
                    Path history) throws IOException {
        switch(this) {
            case RUBRUM:
                ShowRubrum.run(args,judgments, history);
                break;
            case CONTENT://1 argument required
                if(args == null || args.length < 1) {
                    AbstractOperation.generateToOutput("Za mało argumentów, co najmniej " + 1, history);
                }
                else
                    ShowJustification.run(args[0],judgments, history);
                break;
            case JUDGES:
                JudgesStats.runTopNJudges(((SharedObjectsBase)commonDataBase).getJudges(), history);
                break;
            case JUDGE:
                JudgesStats.runJudgmentsOfJudge(args, ((SharedObjectsBase)commonDataBase).getJudges(), history);
                break;
            case MONTHS:
                StatisticalDistribution.runByMonth(judgments, history);
                break;
            case COURTS:
                StatisticalDistribution.runByCourtTypes(judgments, history);
                break;
            case REGULATIONS:
                RegulationsStats.runTopNRegulation(((SharedObjectsBase)commonDataBase).getRegulations(), history);
                break;
            case JURY:
                StatisticalDistribution.runByJuryCount(judgments, history);
                break;
            case HELP:
                ShowHelp.help(history);
        }
    }

}
