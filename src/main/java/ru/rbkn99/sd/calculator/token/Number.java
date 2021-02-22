package ru.rbkn99.sd.calculator.token;

import ru.rbkn99.sd.calculator.visitor.TokenVisitor;

public class Number implements Token {

    private final int value;

    public Number(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "NUMBER(" + value + ")";
    }

    @Override
    public void accept(TokenVisitor visitor) {
        visitor.visit(this);
    }
}
