import java.io.*;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        File myFile =  new File(args[args.length-1]);

        FileProperties fileProperties = new FileProperties(myFile);
        List<String> arguments = Arrays.asList(args);

        if(arguments.contains("-l")){
            System.out.println(fileProperties.getCountLines() + " " + args[args.length-1]);
        }
        if(arguments.contains("-c")){
            System.out.println(fileProperties.getCountBytes() + " " + args[args.length-1]);
        }
        if(arguments.contains("-m")){
            System.out.println(fileProperties.getCountChars() + " " + args[args.length-1]);
        }
        if(arguments.contains("-w")){
            System.out.println(fileProperties.getCountWords() + " " + args[args.length-1]);
        }
        if(args.length == 1)
        {
            System.out.println(fileProperties.getCountLines() + " " + fileProperties.getCountChars() + " " + fileProperties.getCountBytes() + " " + args[args.length-1]);
        }

    }
    public static String getInput() {
        StringBuilder sb = new StringBuilder();
        final Scanner scanner = new Scanner(System.in);
        for (String line = scanner.nextLine(); !line.isEmpty(); line = scanner.nextLine()) {
            sb.append(line).append(System.lineSeparator());
        }
        return sb.isEmpty() ? null : sb.toString();
    }
}