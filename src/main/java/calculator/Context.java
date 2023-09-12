package calculator;

import java.util.HashMap;
import java.util.Objects;

class Context {
    static HashMap<String, Integer> arab;
    static HashMap<String, Integer> rome;
    HashMap<String, Expression> expressions;

    public Context() {
        expressions = new HashMap<>() {{
            put("*", new MultiplyExpression());
            put("/", new DivideExpression());
            put("+", new AddExpression());
            put("-", new SubtractExpression());
        }};
        arab = new HashMap<>() {{
            put("1", 1);
            put("2", 2);
            put("3", 3);
            put("4", 4);
            put("5", 5);
            put("6", 6);
            put("7", 7);
            put("8", 8);
            put("9", 9);
            put("10", 10);
        }};

        rome = new HashMap<>() {{
            put("I", 1);
            put("II", 2);
            put("III", 3);
            put("IV", 4);
            put("V", 5);
            put("VI", 6);
            put("VII", 7);
            put("VIII", 8);
            put("IX", 9);
            put("X", 10);
        }};

    }

    Number interpretExpression(String line) throws IllegalArgumentException {

        String[] strings = line.split(" ");
        if (strings.length != 3) {
            throw new IllegalArgumentException();
        }

        Number left = new Number(strings[0]);
        Number right = new Number(strings[2]);
        String l = strings[1];
        Expression action = expressions.get(l);

        if (Objects.isNull(action)) {
            throw new IllegalArgumentException();
        }

        if (arab.containsKey(left.sign) && rome.containsKey(right.sign) || arab.containsKey(right.sign) && rome.containsKey(left.sign)) {
            throw new IllegalArgumentException();
        }


        Number number = action.interpret(left, right);
        number.updateSign();

        return number;

    }


}
