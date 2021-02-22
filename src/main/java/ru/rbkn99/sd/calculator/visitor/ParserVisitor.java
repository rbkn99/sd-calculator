package ru.rbkn99.sd.calculator.visitor;

import ru.rbkn99.sd.calculator.exception.EmptyParenthesisBlockException;
import ru.rbkn99.sd.calculator.exception.InvalidParenthesisSequenceException;
import ru.rbkn99.sd.calculator.token.*;
import ru.rbkn99.sd.calculator.token.Number;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ParserVisitor implements TokenVisitor {
    private final Stack<Token> tokenStack;
    private final List<Token> parsedTokens;

    public ParserVisitor() {
        tokenStack = new Stack<>();
        parsedTokens = new ArrayList<>();
    }

    public List<Token> getParsedTokens() {
        return parsedTokens;
    }

    public void popRest() throws InvalidParenthesisSequenceException {
        while (tokenStack.size() != 0) {
            Token token = tokenStack.pop();
            if (token instanceof Operation) {
                parsedTokens.add(token);
            } else {
                throw new InvalidParenthesisSequenceException();
            }
        }
    }

    @Override
    public void visit(Number token) {
        parsedTokens.add(token);
    }

    @Override
    public void visit(Brace token) throws InvalidParenthesisSequenceException {
        if (token.getBraceType() == BraceType.OPEN) {
            tokenStack.push(token);
            return;
        }
        boolean bracesContainsAny = false;
        while (tokenStack.size() != 0) {
            Token curToken = tokenStack.pop();
            if (curToken instanceof Brace && ((Brace) curToken).getBraceType() == BraceType.OPEN) {
                if(!bracesContainsAny) {
                    throw new EmptyParenthesisBlockException();
                }
                return;
            } else {
                parsedTokens.add(curToken);
                bracesContainsAny =  true;
            }
        }
        throw new InvalidParenthesisSequenceException();
    }

    @Override
    public void visit(Operation token) {
        int curPriority = token.getPriority();
        while (tokenStack.size() != 0) {
            Token prevToken = tokenStack.peek();
            if (prevToken instanceof Operation) {
                int prevPriority = ((Operation) prevToken).getPriority();
                if (prevPriority >= curPriority) {
                    parsedTokens.add(tokenStack.pop());
                } else {
                    break;
                }
            } else {
                break;
            }
        }
        tokenStack.push(token);
    }
}
