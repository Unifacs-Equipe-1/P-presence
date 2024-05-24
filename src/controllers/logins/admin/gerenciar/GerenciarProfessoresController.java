package controllers.logins.admin.gerenciar;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.UUID;

import extras.Util;
import models.Database;
import models.Professor;

public class GerenciarProfessoresController {
  public static void gerenciarProfessores(Scanner sc, Database db) {
    while (true) {
      int option = Util.optionPainel(sc, new String[] {
          "[1] - Cadastrar Professores",
          "[2] - Atualizar Professores",
          "[3] - Excluir Professor",
          "[4] - Ver Professores",
          "[5] - Voltar a página anterior"
      });
      switch (option) {
        case 1:
          GerenciarProfessoresController.cadastrarProfessor(sc, db);
          break;
        case 2:
          GerenciarProfessoresController.atualizarProfessor(sc, db);
          break;
        case 3:
          GerenciarProfessoresController.excluirProfessor(sc, db);
          break;
        case 4:
          GerenciarProfessoresController.verProfessor(sc, db);
        case 5:
          System.out.println("Voltando a página anterior!");
          return;
        default:
          System.out.println("\nDigite uma opção válida!\n");
          break;
      }
    }
  }

  private static void cadastrarProfessor(Scanner sc, Database db) {
    String nome;
    String ra;
    String senha = "";
    String turno;
    String curso;
    String uc;
    sc.useDelimiter("\\r\\n");
    System.out.print("Digite o nome do professor: ");
    nome = sc.next();
    ra = UUID.randomUUID().toString();
    System.out.print("Escolha um turno para o professor: ");
    turno = sc.next();
    System.out.print("Escolha um curso para o professor: ");
    curso = sc.next();
    System.out.print("Escolha a UC do professor: ");
    uc = sc.next();

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

    Professor professor = new Professor(nome, ra, senha, turno, curso, uc);
    db.cadastrarProfessor(professor);
    System.out.println("Professor cadastrado com sucesso!");
    sc.reset();
  }

  private static void atualizarProfessor(Scanner sc, Database db) {
    System.out.print("Digite o professor que deseja modificar:\t");
    String nomeProfessor = sc.next();
    Professor professor = db.getProfessor(nomeProfessor);
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
          professor.setTurno(turno);
          db.atualizarProfessor(professor);
          break;
        case 2:
          System.out.print("Digite o novo curso:\t");
          String curso = sc.next();
          professor.setCurso(curso);
          db.atualizarProfessor(professor);
          break;
        default:
          System.out.println("Essa opção não existe!");
          acc--;
          break;
      }

    }
  }

  private static void excluirProfessor(Scanner sc, Database db) {
    System.out.println("Digite o nome do professor(a) que deseja excluir:\t");
    sc.useDelimiter("\\r\\n");
    String nomeProfessor = sc.next();
    Professor professor = db.getProfessor(nomeProfessor);
    db.excluirProfessor(professor);
    System.out.println("Professor(a) excluído com sucesso!");
    sc.reset();
  }

  private static void verProfessor(Scanner sc, Database db) {
    ArrayList<Professor> professores = db.getProfessores();
    for (Professor professor : professores) {
      System.out.printf("Professor: %s\t | Curso: %s\t | Turno: %s\t | \n", professor.getNome(), professor.getCurso(),
          professor.getTurno());
    }
    System.out.print("\nPressione enter para prosseguir...");
    sc.useDelimiter("\\r\\n");
    sc.next();
    sc.reset();
  }
}
