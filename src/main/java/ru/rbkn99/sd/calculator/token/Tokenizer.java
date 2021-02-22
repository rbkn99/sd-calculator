package ru.rbkn99.sd.calculator.token;

import ru.rbkn99.sd.calculator.exception.InvalidInputException;
import ru.rbkn99.sd.calculator.state.Start;
import ru.rbkn99.sd.calculator.state.State;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class Tokenizer {

    private final InputStream is;
    private final List<Token> tokens;
    private State state;
    private int curPos = 0;
    private int curChar = -1;
    private boolean endOfParse = false;

    public Tokenizer(InputStream is) {
        this.is = is;
        this.state = new Start(this);
        this.tokens = new ArrayList<>();
    }

    public void nextChar() throws IOException {
        curPos++;
        curChar = is.read();
    }

    public int getPosition() {
        return curPos;
    }

    public int getChar() {
        return curChar;
    }

    public void addToken(Token token) {
        tokens.add(token);
    }

    public void skipWhitespaces() throws IOException {
        while (Character.isWhitespace(curChar)) {
            nextChar();
        }
    }

    public List<Token> tokenize() throws IOException, InvalidInputException {
        nextChar();
        while (!endOfParse) {
            state.read();
        }
        return tokens;
    }

    public void setEnd(boolean endOfParse) {
        this.endOfParse = endOfParse;
    }

    public void switchState(State newState) {
        this.state = newState;
    }
}