import algoritmos.Algorithm;

public class Encoder {
    Algorithm algorithm;

    public void setAlgorithm(Algorithm algorithm) {
        this.algorithm = algorithm;
    }

    public String getClassName() {
        return this.algorithm.getClass().getSimpleName();
    }

    public String encodeMessage(String message) {
        StringBuilder result = new StringBuilder();
        for (char c : message.toCharArray()) {
            String codeWord = this.algorithm.encodeNumber(c);
            result.append(codeWord).append(" ");
        }
        return result.toString();
    }

    public String decodeMessage(String encodedMessage) {
        StringBuilder result = new StringBuilder();
        String[] encodedChars = encodedMessage.split(" ");
        for (String encodedChar : encodedChars) {
            int decodedAscii = this.algorithm.decodeBinary(encodedChar);
            result.append((char) decodedAscii);
        }
        return result.toString();
    }
}

