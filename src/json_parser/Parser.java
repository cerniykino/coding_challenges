package json_parser;

import java.io.IOException;

public class Parser {
    private Token currentToken;
    private Lexer lexer;

    public Parser(Lexer lexer) throws IOException {
        this.lexer = lexer;
        consume();
    }
    // Basic structure for JSON file is {}
    public int basicStructure() throws IOException {
        if(this.currentToken == Token.LEFT_CURLY_BRACE){
            consume();
            if(this.currentToken == Token.NEWLINE){
                consume();
            }
            if(!keyAndValueWithComma()){
               return 1;
            }
            if(this.currentToken == Token.RIGHT_CURLY_BRACE){
                return 0;
            }
            else{
                return 1;
            }
        }
        else{
            return 1;
        }
    }
    private boolean keyOrValue() throws IOException {
        if(this.currentToken == Token.DOUBLE_QUOTES) {
            consume();
            if(this.currentToken == Token.STRING){
                consume();
            }
            if (this.currentToken == Token.DOUBLE_QUOTES){
                consume();
                return true;
            }
        }
        return false;
    }

    private boolean keyAndValue() throws IOException {
        if(keyOrValue()){
            if(this.currentToken == Token.COLON){
                consume();
                return keyOrValue();
            }

        }
        return false;
    }

    private boolean keyAndValueWithComma() throws IOException {
        if(keyAndValue()){
            if(this.currentToken == Token.RIGHT_CURLY_BRACE){
                return true;
            }
            if(this.currentToken == Token.COMMA){
                consume();
                if(this.currentToken == Token.RIGHT_CURLY_BRACE){
                    return false;
                }
                return keyAndValueWithComma();
            }
            else return true;

        }
        return true;
    }
    private void consume() throws IOException {
        this.currentToken = this.lexer.nextToken();
        if(this.currentToken == Token.WHITESPACE || this.currentToken == Token.NEWLINE){
            while (this.currentToken == Token.WHITESPACE || this.currentToken == Token.NEWLINE){
                this.currentToken = this.lexer.nextToken();
            }
        }
    }
}
