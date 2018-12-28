package main;

import CommandReading.Command;
import CommandReading.CommandReader;
import Judgments.Judgment;
import Judgments.JudgmentReader;
import Operations.ShowRubrum;
import SharedObjects.IBaseChangeObserver;
import SharedObjects.SharedObjectsBase;
import org.jline.reader.Completer;
import org.jline.reader.LineReader;
import org.jline.reader.LineReaderBuilder;
import org.jline.reader.impl.completer.completer.StringsCompleter;
import org.jline.terminal.Terminal;
import org.jline.terminal.TerminalBuilder;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class Engine {
    public static void main(String[] args) {
        HashMap<String,Judgment> judgments;
        IBaseChangeObserver sharedObjectsBase = new SharedObjectsBase();

        try {
            ////////////////handling files
            File direction = new File(args[0]);
            System.out.println(args[0]);
            //Path history = null;
            Path history = createHistoryFile(args);

            ///////////////reading json
            JudgmentReader jr = new JudgmentReader(sharedObjectsBase);
            judgments = jr.readFromPath(direction.getAbsolutePath());

            //////////////setting up interactive console
            Terminal terminal = TerminalBuilder.builder().system(true).build();
            String command;
            Completer completer = new StringsCompleter("rubrum",      //wyświetla rubrum wybranych spraw
                    "content",     //wyświetlenie uzasadnienia (czyli treści pola textContent lub treść od słowa "UZASADNIENIE")
                    "judge",       //wyświetlał liczbę orzeczeń dla wybranego sędziego
                    "judges",      //wyświetla 10 sędziów, którzy wydali najwięcej orzeczeń
                    "months",      //wyświetlał liczbę orzeczeń w poszczególnych miesiącach (rozkład statystyczny)
                    "courts",      //wyświetlał liczbę orzeczeń ze względu na typ sądu (rozkład statystyczny)
                    "regulations", //wyświetlał 10 najczęściej przywoływanych ustaw
                    "jury",
                    "help",
                    "exit");
            LineReader lineReader = LineReaderBuilder.builder().terminal(terminal).completer(completer).build();
            CommandReader commandReader = new CommandReader(judgments,sharedObjectsBase,history);
            //////////////using console
            do {
                command = lineReader.readLine("Enter command> ");
                commandReader.readLine(command);
            }
            while (command != null && command.length() > 0 && !command.equals("exit"));
        }catch(IOException | ParseException e){
            System.out.println(e.getMessage());
        }finally {
            System.out.println("Dziękujemy za użytkowanie <3");
        }
    }

    private static Path createHistoryFile(String[] args) throws IOException {

        Path history = null;
        if(args.length == 2) {
            history = Paths.get(args[1]);
            File tmp = new File(args[1]);
            if(!tmp.exists()){
                Files.createFile(history);
            }
        }
        return history;
    }
}
