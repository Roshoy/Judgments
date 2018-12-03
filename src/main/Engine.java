package main;

import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Engine {
    public static void main(String[] args) {
        List<Judgment> judgments = new ArrayList<>();
        try {
            File direction = new File(args[0]);

            JudgmentReader jr = new JudgmentReader(direction.getAbsolutePath());
            judgments = jr.readAllFiles();

            Iterator<Judgment> iterator = judgments.iterator();
            while(iterator.hasNext()){

                System.out.println("j: " + iterator.next().toString());
            }


        }catch(IOException | ParseException e){
            e.getMessage();
        }
    }
}
