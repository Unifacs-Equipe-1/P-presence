package extras;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Util {
    // verifica se a opção escolhida é válida e retorna a opção
    public static int optionPainel(Scanner sc, String[] options) {
        System.out.println("Selecione uma das opções:\n");
        for (String value : options) {
            System.out.println(value);
        }
        System.out.print("\nInsira aqui: ");
        int option = -1;
        try {
            option = sc.nextInt();
        } catch (InputMismatchException e) {
            sc.nextLine();
        }
        Util.limparTela();
        return option;
    }

    // limpa o console
    public static void limparTela() {
        for (int i = 0; i < 1000; i++) {
            System.out.println("\n");
        }
    }
}
