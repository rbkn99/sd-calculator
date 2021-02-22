package ru.rbkn99.sd.calculator.exception;

public class IncorrectOperandsNumberException extends RuntimeException {
    public IncorrectOperandsNumberException() {
        super();
    }

    @Override
    public String getMessage() {
        return "Cannot calculate expression result: incorrect number of operands.";
    }
}
