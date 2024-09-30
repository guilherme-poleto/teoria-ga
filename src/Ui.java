
import java.util.Scanner;

public class Ui {

    public Scanner sc = new Scanner(System.in);

    public String usuario_msg() { // metodo = 1,2,3,4
        // long num = 0;
        // if (metodo == 1) {
        //     boolean isValid = false;
        //     while (!isValid) {
        //         try {
        //             menu();
        //             num = sc.nextInt();
        //             if (num < 0) {
        //                 System.out.println("\n***Digite apenas números positivos!***\n");
        //                 continue;
        //             }
        //             isValid = true;
        //         } catch (Exception e) {
        //             System.out.println("\n***Entrada inválida. Por favor, digite apenas números!***\n");
        //             sc.next();
        //         }
        //     }
        //     return num;
        // }
        System.out.print("Digite sua mensagem: ");
        return sc.nextLine();
    }

    public int escolhe_metodo_compressao() {
        boolean isValid = false;
        int num = 0;

        while (!isValid) {
            try {
                menu();
                num = sc.nextInt();
                if (num < 1 || num > 4) {
                    System.out.println("\n***Digite apenas números válidos!***\n");
                    continue;
                }
                isValid = true;
            } catch (Exception e) {
                System.out.println("\n***Entrada inválida. Por favor, digite apenas números!***\n");
                sc.next();
            }
        }
        return num;
    }

    public void menu() {
        System.out.println("Escolha uma opção do menu:");
        System.out.println("1- Golomb");
        System.out.println("2- Elias Gamma");
        System.out.println("3- Fibonacci");
        System.out.println("4- Huffman");
    }
}
