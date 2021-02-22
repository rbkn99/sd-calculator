package ru.rbkn99.sd.calculator.state;

import ru.rbkn99.sd.calculator.exception.InvalidInputException;
import ru.rbkn99.sd.calculator.token.Tokenizer;

public class Error implements State {
    private final Tokenizer tokenizer;

    public Error(Tokenizer tokenizer) {
        this.tokenizer = tokenizer;
    }

    @Override
    public void read() throws InvalidInputException {
        throw new InvalidInputException(tokenizer.getPosition(), tokenizer.getChar());
    }
}
