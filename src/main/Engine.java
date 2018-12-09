package main;

import Judgments.Judgment;
import Judgments.JudgmentReader;
import Operations.ShowRubrum;
import SharedObjects.IBaseChangeObserver;
import SharedObjects.SharedObjectsBase;
import org.jline.reader.LineReader;
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
        HashMap<Long,Judgment> judgments;
        IBaseChangeObserver sharedObjectsBase = new SharedObjectsBase();

        TerminalBuilder terminalBuilder = TerminalBuilder.builder();





        try {
            File direction = new File(args[0]);

            JudgmentReader jr = new JudgmentReader(direction.getAbsolutePath(), sharedObjectsBase);
            judgments = jr.readAllFiles();
            System.out.println(new ShowRubrum(judgments).rubrum(38910));


        }catch(IOException | ParseException e){
            e.getMessage();
        }
    }
}
