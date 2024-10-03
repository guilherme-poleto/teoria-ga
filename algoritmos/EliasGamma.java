package algoritmos;

import java.util.Arrays;

public class EliasGamma implements Algorithm {

    public String encodeNumber(int n) {
        StringBuilder result = new StringBuilder();
        int N = (int) (Math.log(n) / Math.log(2));
        int resto = n - ((int) (Math.pow(2, N))); // resto = number - (2 ^ N)

        String prefix = "0".repeat(N);
        String restoBinary = Integer.toBinaryString(resto);
        String suffix = buildSuffix(N, restoBinary);
        return result.append(prefix).append("1").append(suffix).toString();
    }

    public int decodeBinary(String binary) {
        int NCounter = 0;
        while (binary.charAt(NCounter) == '0') {
            NCounter++;
        }

        int nPrefix = (int) (Math.pow(2, NCounter));
        String suffix = binary.substring(NCounter + 1);
        int resto = Integer.parseInt(suffix, 2);

        return nPrefix + resto;
    }

    private String buildSuffix(int N, String restoBinary) {
        char[] arr = new char[N];
        Arrays.fill(arr, '0');
        int arrIdx = N-1;
        for (int i = restoBinary.length()-1;i >= 0;i--) {
            arr[arrIdx] = restoBinary.charAt(i);
            arrIdx--;
        }
        return String.valueOf(arr);
    }
}
