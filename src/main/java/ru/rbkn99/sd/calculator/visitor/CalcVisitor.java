package ru.rbkn99.sd.calculator.visitor;

import ru.rbkn99.sd.calculator.exception.IncorrectOperandsNumberException;
import ru.rbkn99.sd.calculator.token.Brace;
import ru.rbkn99.sd.calculator.token.Number;
import ru.rbkn99.sd.calculator.token.Operation;

import java.util.Stack;

public class CalcVisitor implements TokenVisitor {
    private final Stack<Integer> numbersStack = new Stack<>();

    public int calculate() {
        return numbersStack.peek();
    }

    @Override
    public void visit(Brace token) { }

    @Override
    public void visit(Number token) {
        numbersStack.push(token.getValue());
    }

    @Override
    public void visit(Operation token) {
        if (numbersStack.size() < 2) {
            throw new IncorrectOperandsNumberException();
        }
        int number2 = numbersStack.pop();
        int number1 = numbersStack.pop();
        switch (token.getOperationType()) {
            case PLUS:
                numbersStack.push(number1 + number2);
                return;
            case MINUS:
                numbersStack.push(number1 - number2);
                return;
            case MUL:
                numbersStack.push(number1 * number2);
                return;
            case DIV:
                numbersStack.push(number1 / number2);
        }
    }
}
