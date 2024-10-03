import algoritmos.Algorithm;

public class Encoder {
    Algorithm algorithm;

    public void setAlgorithm(Algorithm algorithm) {
        this.algorithm = algorithm;
    }

    public String getClassName() {
        return this.algorithm.getClass().getSimpleName();
    }
}
