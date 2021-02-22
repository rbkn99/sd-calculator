package ru.rbkn99.sd.calculator.state;

import ru.rbkn99.sd.calculator.token.*;

import java.io.IOException;

public class Start implements State {
    private final Tokenizer tokenizer;

    public Start(Tokenizer tokenizer) {
        this.tokenizer = tokenizer;
    }

    @Override
    public void read() throws IOException {
        tokenizer.skipWhitespaces();
        if (tokenizer.getChar() == -1) {
            tokenizer.switchState(new End(tokenizer));
            return;
        }
        switch (tokenizer.getChar()) {
            case '+':
                tokenizer.nextChar();
                tokenizer.addToken(new Operation(OperationType.PLUS));
                break;
            case '-':
                tokenizer.nextChar();
                tokenizer.addToken(new Operation(OperationType.MINUS));
                break;
            case '*':
                tokenizer.nextChar();
                tokenizer.addToken(new Operation(OperationType.MUL));
                break;
            case '/':
                tokenizer.nextChar();
                tokenizer.addToken(new Operation(OperationType.DIV));
                break;
            case '(':
                tokenizer.nextChar();
                tokenizer.addToken(new Brace(BraceType.OPEN));
                break;
            case ')':
                tokenizer.nextChar();
                tokenizer.addToken(new Brace(BraceType.CLOSE));
                break;
            default:
                if (Character.isDigit(tokenizer.getChar())) {
                    tokenizer.switchState(new Number(tokenizer));
                } else {
                    tokenizer.switchState(new Error(tokenizer));
                }
        }
    }
}
