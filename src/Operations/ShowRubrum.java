package Operations;

import Attributes.IJudgmentAttribute;
import Attributes.Judge;
import Judgments.Judgment;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;

public class ShowRubrum{
//    umożliwiał wyświetlanie metryki (rubrum) orzeczenia o wybranej sygnaturze; metryka powinna zawierać:
//    sygnaturę orzeczenia
//    datę wydania orzeczenia
//    rodzaj sądu (sąd powszechny, Trybunał Konstytucyjny, Sąd Najwyższy, ...)
//    skład (listę sędziów z przypisanymi rolami)



    public static String rubrum(String id, HashMap<String, Judgment> judgments){
        Judgment judgment = judgments.get(id);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("RUBRUM:\n");
        stringBuilder.append("ID: " + judgment.getId() + '\n');

        Calendar cal = Calendar.getInstance();
        cal.setTime(judgment.getJudgmentDate());
        stringBuilder.append("Data wydania orzeczenia: " + cal.get(Calendar.YEAR) + "-" + (cal.get(Calendar.MONTH)+1)
                             + "-" + cal.get(Calendar.DAY_OF_MONTH) + '\n');
        stringBuilder.append("Rodzaj sądu: " + judgment.getCourtType() + '\n');
        stringBuilder.append("Sędziowie:\n");
        for(IJudgmentAttribute judge: judgment.getJudges()){
            stringBuilder.append(judge.toString() + '\n');
        }

        return stringBuilder.toString();
    }

}
