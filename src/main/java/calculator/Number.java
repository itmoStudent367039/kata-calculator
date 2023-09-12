package calculator;


import static calculator.Context.*;

class Number {
    long value;
    String sign;

    public Number(String value) throws IllegalArgumentException {
        if (arab.containsKey(value)) {
            this.value = Long.parseLong(value);
        } else if (rome.containsKey(value)) {
            this.value = rome.get(value);
        } else {
            throw new IllegalArgumentException();
        }
        this.sign = value;
    }

    public void setValue(long value) {
        this.value = value;
    }

    public long getValue() {
        return value;
    }

    void updateSign() {

        if (arab.containsKey(sign)) {

            sign = String.valueOf(value);

        } else {

            if (value <= 0) {
                throw new IllegalArgumentException();
            }

            sign = toRoman(value);
        }

    }
    String toRoman(long num) {

        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romanNumerals = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        StringBuilder sb = new StringBuilder();

        int i = 0;

        while (num > 0) {
            if (num >= values[i]) {

                sb.append(romanNumerals[i]);
                num -= values[i];
            } else {
                i++;
            }
        }

        return sb.toString();
    }
}
