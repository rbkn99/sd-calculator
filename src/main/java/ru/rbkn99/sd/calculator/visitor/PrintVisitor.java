package ru.rbkn99.sd.calculator.visitor;

import ru.rbkn99.sd.calculator.token.Brace;
import ru.rbkn99.sd.calculator.token.Number;
import ru.rbkn99.sd.calculator.token.Operation;

public class PrintVisitor implements TokenVisitor {

    @Override
    public void visit(Number token) {
        System.out.print(token + " ");
    }

    @Override
    public void visit(Brace token) {
        System.out.print(token + " ");
    }

    @Override
    public void visit(Operation token) {
        System.out.print(token + " ");
    }
}
