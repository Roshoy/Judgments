package Operations;

import Attributes.IJudgmentAttribute;
import Attributes.Judge;
import Judgments.Judgment;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;

public class ShowRubrum extends AbstractOperation {
//    umożliwiał wyświetlanie metryki (rubrum) orzeczenia o wybranej sygnaturze; metryka powinna zawierać:
//    sygnaturę orzeczenia
//    datę wydania orzeczenia
//    rodzaj sądu (sąd powszechny, Trybunał Konstytucyjny, Sąd Najwyższy, ...)
//    skład (listę sędziów z przypisanymi rolami)



    private static String rubrum(String id, HashMap<String, Judgment> judgments){

        if(!judgments.containsKey(id))return "Brak podanej sprawy o identyfikatorze: " + id;
        Judgment judgment = judgments.get(id);
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("RUBRUM:\n");
        for(String caseNumber: judgment.getCourtCases()){
            stringBuilder.append(caseNumber + '\n');
        }
        Calendar cal = Calendar.getInstance();
        cal.setTime(judgment.getJudgmentDate());
        stringBuilder.append("Data wydania orzeczenia: " + cal.get(Calendar.YEAR) + "-" + (cal.get(Calendar.MONTH)+1)
                             + "-" + cal.get(Calendar.DAY_OF_MONTH) + '\n');
        stringBuilder.append("Rodzaj sądu: " + judgment.getCourtType() + '\n');
        stringBuilder.append("Sędziowie:\n");
        for(IJudgmentAttribute judge: judgment.getJudges()){
            stringBuilder.append(((Judge)judge).getName() + '\n');
        }

        return stringBuilder.toString();
    }

    public static void run(String[] args, HashMap<String, Judgment> judgments, Path history) throws IOException {
        String res;
        if(args == null || args.length < 1){
            res = "Za mało argumentów, co najmniej " + 1;
            generateToOutput(res,history);
            return;
        }

        for(String arg:args){
            res = arg + ":\n" + ShowRubrum.rubrum(arg,judgments);
            generateToOutput(res,history);
        }
    }

}
