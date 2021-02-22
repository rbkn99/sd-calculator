package ru.rbkn99.sd.calculator.exception;

public class InvalidParenthesisSequenceException extends RuntimeException {
    public InvalidParenthesisSequenceException() {
        super();
    }

    @Override
    public String getMessage() {
        return "Invalid consequence of braces in the expression";
    }
}
