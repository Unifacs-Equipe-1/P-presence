package controllers.logins.admin.gerenciar;

import controllers.logins.admin.gerenciar.filtroAlunos.FiltrarAlunosController;
import extras.Util;
import java.util.List;
import java.util.Scanner;
import models.Aluno;
import models.Database;

public class GerenciarAlunosController {
	// Método para gerenciar os alunos
	public static void gerenciarAlunos(Scanner scanner, Database banco_de_dados) {

		/*
		 * Opção do Administrador de gerenciamento dos alunos
		 * 1- Cadastro de alunos / 2- Atualização aluno / 3- Exclusão de aluno /
		 * 4- Ver todos os alunos/ 5- Filtrar Aluno / 6 - Voltar = Voltar
		 */
		while (true) {
			int option = Util.optionPainel(scanner,
					new String[] { " 1  Cadastrar Alunos", " 2  Atualizar Alunos",
							" 3  Excluir aluno", " 4  Ver alunos", " 5  Filtrar alunos", " 6  Voltar" });
			switch (option) {
				case 1:
					GerenciarAlunosController.cadastrarAluno(scanner, banco_de_dados);
					Util.limparTela();
					break;
				case 2:
					GerenciarAlunosController.atualizarAluno(scanner, banco_de_dados);
					Util.limparTela();
					break;
				case 3:
					GerenciarAlunosController.excluirAluno(scanner, banco_de_dados);
					Util.limparTela();
					break;
				case 4:
					GerenciarAlunosController.verAluno(scanner, banco_de_dados);
					Util.limparTela();
					return;
				case 5:
					FiltrarAlunosController.filtrarAlunos(scanner, banco_de_dados);
					Util.limparTela();
					return;
				case 6:
					System.out.println("Voltando a página anterior!");
					System.out.print("\nPressione enter para prosseguir...");
					scanner.nextLine();
					Util.limparTela();
					return;
				default:
					System.out.println("\nDigite uma opção válida!\n");
					System.out.println("Pressione enter para prosseguir...");
					scanner.nextLine();
					Util.limparTela();
					break;
			}
		}
	}

	// Metodo para imput dps dados de um Aluno a ser cadastrado
	private static void cadastrarAluno(Scanner scanner, Database banco_de_dados) {

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
			String senha_repetida = scanner.nextLine();
			if (!senha.equals(senha_repetida)) {
				Util.limparTela();
				System.out.println("As senhas não coincidem");
				i--;
			}
		}
		Aluno aluno = new Aluno(nome, senha, genero, turno, curso);
		banco_de_dados.cadastrarAluno(aluno);
		Util.limparTela();
		System.out.println("Aluno cadastrado com sucesso!");
		System.out.println("Pressione enter para prosseguir...");
		scanner.nextLine();
	}

	// Método de atualização das informações de um aluno
	private static void atualizarAluno(Scanner scanner, Database banco_de_dados) {

		System.out.print("Digite o RA do aluno que deseja modificar:\t");
		String registro_aluno = scanner.nextLine();
		Aluno aluno = banco_de_dados.getAluno(registro_aluno);
		if (aluno == null) {
			System.out.println();
			System.out.println("Aluno não encontrado!!");
			System.out.println("Pressione enter para prosseguir...");
			scanner.nextLine();
			Util.limparTela();
			return;
		}
		System.out.println("Pressione enter definir o que deseja modificar...");
		scanner.nextLine();
		Util.limparTela();
		int opcao = Util.optionPainel(scanner, new String[] { " 1  Turno", " 2  Curso" });
		int acumulador = 0;
		while (acumulador < 1) {
			switch (opcao) {
				case 1:
					System.out.print("Digite o novo turno:\t");
					String turno = scanner.nextLine();
					aluno.setTurno(turno);
					banco_de_dados.atualizarAluno(aluno);
					acumulador++;
					break;
				case 2:
					System.out.print("Digite o novo curso:\t");
					String curso = scanner.nextLine();
					aluno.setCurso(curso);
					banco_de_dados.atualizarAluno(aluno);
					acumulador++;
					break;
				default:
					System.out.println("Essa opção não existe!");
					System.out.println("Pressione enter para prosseguir...");
					scanner.nextLine();
					acumulador++;
					break;
			}
		}
	}

	// Método para exclusão de aluno
	private static void excluirAluno(Scanner scanner, Database banco_de_dados) {

		System.out.println("Digite o RA do aluno que deseja excluir:\t");
		String nome_aluno = scanner.nextLine();
		Util.limparTela();
		Aluno aluno = banco_de_dados.getAluno(nome_aluno);
		if (aluno == null) {
			System.out.println("Aluno não encontrado!!");
			System.out.println("Pressione enter para prosseguir...");
			scanner.nextLine();
			Util.limparTela();
			return;
		}
		System.out.println("Aluno encontrado, tem certeza que deseja excluir?");
		System.out.println("Pressione enter para responder...");
		scanner.nextLine();
		Util.limparTela();
		int escolha = Util.optionPainel(scanner, new String[] { " 1  Sim", " 2  Não (Padrão)" });
		if (escolha == 1) {
			banco_de_dados.excluirAluno(aluno);
			System.out.println("\n Aluno excluído com sucesso!");
			System.out.print("\nPressione enter para prosseguir...");
			scanner.nextLine();
		} else {
			System.out.println("Exclusão cancelada, pressione enter para prosseguir...");
			scanner.nextLine();
		}
	}

	// Método para a vizualição de todos os alunos
	private static void verAluno(Scanner scanner, Database banco_de_dados) {

		List<Aluno> alunos = banco_de_dados.getAlunos();
		System.out.printf("-------------------------------------------------------------------------------%n");
		System.out.printf("|                                  ALUNOS                                     |%n");
		System.out.printf("-------------------------------------------------------------------------------%n");
		System.out.printf("| %-11s | %-20s | %-25s | %-10s |%n", "RA", "Aluno", "Curso", "Turno");
		System.out.printf("-------------------------------------------------------------------------------%n");
		for (Aluno aluno : alunos) {
			System.out.printf("| %-11s | %-20s | %-25s | %-10s |%n", aluno.getRa(),
					aluno.getNome(), aluno.getCurso(), aluno.getTurno());
		}
		System.out.printf("-------------------------------------------------------------------------------%n");
		System.out.print("\nPressione enter para prosseguir...");
		scanner.nextLine();
	}
}
