package extras;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Util {
	// Verifica se a opção escolhida é válida e retorna a opção

	public static int optionPainel(Scanner scanner, String[] options) {
		System.out.println("");
		System.out.printf(" ---------------------------------------%n");
		System.out.printf("|      SISTEMA DE PRESENÇA UNIFACS     |%n");
		System.out.printf(" ---------------------------------------%n");
		System.out.println("|       Selecione uma das opções:      |");
		System.out.printf(" ---------------------------------------%n");
		System.out.println("|                                      |");
		for (String value : options) {
			System.out.printf("| %-36s |%n", value);

		}
		System.out.println("|                                      |");
		System.out.printf(" ---------------------------------------%n");
		System.out.print("\nInsira aqui: ");
		int option = -1;
		try {
			option = scanner.nextInt();
			scanner.nextLine();
		} catch (InputMismatchException e) {
			scanner.nextLine();
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

	public static String generateUuidNumber(String seed, int digitos) {
		// Método para gerar o RA e o RP
		String numberMaximo = "";
		if (digitos <= 0) {
			numberMaximo = "9";
		}
		for (int index = 0; index < digitos; index++) {
			numberMaximo += "9";
		}
		Random random = new Random(seed.hashCode());
		Long uuid = random.nextLong(Long.parseLong(numberMaximo));
		return uuid.toString();
	}
}
