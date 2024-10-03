
import algoritmos.EliasGamma;
import algoritmos.Fibonacci;

import java.util.Scanner;

public class Ui {

    private final Scanner sc = new Scanner(System.in).useDelimiter("\n");
    private final Encoder encoder = new Encoder();

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

    public void printMainMenu() {
        int option;
        while (true) {
            try {
                menu();
                System.out.print("Opção: ");
                option = sc.nextInt();
                if (option < 1 || option > 5) {
                    System.out.println("\n***Digite apenas números válidos!***\n");
                    continue;
                }
                if (option == 5) break;
                setAlgorithm(option);
                printEncodeMenu();
            } catch (Exception e) {
                System.out.println("\n***Entrada inválida. Por favor, digite apenas números!***\n");
                sc.next();
            }
        }
    }

    private void setAlgorithm(int option) {
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
        System.out.println("\nAlgoritmo selecionado: " + encoder.getClassName());
    }

    private void printEncodeMenu() {
        int option;
        while (true) {
            try {
                encodeMenu();
                System.out.print("Opção: ");
                option = sc.nextInt();
                if (option < 1 || option > 3) {
                    System.out.println("\n***Digite apenas números válidos!***\n");
                    continue;
                }
                if (option == 3) break;
                handleEncodeOption(option);
            } catch (Exception e) {
                System.out.println("\n***Entrada inválida. Por favor, digite apenas números!***\n");
                sc.next();
            }
        }
    }

    private void handleEncodeOption(int option) {
        String message;
        String result;
        if (option == 1) {
            System.out.print("Mensagem a ser codificada: ");
            message = sc.next();
            result = encoder.encodeMessage(message);
        } else {
            System.out.print("Código a ser decodificado: ");
            message = sc.next();
            result = encoder.decodeMessage(message);
        }
        System.out.println(result + "\n");
    }

    private void menu() {
        System.out.println("Escolha o algoritmo desejado:");
        System.out.println("1- Golomb");
        System.out.println("2- Elias Gamma");
        System.out.println("3- Fibonacci");
        System.out.println("4- Huffman");
        System.out.println("5- Sair");
    }

    private void encodeMenu() {
        System.out.println("Escolha uma opção do menu:");
        System.out.println("1- Codificar mensagem");
        System.out.println("2- Decodificar código binário");
        System.out.println("3- Trocar algoritmo/Sair");
    }
}
