package json_parser;

import java.io.BufferedReader;
import java.io.IOException;

public class Lexer {
    private int current;
    private BufferedReader reader;

    public Lexer(BufferedReader reader) {
        this.reader = reader;
        this.current = -1;
        consume();
    }

    public Token nextToken() throws IOException {
        if (this.current == '{') {
            consume();
            return Token.LEFT_CURLY_BRACE;
        } else if (this.current == '}') {
            consume();
            return Token.RIGHT_CURLY_BRACE;
        } else if (this.current == '"') {
            consume();
            return Token.DOUBLE_QUOTES;
        } else if (this.current == ':') {
            consume();
            return Token.COLON;
        } else if ((this.current >= 65 && this.current <= 90) || (this.current >=97 && this.current <= 122) || (this.current >= 48 && this.current <= 57)) {
             while ((this.current >= 65 && this.current <= 90) || (this.current >=97 && this.current <= 122) || (this.current >= 48 && this.current <= 57)) {
                 consume();
             }
             return Token.STRING;
        } else if (this.current == ' ') {
            consume();
            return Token.WHITESPACE;
        } else if (this.current == ',') {
            consume();
            return Token.COMMA;
        } else if (this.current == '\n') {
            consume();
            return Token.NEWLINE;
        } else {
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
