package Operations;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

import java.util.LinkedList;
import java.util.List;

public abstract class AbstractOperation {
    public static void generateToOutput(String arg, Path history) throws IOException{

        System.out.println(arg);
        // do pliku -> arg
        generateToFile(arg,history);
    }

    public static void generateToFile(String arg, Path history) throws IOException{
        List<String> argL= new LinkedList<>();

        argL.add(arg);

        Files.write(history,argL,Charset.forName("UTF-8"), StandardOpenOption.APPEND);
    }
}
