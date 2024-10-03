package algoritmos;

import java.util.List;
import java.util.ArrayList;

public class Fibonacci implements Algorithm {
    private final List<Integer> fibonacciList;

    public Fibonacci() {
        this.fibonacciList = buildFibonacciList(127);
    }

    public String encodeNumber(int number) {
        StringBuilder result = new StringBuilder();

        for (int i = fibonacciList.size() - 1; i >= 0; i--) {
            int value = fibonacciList.get(i);
            if (value <= number) {
                number -= value;
                result.append("1");
            } else {
                if (!result.isEmpty()) {
                    result.append("0");
                }
            }
        }
        return result.toString();
    }

    public int decodeBinary(String binary) {
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
        int index = 1;
        int nextValue = Integer.MIN_VALUE;

        while (nextValue <= number) {
            nextValue = fibonacci.get(index) + fibonacci.get(index - 1);
            if (nextValue <= number) {
                fibonacci.add(nextValue);
            }
            index++;
        }
        return fibonacci;
    }
}
