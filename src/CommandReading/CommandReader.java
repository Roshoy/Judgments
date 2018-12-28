package CommandReading;


import Judgments.Judgment;
import Operations.AbstractOperation;
import SharedObjects.IBaseChangeObserver;
import org.jline.utils.Levenshtein;

import java.io.IOException;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class CommandReader {
    private HashMap<String, Judgment> judgments;
    private IBaseChangeObserver commonDataBase;
    private Path history;

    public CommandReader(HashMap<String, Judgment> judgments, IBaseChangeObserver commonDataBase, Path history){
        this.judgments = judgments;
        this.commonDataBase = commonDataBase;
        this.history = history;
    }


    private String proposeCommand(String command) {
        int min = 6; // dlugosc rubrum
        String res = "rubrum";
        for(Command template: Command.values()){
            String temp = template.name().toLowerCase();
            int lev = Levenshtein.distance(temp,command);
            if(lev < min){
                min = lev;
                res = temp;
            }
        }

        return res;
    }

    public void readLine(String commandLine) throws IOException{
        commandLine = commandLine.trim();
        String[] words = commandLine.split(" ",2 ); // split command and arguments
        if(words.length == 0)return;
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("[yyyy/MM/dd HH:mm:ss]");
        LocalDateTime now = LocalDateTime.now();
        if(this.history!=null)AbstractOperation.generateToFile(dtf.format(now) + " " + words[0],this.history);
        if(commandIsCorrect(words[0])){
            parseCommand(commandLine);
        }else{
            if(words[0].length()!=0) {
                AbstractOperation.generateToOutput("Czy chodziło o " + proposeCommand(words[0]) + "?",
                        this.history);
            }
//            if(words[0].length()!=0) {
//                System.out.println("Niepoprawna komenda!");
//            }
        }

    }


    private boolean commandIsCorrect(String commandLine){

        List<Command> template = new LinkedList<>(Arrays.asList(Command.values()));
        for(Command temp : template){
            if(temp.name().toLowerCase().equals(commandLine)) return true;
        }
        return false;
    }

    //////////////gets complete and properly constructed input
    private void parseCommand(String commandLine) throws IOException {

        String[] words = commandLine.split(" ",2 ); // split command and arguments

        Command command = Command.valueOf(words[0].toUpperCase());
        command.run(getCommandArgs(words), this.judgments, this.commonDataBase, this.history);
    }

    private String[] getCommandArgs(String[] args){
        String[] result;
        if(args.length < 2) return null;
        result = args[1].split(","); //arguments bordered by ","
        for(int i=0; i<result.length; i++) {
            result[i] = result[i].trim();
        }

        /////usuwanie pustych argumentów
        LinkedList<String> temp = new LinkedList<>();
        for(String str: result){
            if(str.length()!=0){
                temp.addLast(str);
            }
        }
        if(temp.isEmpty())
            return null;
        else
            temp.toArray(result);

        return result;
    }



}
