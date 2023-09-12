package calculator;

class DivideExpression extends Expression {

    @Override
    Number interpret(Number left, Number right) {
        left.setValue(left.getValue() / right.getValue());
        return left;
    }
}
