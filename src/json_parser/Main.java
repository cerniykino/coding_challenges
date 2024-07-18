package json_parser;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        String dir = System.getProperty("user.dir");


        System.out.println(dir);
        BufferedReader reader = new BufferedReader(new FileReader("src/json_parser/tests/step2/invalid2.json"));
        Lexer lexer = new Lexer(reader);
        Parser parser = new Parser(lexer);
        System.out.println(parser.basicStructure());
    }

}
