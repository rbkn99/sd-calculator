package ru.rbkn99.sd.calculator.exception;

public class EmptyParenthesisBlockException extends RuntimeException {
    public EmptyParenthesisBlockException() {
        super();
    }

    @Override
    public String getMessage() {
        return "Parenthesis block should not be empty";
    }
}
