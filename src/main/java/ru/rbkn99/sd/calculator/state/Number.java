package ru.rbkn99.sd.calculator.state;

import ru.rbkn99.sd.calculator.token.Tokenizer;

import java.io.IOException;

public class Number implements State {
    private final Tokenizer tokenizer;

    public Number(Tokenizer tokenizer) {
        this.tokenizer = tokenizer;
    }

    @Override
    public void read() throws IOException {
        int number = 0;
        while (Character.isDigit(tokenizer.getChar())) {
            int digit = tokenizer.getChar() - '0';
            number *= 10;
            number += digit;
            tokenizer.nextChar();
        }
        tokenizer.addToken(new ru.rbkn99.sd.calculator.token.Number(number));
        tokenizer.switchState(new Start(tokenizer));
    }
}
