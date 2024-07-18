package json_parser;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        String dir = System.getProperty("user.dir");


        System.out.println(dir);
        BufferedReader reader = new BufferedReader(new FileReader("src/json_parser/tests/step1/invalid.json"));
        Lexer lexer = new Lexer(reader);
        Parser parser = new Parser(lexer);
        System.out.println(parser.basicStructure());
    }

}
