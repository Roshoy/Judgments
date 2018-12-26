package CommandParser;


import Judgments.Judgment;
import Operations.ShowRubrum;

import java.util.HashMap;

public class CommandReader {
    private HashMap<String, Judgment> judgments;
    CommandReader(HashMap<String, Judgment> judgments){
        this.judgments = judgments;
    }

    public void parseCommand(String commandLine){
        String[] words = commandLine.split(" ");
        if(words.length == 0)return;
        String[] possibleCommands = {
                "rubrum",
                "content",     //wyświetlenie uzasadnienia (czyli treści pola textContent lub treść od słowa "UZASADNIENIE")
                "judge",       //wyświetlał liczbę orzeczeń dla wybranego sędziego
                "judges",      //wyświetla 10 sędziów, którzy wydali najwięcej orzeczeń
                "months",      //wyświetlał liczbę orzeczeń w poszczególnych miesiącach (rozkład statystyczny)
                "courts",      //wyświetlał liczbę orzeczeń ze względu na typ sądu (rozkład statystyczny)
                "regulations", //wyświetlał 10 najczęściej przywoływanych ustaw
                "jury"};

    }

    private void exeRubrum(String[] args){
        ShowRubrum.rubrum(args[0],judgments);
        for(String arg: args){

        }
    }


}
