package controllers.logins.aluno;

import java.util.Scanner;

import extras.Util;

public class AlunoController {
    public static void loginAluno(Scanner sc) {
        for (int i = 0; i < 1; i++) {
            int option = Util.optionPainel(sc, new String[] {
                    "[1]- Mostrar sala disponível",
                    "[2]- Entrar na sala e marcar presença",
                    "[3]- Ver meus dados"
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
                default:
                    System.out.println("\nDigite uma opção válida!\n");
                    i--;
                    break;
            }
        }
    }
}
