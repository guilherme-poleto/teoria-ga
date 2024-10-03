
import algoritmos.EliasGamma;
import algoritmos.Fibonacci;

import java.util.Scanner;

public class Ui {

    private Scanner sc = new Scanner(System.in).useDelimiter("\n");

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

    public void escolhe_metodo_compressao() {
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
        Encoder encoder = new Encoder();
        switch (num) {
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
        isValid = false;
        while (!isValid) {
            try {
                encodeMenu();
                num = sc.nextInt();
                if (num < 1 || num > 2) {
                    System.out.println("\n***Digite apenas números válidos!***\n");
                    continue;
                }
                isValid = true;
            } catch (Exception e) {
                System.out.println("\n***Entrada inválida. Por favor, digite apenas números!***\n");
                sc.next();
            }
        }
        String message = "";
        String result;
        if (num == 1) {
            System.out.print("Mensagem a ser codificada: ");
            message = sc.next();
            result = encoder.encodeMessage(message);
        } else {
            System.out.print("Código a ser decodificado: ");
            message = sc.next();
            result = encoder.decodeMessage(message);
        }
        System.out.println(result);
    }

    private void menu() {
        System.out.println("Escolha o algoritmo desejado:");
        System.out.println("1- Golomb");
        System.out.println("2- Elias Gamma");
        System.out.println("3- Fibonacci");
        System.out.println("4- Huffman");
    }

    private void encodeMenu() {
        System.out.println("Escolha uma opção do menu:");
        System.out.println("1- Codificar mensagem");
        System.out.println("2- Decodificar código binário");
    }
}
