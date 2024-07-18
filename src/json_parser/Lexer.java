package json_parser;

import java.io.BufferedReader;

public class Lexer {
    private int current;
    private BufferedReader reader;

    public Lexer(BufferedReader reader) {
        this.reader = reader;
        this.current = -1;
        consume();
    }

    public Token nextToken(){
        switch (this.current){
            case '{':
                consume();
                return Token.LEFT_CURLY_BRACE;
            case '}':
                consume();
                return Token.RIGHT_CURLY_BRACE;
            default:
                return Token.NULL;
        }
    }
    private void consume(){
        try {
            this.current = this.reader.read();
        } catch (Exception e) {
            throw new RuntimeException("Error reading from input");
        }
    }
}
