package controllers.logins.admin.gerenciar;

import extras.Util;

import java.util.List;
import java.util.Scanner;
import models.Aluno;
import models.Database;

public class GerenciarAlunosController {
	public static void gerenciarAlunos(Scanner sc, Database db) {
		while (true) {
			/*
			 * Opção do Administrador de gerenciamento dos alunos 1- Cadastro de alunos =
			 * Linha 51
			 * 2- Atualização aluno = Linha 87 3- Exclusão de aluno = Linha 127 4- Voltar =
			 * Voltar
			 */
			int option = Util.optionPainel(sc,
					new String[] { "[1] - Cadastrar Alunos", "[2] - Atualizar Alunos",
							"[3] - Excluir aluno", "[4] - Ver alunos", "[5] - Voltar" });
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
					GerenciarAlunosController.verAluno(sc, db);
					return;
				case 5:
					System.out.println("Voltando a página anterior!");
					return;
				default:
					System.out.println("\nDigite uma opção válida!\n");
					break;
			}
		}
	}

	private static void cadastrarAluno(Scanner sc, Database db) {
		// Metodo para imput dos dados do Aluno a ser cadastrado
		String nome;
		String genero;
		String senha = "";
		String turno;
		String curso;
		System.out.print("Digite o nome do aluno: ");
		nome = sc.nextLine();
		System.out.print("Digite o gênero do aluno: ");
		genero = sc.nextLine();
		System.out.print("Escolha um turno para o aluno: ");
		turno = sc.nextLine();
		System.out.print("Escolha um curso para o aluno: ");
		curso = sc.nextLine();
		for (int i = 0; i < 1; i++) {
			System.out.print("Digite uma senha: ");
			senha = sc.nextLine();
			System.out.print("Digite a senha novamente: ");
			String senhaRepetida = sc.nextLine();
			if (!senha.equals(senhaRepetida)) {
				Util.limparTela();
				System.out.println("As senhas não coincidem");
				i--;
			}
		}
		Aluno aluno = new Aluno(nome, senha, genero, turno, curso);
		db.cadastrarAluno(aluno);
		System.out.println("Aluno cadastrado com sucesso!");
	}

	private static void atualizarAluno(Scanner sc, Database db) {
		// Metodo de atualização das informações de um aluno
		System.out.print("Digite o aluno que deseja modificar:\t");
		String registroAluno = sc.nextLine();
		Aluno aluno = db.getAluno(registroAluno);
		if (aluno == null) {
			System.out.println();
			System.out.println("Aluno não encontrado!!");
			return;
		}
		System.out.println("O que deseja modificar?");
		int option = Util.optionPainel(sc, new String[] { "[1] - Turno", "[2] - Curso" });
		int acc = 0;
		while (acc < 1) {
			switch (option) {
				case 1:
					System.out.print("Digite o novo turno:\t");
					String turno = sc.nextLine();
					aluno.setTurno(turno);
					db.atualizarAluno(aluno);
					acc++;
					break;
				case 2:
					System.out.print("Digite o novo curso:\t");
					String curso = sc.nextLine();
					aluno.setCurso(curso);
					db.atualizarAluno(aluno);
					acc++;
					break;
				default:
					System.out.println("Essa opção não existe!");
					acc--;
					break;
			}
		}
	}

	private static void excluirAluno(Scanner sc, Database db) {
		// Metodo para exclusão de aluno
		System.out.println("Digite o nome do aluno que deseja excluir:\t");
		String nomeAluno = sc.nextLine();
		Aluno aluno = db.getAluno(nomeAluno);
		if (aluno == null) {
			System.out.println("\nAluno não encontrado!!\n");
			return;
		}
		db.excluirAluno(aluno);
		System.out.println("Aluno excluído com sucesso!");
	}

	private static void verAluno(Scanner sc, Database db) {
		List<Aluno> alunos = db.getAlunos();
		for (Aluno aluno : alunos) {
			System.out.printf("RA: %s\t | Aluno: %s\t | Curso: %s\t | Turno: %s\t | \n", aluno.getRa(),
					aluno.getNome(), aluno.getCurso(), aluno.getTurno());
		}
		System.out.print("\nPressione enter para prosseguir...");
		sc.nextLine();
	}
}
