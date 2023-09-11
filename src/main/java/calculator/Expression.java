package calculator;

abstract class Expression {
    abstract Number interpret() throws IllegalArgumentException;
}
