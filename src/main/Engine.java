package main;

import Judgments.Judgment;
import Judgments.JudgmentReader;
import Operations.ShowRubrum;
import SharedObjects.IBaseChangeObserver;
import SharedObjects.SharedObjectsBase;
import org.jline.reader.LineReader;
import org.jline.reader.LineReaderBuilder;
import org.jline.terminal.Terminal;
import org.jline.terminal.TerminalBuilder;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class Engine {
    public static void main(String[] args) {
        HashMap<String,Judgment> judgments;
        IBaseChangeObserver sharedObjectsBase = new SharedObjectsBase();

        try {
            File direction = new File(args[0]);

            JudgmentReader jr = new JudgmentReader(direction.getAbsolutePath(), sharedObjectsBase);
            judgments = jr.readAllFiles();
            //System.out.println(judgments.values().iterator().next());
            //System.out.println(new ShowRubrum(judgments).rubrum(38910));
            ///////terminal use


            Terminal terminal = TerminalBuilder.builder().system(true).build();
            LineReader lineReader = LineReaderBuilder.builder().terminal(terminal).build();
            String command;

            do {

                command = lineReader.readLine("Enter command> ");
                System.out.println("Got command: " + command);

            }
            while (command != null && command.length() > 0);
        }catch(IOException | ParseException e){
            e.getMessage();
        }
    }
}
