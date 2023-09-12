package calculator;

class AddExpression extends Expression {

    @Override
    Number interpret(Number left, Number right) {
        left.setValue(left.getValue() + right.getValue());
        return left;
    }
}
