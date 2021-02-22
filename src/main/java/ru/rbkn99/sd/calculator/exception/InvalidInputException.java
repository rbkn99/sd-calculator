package ru.rbkn99.sd.calculator.exception;

public class InvalidInputException extends Exception {
    private final int errorPos;
    private final int actualSymbol;

    public InvalidInputException(int errorPos, int actualSymbol) {
        super();
        this.errorPos = errorPos;
        this.actualSymbol = actualSymbol;
    }

    @Override
    public String getMessage() {
        return "Parse error on position: " + errorPos + " (symbol: " + (char) actualSymbol + ")";
    }
}
