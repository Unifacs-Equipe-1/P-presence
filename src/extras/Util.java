package extras;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Random;

public class Util {
	// Verifica se a opção escolhida é válida e retorna a opção
	public static int optionPainel(Scanner sc, String[] options) {
		System.out.println("Selecione uma das opções:\n");
		for (String value : options) {
			System.out.println(value);
		}
		System.out.print("\nInsira aqui: ");
		int option = -1;
		try {
			option = sc.nextInt();
			sc.nextLine();
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

	public static String generateUuidNumber(String seed, int digitos) {
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