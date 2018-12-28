package Operations;

import Judgments.Judgment;

import java.io.IOException;
import java.nio.file.Path;
import java.util.HashMap;

public class ShowJustification extends AbstractOperation {

    private static String justification(String id, HashMap<String,Judgment> judgments){
        if(!judgments.containsKey(id))return "Brak podanej sprawy o identyfikatorze: " + id;
        Judgment judgment = judgments.get(id);
        return judgment.getTextContent();
    }

    public static void run(String arg, HashMap<String, Judgment> judgments, Path history) throws IOException {

        String res = "Uzasadnie dla " + arg + ":\n" + ShowJustification.justification(arg,judgments);
        generateToOutput(res, history);
    }
}
