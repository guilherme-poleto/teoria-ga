package algoritmos;

public class Golomb implements Algorithm {

    private final int divisor;

    public Golomb(int div) {
        this.divisor = div;
    }

    public String encodeNumber(int n) {
        int quociente = n / divisor;
        int resto = n % divisor;

        StringBuilder unary = new StringBuilder();
        for (int i = 0; i < quociente; i++) {
            unary.append("1");
        }
        unary.append("0");

        String binaryRemainder = Integer.toBinaryString(resto);
        int remainderBits = (int) Math.ceil(Math.log(divisor) / Math.log(2));

        while (binaryRemainder.length() < remainderBits) {
            binaryRemainder = "0" + binaryRemainder;
        }

        return unary.toString() + binaryRemainder;
    }
    //111110 + 000101

    public int decodeBinary(String message) {
        int q = 0;
        int index = 0;

        while (message.charAt(index) == '1') {
            q++;
            index++;
        }
        index++;

        int remainderBits = (int) Math.ceil(Math.log(divisor) / Math.log(2));
        String binaryRemainder = message.substring(index, index + remainderBits);

        int r = Integer.parseInt(binaryRemainder, 2);

        return q * divisor + r;
    }
}
