package calculator;

abstract class Expression {
    abstract Number interpret(Number left, Number right) throws IllegalArgumentException;
}
