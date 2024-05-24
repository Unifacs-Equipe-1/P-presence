package controllers.logins.admin.gerenciar;

import java.util.Scanner;
import java.util.UUID;

import extras.Util;
import models.Aluno;
import models.Database;

public class GerenciarAlunosController {
    public static void gerenciarAlunos(Scanner sc, Database db) {
        while (true) {
            int option = Util.optionPainel(sc, new String[] {
                    "[1] - Cadastrar Alunos",
                    "[2] - Atualizar Alunos",
                    "[3] - Excluir aluno",
                    "[4] - Voltar a página anterior"
            });
            switch (option) {
                case 1:
                    GerenciarAlunosController.cadastrarAluno(sc, db);
                    break;
                case 2:
                    GerenciarAlunosController.atualizarAluno(sc, db);
                    break;
                case 3:
                    GerenciarAlunosController.excluirAluno(sc, db);
                    break;
                case 4:
                    System.out.println("Voltando a página anterior!");
                    return;
                default:
                    System.out.println("\nDigite uma opção válida!\n");
                    break;
            }
        }
    }

    private static void cadastrarAluno(Scanner sc, Database db) {
        String nome;
        String genero;
        String ra;
        String senha = "";
        String turno;
        String curso;
        sc.useDelimiter("\\r\\n");
        System.out.print("Digite o nome do aluno: ");
        nome = sc.next();
        System.out.print("Digite o gênero do aluno: ");
        genero = sc.next();
        ra = UUID.randomUUID().toString();
        System.out.print("Escolha um turno para o aluno: ");
        turno = sc.next();
        System.out.print("Escolha um curso para o aluno: ");
        curso = sc.next();

        for (int i = 0; i < 1; i++) {
            System.out.print("Digite uma senha: ");
            senha = sc.next();
            System.out.print("Digite a senha novamente: ");
            String senhaRepetida = sc.next();
            if (!senha.equals(senhaRepetida)) {
                Util.limparTela();
                System.out.println("As senhas não coincidem");
                i--;
            }
        }

        Aluno aluno = new Aluno(nome, genero, ra, senha, turno, curso);
        db.cadastrarAluno(aluno);
        System.out.println("Aluno cadastrado com sucesso!");
        sc.reset();
    }

    private static void atualizarAluno(Scanner sc, Database db) {
        System.out.print("Digite o aluno que deseja modificar:\t");
        String nomeAluno = sc.next();
        Aluno aluno = db.getAluno(nomeAluno);
        System.out.println("O que deseja modificar?");
        int option = Util.optionPainel(sc, new String[] {
                "[1] - Turno",
                "[2] - Curso"
        });
        int acc = 0;
        while (acc < 1) {
            switch (option) {
                case 1:
                    System.out.print("Digite o novo turno:\t");
                    String turno = sc.next();
                    aluno.setTurno(turno);
                    db.atualizarAluno(aluno);
                    break;
                case 2:
                    System.out.print("Digite o novo curso:\t");
                    String curso = sc.next();
                    aluno.setCurso(curso);
                    db.atualizarAluno(aluno);
                    break;
                default:
                    System.out.println("Essa opção não existe!");
                    acc--;
                    break;
            }

        }
    }

    private static void excluirAluno(Scanner sc, Database db) {
        System.out.println("Digite o nome do aluno que deseja excluir:\t");
        sc.useDelimiter("\\r\\n");
        String nomeAluno = sc.next();
        Aluno aluno = db.getAluno(nomeAluno);
        db.excluirAluno(aluno);
        System.out.println("Aluno excluído com sucesso!");
        sc.reset();
    }
}
