package ru.rbkn99.sd.calculator;

import ru.rbkn99.sd.calculator.token.Token;
import ru.rbkn99.sd.calculator.token.Tokenizer;
import ru.rbkn99.sd.calculator.visitor.CalcVisitor;
import ru.rbkn99.sd.calculator.visitor.ParserVisitor;
import ru.rbkn99.sd.calculator.visitor.PrintVisitor;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        try {
            List<Token> tokens = new Tokenizer(System.in).tokenize();
            if (tokens.isEmpty()) {
                System.out.println("Input must be not empty.");
                return;
            }
            ParserVisitor parserVisitor = new ParserVisitor();
            PrintVisitor printVisitor = new PrintVisitor();
            CalcVisitor calcVisitor = new CalcVisitor();
            for (Token token : tokens) {
                token.accept(parserVisitor);
            }
            parserVisitor.popRest();

            System.out.println("Reverse Polish notation expression:");
            for (Token token : parserVisitor.getParsedTokens()) {
                token.accept(printVisitor);
            }
            System.out.println();
            for (Token token : parserVisitor.getParsedTokens()) {
                token.accept(calcVisitor);
            }
            System.out.println("Calculation result:");
            System.out.println(calcVisitor.calculate());
        } catch (IOException e) {
            System.out.println("Exception while reading input " + e);
        }
    }
}
