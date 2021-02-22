package ru.rbkn99.sd.calculator.visitor;

import ru.rbkn99.sd.calculator.token.Brace;
import ru.rbkn99.sd.calculator.token.Number;
import ru.rbkn99.sd.calculator.token.Operation;

public interface TokenVisitor {
    void visit(Number token);

    void visit(Operation token);

    void visit(Brace token);
}