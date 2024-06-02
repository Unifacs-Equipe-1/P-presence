package controllers.logins.admin.gerenciar;

import extras.Util;
import java.util.List;
import java.util.Scanner;
import models.Database;
import models.Professor;

public class GerenciarProfessoresController {
	public static void gerenciarProfessores(Scanner scanner, Database database) {
		while (true) {
			/*
			 * Opção do Administrador para o gerenciamento dos professores 1 - Cadastro de
			 * um novo
			 * Professor = Linha 2 - Atualização de dados de um professor = Linha 3 -
			 * Exclusão de um
			 * professor = Linha 4 - Lista dos professores = Linha 5 - Voltar = Voltar
			 */
			int option = Util.optionPainel(scanner,
					new String[] { " 1  Cadastrar Professores", " 2  Atualizar Professores",
							" 3  Excluir Professor", " 4  Ver Professores",
							" 5  Voltar a página anterior" });
			switch (option) {
				case 1:
					GerenciarProfessoresController.cadastrarProfessor(scanner, database);
					break;
				case 2:
					GerenciarProfessoresController.atualizarProfessor(scanner, database);
					break;
				case 3:
					GerenciarProfessoresController.excluirProfessor(scanner, database);
					break;
				case 4:
					GerenciarProfessoresController.verProfessor(scanner, database);
				case 5:
					System.out.println("Voltando a página anterior!");
					return;
				default:
					System.out.println("\nDigite uma opção válida!\n");
					break;
			}
		}
	}

	private static void cadastrarProfessor(Scanner scanner, Database database) {
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
			String senhaRepetida = scanner.nextLine();
			if (!senha.equals(senhaRepetida)) {
				Util.limparTela();
				System.out.println("As senhas não coincidem");
				i--;
			}
		}
		Professor professor = new Professor(nome, senha, turno, curso, uc);
		database.cadastrarProfessor(professor);
		System.out.println("Professor cadastrado com sucesso!");
	}

	private static void atualizarProfessor(Scanner scanner, Database database) {
		// Metodo de atualização de professor
		System.out.print("Digite o professor que deseja modificar:\t");
		String nomeProfessor = scanner.nextLine();
		Professor professor = database.getProfessor(nomeProfessor);
		if (professor == null) {
			System.out.println("\nProfessor nao encontrado!!\n");
			return;
		}
		System.out.println("O que deseja modificar?");
		int option = Util.optionPainel(scanner, new String[] { " 1  Turno", " 2  Curso" });
		int acc = 0;
		while (acc < 1) {
			switch (option) {
				case 1:
					System.out.print("Digite o novo turno:\t");
					String turno = scanner.nextLine();
					professor.setTurno(turno);
					database.atualizarProfessor(professor);
					acc++;
					break;
				case 2:
					System.out.print("Digite o novo curso:\t");
					String curso = scanner.nextLine();
					professor.setCurso(curso);
					database.atualizarProfessor(professor);
					acc++;
					break;
				default:
					System.out.println("Essa opção não existe!");
					acc--;
					break;
			}
		}
	}

	private static void excluirProfessor(Scanner scanner, Database database) {
		// Metodo de exclusão de professor
		System.out.println("Digite o nome do professor(a) que deseja excluir:\t");
		String nomeProfessor = scanner.nextLine();
		Professor professor = database.getProfessor(nomeProfessor);
		if (professor == null) {
			System.out.println("\nProfessor nao encontrado!!\n");
			return;
		}
		database.excluirProfessor(professor);
		System.out.println("\n Professor(a) excluído com sucesso!");

	}

	private static void verProfessor(Scanner scanner, Database database) {
		// Metodo de visualização de professor
		List<Professor> professores = database.getProfessores();

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
