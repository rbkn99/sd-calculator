package ru.rbkn99.sd.calculator.token;

import ru.rbkn99.sd.calculator.visitor.TokenVisitor;

public interface Token {
    void accept(TokenVisitor visitor);
}
