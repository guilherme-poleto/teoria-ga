package algoritmos;

import java.util.List;
import java.util.ArrayList;

public class Fibonacci {
    private final List<Integer> fibonacciList;

    public Fibonacci() {
        this.fibonacciList = buildFibonacciList(127);
    }

    public String encode(String message) {
        StringBuilder result = new StringBuilder();

        for (char c : message.toCharArray()) {
            String codeWord = encodeNumber(c);
            result.append(codeWord).append(" ");
        }

        return result.toString();
    }

    public String decode(String encodedMessage) {
        StringBuilder result = new StringBuilder();
        String[] encodedChars = encodedMessage.split(" ");

        for (String encodedChar : encodedChars) {
            int decodedAscii = decodeBinary(encodedChar);
            result.append((char) decodedAscii);
        }

        return result.toString();
    }

    private String encodeNumber(int number) {
        StringBuilder result = new StringBuilder();
        int reducedNumber = number;

        for (int i = fibonacciList.size() - 1; i >= 0; i--) {
            int value = fibonacciList.get(i);
            if (value <= reducedNumber) {
                reducedNumber -= value;
                result.append("1");
            } else {
                if (!result.isEmpty()) {
                    result.append("0");
                }
            }
        }
        return result.toString();
    }

    private int decodeBinary(String binary) {
        int num = 0;
        int length = binary.length();

        for (int i = 0; i < length; i++) {
            if (binary.charAt(i) == '1') {
                num += fibonacciList.get(length - i - 1);
            }
        }

        return num;
    }

    private static List<Integer> buildFibonacciList(int number) {
        List<Integer> fibonacci = new ArrayList<>();
        fibonacci.add(1);
        fibonacci.add(2);
        int counter = 2;
        int nextValue = 3;

        while (nextValue <= number) {
            nextValue = fibonacci.get(counter - 1) + fibonacci.get(counter - 2);
            if (nextValue <= number) {
                fibonacci.add(nextValue);
            }
            counter++;
        }
        return fibonacci;
    }
}
