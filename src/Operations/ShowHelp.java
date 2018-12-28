package Operations;

import java.io.IOException;
import java.nio.file.Path;

public class ShowHelp extends AbstractOperation {
    public static void help(Path history) throws IOException {
        StringBuilder res =  new StringBuilder();
        res.append("rubrum args: caseName1, caseName2, ... (bez \"\") - wyświetlenie metryki jednego");
        res.append("lub wielu orzeczeń, na podstawie sygnatury(na przykład \"II SA/OI 472/18\")\n");
        res.append("content arg: caseName - wyświetlenie uzasadnienia\n");
        res.append("judge arg: name- wyświetlał liczbę orzeczeń dla wybranego sędziego\n");
        res.append("judges - wyświetla 10 sędziów, którzy wydali najwięcej orzeczeń\n");
        res.append("months - wyświetlał liczbę orzeczeń w poszczególnych miesiącach (rozkład statystyczny)\n");
        res.append("courts - wyświetlał liczbę orzeczeń ze względu na typ sądu (rozkład statystyczny)\n");
        res.append("regulations - wyświetlał 10 najczęściej przywoływanych ustaw\n");
        res.append("jury - wyświetlał liczbę spraw przypadających na określony skład sędziowski ");
        res.append("(określoną liczbę sędziów)\n");

        generateToOutput(res.toString(),history);
    }
}
