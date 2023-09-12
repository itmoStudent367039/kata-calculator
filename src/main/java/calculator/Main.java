package calculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        var reader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            try {
                System.out.println(calc(reader.readLine()));
            } catch (IllegalArgumentException e) {
                System.out.println("throws Exception");
                System.exit(-1);
            }
        }
    }

    public static String calc(String input) throws IllegalArgumentException {
        Context context = new Context();
        return context.interpretExpression(input).sign;
    }

}
