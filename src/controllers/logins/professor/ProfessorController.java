package controllers.logins.professor;

import java.util.ArrayList;
import java.util.Scanner;

import extras.Util;
import models.Aluno;
import models.Database;

public class ProfessorController {

    public static void loginProfessor(Scanner sc, Database db) {
        for (int i = 0; i < 1; i++) {
            int option = Util.optionPainel(sc, new String[] {
                    "[1]- Configurar sala",
                    "[2]- Gerar código da sala",
                    "[3]- Ver todos os alunos"
            });

            switch (option) {
                case 1:
                    // Programa.configurarSala();
                    break;
                case 2:
                    // Programa.gerarCodigo();
                    break;
                case 3:
                    ProfessorController.verAlunos(db);
                    break;
                default:
                    System.out.println("\nDigite uma opção válida!\n");
                    i--;
                    break;
            }
        }
    }

    private static void verAlunos(Database db) {
        ArrayList<Aluno> alunos = db.getAlunos();
        for (Aluno aluno : alunos) {
            System.out.println(aluno.getNome());
        }
    }

}
