package controllers.logins.aluno;

import java.util.Scanner;

import extras.Util;

public class AlunoController {
    public static void loginAluno(Scanner sc) {
        while (true) {
            int option = Util.optionPainel(sc, new String[] {
                    "[1]- Mostrar sala disponível",
                    "[2]- Entrar na sala e marcar presença",
                    "[3]- Ver meus dados",
                    "[4]- Sair da conta"
            });
            switch (option) {
                case 1:
                    // Programa.informarDadosDaSala();
                    break;
                case 2:
                    // Programa.marcarPresenca();
                    break;
                case 3:
                    // Programa.mostrarDadosAluno();
                    break;
                case 4:
                    System.out.println("Saindo da conta de aluno...");
                    return;
                default:
                    System.out.println("\nDigite uma opção válida!\n");
                    break;
            }
        }
    }
}
