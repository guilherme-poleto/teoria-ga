package algoritmos;

import java.util.List;
import java.util.ArrayList;

public class Fibonacci {

    public void encode() {
        int number = 40;
        List<Integer> fibonacci = new ArrayList<>();
        fibonacci.add(1);
        fibonacci.add(2);
        int currentValue = 2;

        while (currentValue <= number) {
            fibonacci.add(1);
        }

    }
}
