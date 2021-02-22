package ru.rbkn99.sd.calculator.state;

import ru.rbkn99.sd.calculator.exception.InvalidInputException;

import java.io.IOException;

public interface State {
    void read() throws IOException, InvalidInputException;
}
