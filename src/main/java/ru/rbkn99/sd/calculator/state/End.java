package ru.rbkn99.sd.calculator.state;

import ru.rbkn99.sd.calculator.token.Tokenizer;

public class End implements State {

    private final Tokenizer tokenizer;

    public End(Tokenizer tokenizer) {
        this.tokenizer = tokenizer;
    }

    @Override
    public void read() {
        tokenizer.setEnd(true);
    }
}
