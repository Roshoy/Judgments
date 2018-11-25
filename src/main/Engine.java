package main;

import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.IOException;

public class Engine {
    public static void main(String[] args) {
        try {
            File direction = new File(args[0]);

            JudgmentReader jr = new JudgmentReader(direction.getAbsolutePath());
            jr.readAllFiles();

        }catch(IOException | ParseException e){
            e.getMessage();
        }
    }
}
