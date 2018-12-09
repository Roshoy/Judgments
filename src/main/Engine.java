package main;

import Judgments.Judgment;
import Judgments.JudgmentReader;
import SharedObjects.IBaseChangeObserver;
import SharedObjects.SharedObjectsBase;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Engine {
    public static void main(String[] args) {
        List<Judgment> judgments = new ArrayList<>();
        IBaseChangeObserver sharedObjectsBase = new SharedObjectsBase();
        try {
            File direction = new File(args[0]);

            JudgmentReader jr = new JudgmentReader(direction.getAbsolutePath(), sharedObjectsBase);
            judgments = jr.readAllFiles();

            Iterator<Judgment> iterator = judgments.iterator();
            if(iterator.hasNext()){

                //System.out.println(iterator.next().toString());
            }


        }catch(IOException | ParseException e){
            e.getMessage();
        }
    }
}
