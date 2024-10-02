
import algoritmos.*;

public class Main {

    public static void main(String[] args) {

        Fibonacci fn = new Fibonacci();
        String message = "hello world!";
        String encoded = fn.encode(message);
        System.out.println(encoded);
        System.out.println(fn.decode(encoded));

        Ui ui = new Ui();
        ui.usuario_msg();
        ui.escolhe_metodo_compressao();
    }
}
