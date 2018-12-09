package Operations;

import Attributes.IJudgmentAttribute;
import Attributes.Judge;
import Judgments.Judgment;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;

public class ShowRubrum extends Operation{
//    umożliwiał wyświetlanie metryki (rubrum) orzeczenia o wybranej sygnaturze; metryka powinna zawierać:
//    sygnaturę orzeczenia
//    datę wydania orzeczenia
//    rodzaj sądu (sąd powszechny, Trybunał Konstytucyjny, Sąd Najwyższy, ...)
//    skład (listę sędziów z przypisanymi rolami)

    public ShowRubrum(HashMap<Long, Judgment> judgments){
        setJudgments(judgments);
    }

    public String[] multipleRubrums(int[] ids){
        String[] rubrums = new String[ids.length];
        for(int i=0 ; i<ids.length; i++){
            rubrums[i] = rubrum(ids[i]);
        }
        return rubrums;
    }

    public String rubrum(int id){
        Judgment judgment = getJudgment(id);
        String rubrum = "RUBRUM:\n";

        rubrum += "ID: " + judgment.getId() + '\n';
        Calendar cal = Calendar.getInstance();
        cal.setTime(judgment.getJudgmentDate());
        rubrum += "Data wydania orzeczenia: " + cal.get(Calendar.YEAR) + "-" + (cal.get(Calendar.MONTH)+1) + "-" +
                   cal.get(Calendar.DAY_OF_MONTH) + '\n';
        rubrum += "Rodzaj sądu: " + judgment.getCourtType() + '\n';
        rubrum += "Sędziowie:\n";
        for(IJudgmentAttribute judge: judgment.getJudges()){
            rubrum += judge.toString() + '\n';
        }

        return rubrum;
    }

}
