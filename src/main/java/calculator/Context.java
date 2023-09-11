package calculator;

import java.util.HashMap;
import java.util.List;

class Context {
    static HashMap<String, Integer> numbers;
    static final List<String> ARAB = List.of("1", "2", "3", "4", "5", "6", "7", "8", "9", "10");
    static final List<String> ROME = List.of("I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "L", "C", "M", "D");

    public Context() {
        numbers = new HashMap<>();

        for (String s : ARAB) {
            numbers.put(s, Integer.parseInt(s));
        }

        for (int i = 0; i < ROME.size(); i++) {

            if (!ROME.get(i).equals("X")) {
                numbers.put(ROME.get(i), i + 1);
            } else {
                break;
            }

        }
        numbers.put("L", 50);
        numbers.put("C", 100);
        numbers.put("M", 1000);
        numbers.put("D", 500);

    }

    Number interpretExpression(String line) throws IllegalArgumentException {

        String[] strings = line.split(" ");
        if (strings.length != 3) {
            throw new IllegalArgumentException();
        }

        Number left = new Number(strings[0]);
        Number right = new Number(strings[2]);
        String l = strings[1];
        Expression action = null;

        if (ARAB.contains(left.sign) && ROME.contains(right.sign) || ARAB.contains(right.sign) && ROME.contains(left.sign)) {
            throw new IllegalArgumentException();
        }

        switch (l) {
            case "*":
                action = new MultiplyExpression(left, right);
                break;
            case "/":
                action = new DivideExpression(left, right);
                break;
            case "-":
                action = new SubtractExpression(left, right);
                break;
            case "+":
                action = new AddExpression(left, right);
                break;
            default:
                throw new IllegalArgumentException();
        }

        Number number = action.interpret();
        number.updateSign();

        return number;

    }


}
