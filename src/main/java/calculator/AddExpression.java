package calculator;

class AddExpression extends Expression {
    Number left;
    Number right;

    public AddExpression(Number left, Number right) {
        this.left = left;
        this.right = right;
    }

    @Override
    Number interpret() {
        left.setValue(left.getValue() + right.getValue());
        return left;
    }
}
