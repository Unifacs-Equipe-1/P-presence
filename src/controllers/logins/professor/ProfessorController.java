package controllers.logins.professor;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.UUID;

import extras.Util;
import models.Aluno;
import models.Database;
import models.Professor;

public class ProfessorController {

    public static void loginProfessor(Scanner sc, Database db) {
        while (true) {
            Util.limparTela();
            sc.useDelimiter("\\r\\n");
            System.out.print("Informe o nome para login:\t");
            String user = sc.next();
            System.out.print("Informe a senha para login:\t");
            String senha = sc.next();
            Professor professor = db.getProfessor(user);
            if (professor == null) {
                System.out.println("Usuário não encontrado! Pressione enter para voltar...");
                sc.next();
                return;
            }
            if (!professor.getSenha().equals(senha)) {
                System.out.println("Usuário ou senha incorretos! Pressione enter para voltar a página inicial...");
                sc.next();
                return;
            }
            sc.reset();
            Util.limparTela();
            int option = Util.optionPainel(sc, new String[] {
                    "[1]- Configurar sala",
                    "[2]- Gerar código da sala",
                    "[3]- Ver todos os alunos",
                    "[4]- Sair da conta"
            });

            switch (option) {
                case 1:
                    ProfessorController.configurarSala(sc, db, professor);
                    break;
                case 2:
                    ProfessorController.gerarCodigo(sc, db, professor);
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

    private static void gerarCodigo(Scanner sc, Database db, Professor professor) {
        professor.setCodigo(UUID.randomUUID().toString());
        db.atualizarProfessor(professor);
        System.out.printf("Informe esse código para os alunos marcarem presença: %s%n", professor.getCodigoSala());
        System.out.println("Pressione enter para voltar a página anterior...");
        sc.useDelimiter("\\r\\n");
        sc.next();
        sc.reset();
    }

    private static void configurarSala(Scanner sc, Database db, Professor professor) {
        ArrayList<Aluno> alunos = db.getAlunos();
        for (int index = 0; index < 1; index++) {
            try {
                System.out.print("Informe a sala que deseja usar:\t");
                int sala = sc.nextInt();
                professor.setSala(sala);
                db.atualizarProfessor(professor);
            } catch (Exception _e) {
                System.out.println("Sala inexistente, digite uma sala válida");
                sc.nextLine();
                index--;
            }
        }
        for (Aluno aluno : alunos) {
            aluno.setUc(professor.getUc());
            aluno.setSala(professor.getSala());
            db.atualizarAluno(aluno);
        }

        System.out.println("Sala criada!");
        System.out.println("Pressione enter para voltar a página anterior...");
        sc.useDelimiter("\\r\\n");
        sc.next();
        sc.reset();
    }

    private static void verAlunos(Scanner sc, Database db) {
        ArrayList<Aluno> alunos = db.getAlunos();
        for (Aluno aluno : alunos) {
            System.out.printf("Aluno: %s\t | Curso: %s\t | Turno: %s\t |  ", aluno.getNome(), aluno.getCurso(),
                    aluno.getTurno());
            if (aluno.getPresente() != null) {
                System.out.printf("Presença na aula: %s%n", aluno.getPresente() ? "Sim" : "Não");
            } else {
                System.out.println("Presença na aula: Ainda não foi configurado uma sala");
            }
        }
        System.out.print("\nPressione enter para prosseguir...");
        sc.useDelimiter("\\r\\n");
        sc.next();
        sc.reset();
    }

}
