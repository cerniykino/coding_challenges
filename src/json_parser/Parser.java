package json_parser;

public class Parser {
    private Token currentToken;
    private Lexer lexer;

    public Parser(Lexer lexer) {
        this.lexer = lexer;
        this.currentToken = lexer.nextToken();
    }
    // Basic structure for JSON file is {}
    public int basicStructure(){
        if(this.currentToken == Token.LEFT_CURLY_BRACE){
            this.currentToken = this.lexer.nextToken();
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
}
