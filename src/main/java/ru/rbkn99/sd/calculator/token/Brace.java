package ru.rbkn99.sd.calculator.token;

import ru.rbkn99.sd.calculator.visitor.TokenVisitor;

public class Brace implements Token {

    private final BraceType braceType;

    public Brace(BraceType type) {
        this.braceType = type;
    }

    @Override
    public void accept(TokenVisitor visitor) {
        visitor.visit(this);
    }

    public BraceType getBraceType() {
        return braceType;
    }
}
