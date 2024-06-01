package controllers.logins.admin.gerenciar;

import extras.Util;

import java.util.List;
import java.util.Scanner;
import models.Aluno;
import models.Database;

public class GerenciarAlunosController {
	public static void gerenciarAlunos(Scanner scanner, Database database) {

		/*
		 * Opção do Administrador de gerenciamento dos alunos
		 * 1- Cadastro de alunos / 2- Atualização aluno /
		 * 3- Exclusão de aluno / * 4- Voltar = Voltar /
		 */
		while (true) {
			int option = Util.optionPainel(scanner,
					new String[] { "[1] - Cadastrar Alunos", "[2] - Atualizar Alunos",
							"[3] - Excluir aluno", "[4] - Ver alunos", "[5] - Voltar" });
			switch (option) {
				case 1:
					GerenciarAlunosController.cadastrarAluno(scanner, database);
					break;
				case 2:
					GerenciarAlunosController.atualizarAluno(scanner, database);
					break;
				case 3:
					GerenciarAlunosController.excluirAluno(scanner, database);
					break;
				case 4:
					GerenciarAlunosController.verAluno(scanner, database);
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

	private static void cadastrarAluno(Scanner scanner, Database database) {
		// Metodo para imput dos dados do Aluno a ser cadastrado
		String nome;
		String genero;
		String senha = "";
		String turno;
		String curso;
		System.out.print("Digite o nome do aluno: ");
		nome = scanner.nextLine();
		System.out.print("Digite o gênero do aluno: ");
		genero = scanner.nextLine();
		System.out.print("Escolha um turno para o aluno: ");
		turno = scanner.nextLine();
		System.out.print("Escolha um curso para o aluno: ");
		curso = scanner.nextLine();
		for (int i = 0; i < 1; i++) {
			System.out.print("Digite uma senha: ");
			senha = scanner.nextLine();
			System.out.print("Digite a senha novamente: ");
			String senhaRepetida = scanner.nextLine();
			if (!senha.equals(senhaRepetida)) {
				Util.limparTela();
				System.out.println("As senhas não coincidem");
				i--;
			}
		}
		Aluno aluno = new Aluno(nome, senha, genero, turno, curso);
		database.cadastrarAluno(aluno);
		System.out.println("Aluno cadastrado com sucesso!");
	}

	private static void atualizarAluno(Scanner scanner, Database database) {
		// Metodo de atualização das informações de um aluno
		System.out.print("Digite o aluno que deseja modificar:\t");
		String registroAluno = scanner.nextLine();
		Aluno aluno = database.getAluno(registroAluno);
		if (aluno == null) {
			System.out.println();
			System.out.println("Aluno não encontrado!!");
			return;
		}
		System.out.println("O que deseja modificar?");
		int option = Util.optionPainel(scanner, new String[] { "[1] - Turno", "[2] - Curso" });
		int acc = 0;
		while (acc < 1) {
			switch (option) {
				case 1:
					System.out.print("Digite o novo turno:\t");
					String turno = scanner.nextLine();
					aluno.setTurno(turno);
					database.atualizarAluno(aluno);
					acc++;
					break;
				case 2:
					System.out.print("Digite o novo curso:\t");
					String curso = scanner.nextLine();
					aluno.setCurso(curso);
					database.atualizarAluno(aluno);
					acc++;
					break;
				default:
					System.out.println("Essa opção não existe!");
					acc--;
					break;
			}
		}
	}

	private static void excluirAluno(Scanner scanner, Database database) {
		// Metodo para exclusão de aluno
		System.out.println("Digite o nome do aluno que deseja excluir:\t");
		String nomeAluno = scanner.nextLine();
		Aluno aluno = database.getAluno(nomeAluno);
		if (aluno == null) {
			System.out.println("\nAluno não encontrado!!\n");
			return;
		}
		database.excluirAluno(aluno);
		System.out.println("Aluno excluído com sucesso!");
	}

	private static void verAluno(Scanner scanner, Database database) {
		List<Aluno> alunos = database.getAlunos();
		for (Aluno aluno : alunos) {
			System.out.printf("RA: %s\t | Aluno: %s\t | Curso: %s\t | Turno: %s\t | \n", aluno.getRa(),
					aluno.getNome(), aluno.getCurso(), aluno.getTurno());
		}
		System.out.print("\nPressione enter para prosseguir...");
		scanner.nextLine();
	}
}
