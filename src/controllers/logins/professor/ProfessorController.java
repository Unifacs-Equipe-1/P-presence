package controllers.logins.professor;

import java.util.ArrayList;
import java.util.Scanner;

import extras.Util;
import models.Aluno;
import models.Database;

public class ProfessorController {

    public static void loginProfessor(Scanner sc, Database db) {
        while (true) {
            Util.limparTela();
            int option = Util.optionPainel(sc, new String[] {
                    "[1]- Configurar sala",
                    "[2]- Gerar código da sala",
                    "[3]- Ver todos os alunos",
                    "[4]- Sair da conta"
            });

            switch (option) {
                case 1:
                    // Programa.configurarSala();
                    break;
                case 2:
                    // Programa.gerarCodigo();
                    break;
                case 3:
                    ProfessorController.verAlunos(sc, db);
                    break;
                case 4:
                    System.out.println("Saindo da conta de professor...");
                    return;
                default:
                    System.out.println("\nDigite uma opção válida!\n");
                    break;
            }
        }
    }

    private static void verAlunos(Scanner sc, Database db) {
        ArrayList<Aluno> alunos = db.getAlunos();
        for (Aluno aluno : alunos) {
            System.out.println(aluno.getNome());
        }
        System.out.print("\nPressione enter para prosseguir...");
        sc.useDelimiter("\\n");
        sc.next();
        sc.reset();
    }

}
