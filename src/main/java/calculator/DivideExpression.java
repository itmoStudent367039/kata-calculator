package calculator;

class DivideExpression extends Expression {
    Number left;
    Number right;

    public DivideExpression(Number left, Number right) {
        this.left = left;
        this.right = right;
    }

    @Override
    Number interpret() {
        left.setValue(left.getValue() / right.getValue());
        return left;
    }
}
