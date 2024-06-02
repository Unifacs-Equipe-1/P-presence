package controllers.logins.admin.gerenciar;

import extras.Util;
import java.util.List;
import java.util.Scanner;
import models.Database;
import models.Professor;

public class GerenciarProfessoresController {
	public static void gerenciarProfessores(Scanner scanner, Database banco_de_dados) {
		while (true) {
			/*
			 * Opção do Administrador para o gerenciamento dos professores 1 - Cadastro de
			 * um novo
			 * Professor = Linha 2 - Atualização de dados de um professor = Linha 3 -
			 * Exclusão de um
			 * professor = Linha 4 - Lista dos professores = Linha 5 - Voltar = Voltar
			 */
			int opcao = Util.optionPainel(scanner,
					new String[] { " 1  Cadastrar Professores", " 2  Atualizar Professores",
							" 3  Excluir Professor", " 4  Ver Professores",
							" 5  Voltar a página anterior" });
			switch (opcao) {
				case 1:
					GerenciarProfessoresController.cadastrarProfessor(scanner, banco_de_dados);
					break;
				case 2:
					GerenciarProfessoresController.atualizarProfessor(scanner, banco_de_dados);
					break;
				case 3:
					GerenciarProfessoresController.excluirProfessor(scanner, banco_de_dados);
					break;
				case 4:
					GerenciarProfessoresController.verProfessor(scanner, banco_de_dados);
				case 5:
					System.out.println("Voltando a página anterior!");
					return;
				default:
					System.out.println("\nDigite uma opção válida!\n");
					break;
			}
		}
	}

	private static void cadastrarProfessor(Scanner scanner, Database banco_de_dados) {
		// Metodo de cadastro do professor
		String nome;
		String senha = "";
		String turno;
		String curso;
		String uc;
		System.out.print("Digite o nome do professor: ");
		nome = scanner.nextLine();
		System.out.print("Escolha um turno para o professor: ");
		turno = scanner.nextLine();
		System.out.print("Escolha um curso para o professor: ");
		curso = scanner.nextLine();
		System.out.print("Escolha a UC do professor: ");
		uc = scanner.nextLine();
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
		Professor professor = new Professor(nome, senha, turno, curso, uc);
		banco_de_dados.cadastrarProfessor(professor);
		System.out.println("Professor cadastrado com sucesso!");
	}

	private static void atualizarProfessor(Scanner scanner, Database banco_de_dados) {
		// Metodo de atualização de professor
		System.out.print("Digite o professor que deseja modificar:\t");
		String nome_professor = scanner.nextLine();
		Professor professor = banco_de_dados.getProfessor(nome_professor);
		if (professor == null) {
			System.out.println("\nProfessor nao encontrado!!\n");
			return;
		}
		System.out.println("O que deseja modificar?");
		int opcao = Util.optionPainel(scanner, new String[] { " 1  Turno", " 2  Curso" });
		int acumulador = 0;
		while (acumulador < 1) {
			switch (opcao) {
				case 1:
					System.out.print("Digite o novo turno:\t");
					String turno = scanner.nextLine();
					professor.setTurno(turno);
					banco_de_dados.atualizarProfessor(professor);
					acumulador++;
					break;
				case 2:
					System.out.print("Digite o novo curso:\t");
					String curso = scanner.nextLine();
					professor.setCurso(curso);
					banco_de_dados.atualizarProfessor(professor);
					acumulador++;
					break;
				default:
					System.out.println("Essa opção não existe!");
					acumulador--;
					break;
			}
		}
	}

	private static void excluirProfessor(Scanner scanner, Database banco_de_dados) {
		// Metodo de exclusão de professor
		System.out.println("Digite o nome do professor(a) que deseja excluir:\t");
		String nome_professor = scanner.nextLine();
		Professor professor = banco_de_dados.getProfessor(nome_professor);
		if (professor == null) {
			System.out.println("\nProfessor nao encontrado!!\n");
			return;
		}
		banco_de_dados.excluirProfessor(professor);
		System.out.println("\n Professor(a) excluído com sucesso!");

	}

	private static void verProfessor(Scanner scanner, Database banco_de_dados) {
		// Metodo de visualização de professor
		List<Professor> professores = banco_de_dados.getProfessores();

		System.out.printf("-------------------------------------------------------------------------------%n");
		System.out.printf("|                               PROFESSORES                                   |%n");
		System.out.printf("-------------------------------------------------------------------------------%n");
		System.out.printf("| %-11s | %-20s | %-25s | %-10s |%n", "RP", "Professor", "Curso", "Turno");
		System.out.printf("-------------------------------------------------------------------------------%n");
		for (Professor professor : professores) {
			System.out.printf("| %-11s | %-20s | %-25s | %-10s |%n", professor.getRp(),
					professor.getNome(), professor.getCurso(), professor.getTurno());
		}
		System.out.printf("-------------------------------------------------------------------------------%n");
		System.out.print("\nPressione enter para prosseguir...");
		scanner.nextLine();
	}
}
