
import algoritmos.*;

public class Main {

    public static void main(String[] args) {

        Ui ui = new Ui();
        ui.usuario_msg();
        int option = ui.escolhe_metodo_compressao();
        Encoder encoder = new Encoder();
        switch (option) {
            case 1:
                // encoder.setAlgorithm(new Golomb());
            case 2:
                encoder.setAlgorithm(new EliasGamma());
                break;
            case 3:
                encoder.setAlgorithm(new Fibonacci());
                break;
            case 4:
                // encoder.setAlgorithm(new Huffman());
        }
        System.out.println("Algoritmo selecionado: " + encoder.getClassName());
    }
}
