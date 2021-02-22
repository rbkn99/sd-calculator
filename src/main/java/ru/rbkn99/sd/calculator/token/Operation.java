package ru.rbkn99.sd.calculator.token;

import ru.rbkn99.sd.calculator.visitor.TokenVisitor;

public class Operation implements Token {

    private final OperationType opType;
    private final int priority;

    public Operation(OperationType opType) {
        this.opType = opType;
        if (opType == OperationType.PLUS || opType == OperationType.MINUS) {
            priority = 0;
        } else {
            priority = 1;
        }
    }

    @Override
    public String toString() {
        return opType.toString();
    }

    @Override
    public void accept(TokenVisitor visitor) {
        visitor.visit(this);
    }

    public OperationType getOperationType() {
        return opType;
    }

    public int getPriority() {
        return priority;
    }
}
