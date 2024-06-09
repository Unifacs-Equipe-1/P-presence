package controllers.logins.admin.gerenciar.filtroAlunos;

import extras.Util;
import java.util.List;
import java.util.Scanner;
import models.Aluno;
import models.Database;

public class FiltrarAlunosController {

	/*
	 * Metodo para filtrar os alunos
	 * 1- Filtrar Por Nome / 2- Filtrar Por Ra / 3- Filtrar Por Curso /
	 * 4- Filtrar Por Turno / 5- Filtrar Por Genero / 6 - Voltar = Voltar /
	 */
	public static void filtrarAlunos(Scanner scanner, Database banco_de_dados) {
		while (true) {
			int opcao = Util.optionPainel(scanner, new String[] { " 1  Filtrar por nome", " 2  Filtrar por RA",
					" 3  Filtrar por curso", " 4  Filtrar por turno", " 5  Filtrar por genero", " 6  Voltar" });
			switch (opcao) {
				case 1:
					/*
					 * Método para filtrar os alunos
					 */
					FiltrarAlunosController.filtrarPorNome(scanner, banco_de_dados);
					break;
				case 2:
					/*
					 * Método para filtrar os alunos
					 */
					FiltrarAlunosController.filtrarPorRA(scanner, banco_de_dados);
					break;
				case 3:
					/*
					 * Método para filtrar os alunos
					 */
					FiltrarAlunosController.filtrarPorCurso(scanner, banco_de_dados);
					break;
				case 4:
					/*
					 * Método para filtrar os alunos
					 */
					FiltrarAlunosController.filtrarPorTurno(scanner, banco_de_dados);
					break;
				case 5:
					/*
					 * Método para filtrar os alunos
					 */
					FiltrarAlunosController.filtrarPorGenero(scanner, banco_de_dados);
					break;
				case 6:
					/*
					 * Método para voltar a página anterior
					 */
					System.out.println("Voltando a página anterior!");
					return;
				default:
					/*
					 * Caso a opção não exista
					 */
					System.out.println("\nDigite uma opção válida!\n");
					break;
			}
		}
	}

	/*
	 * Case 1 =
	 * Método para filtrar os alunos
	 * Busca Por RA
	 */
	private static void filtrarPorRA(Scanner scanner, Database banco_de_dados) {
		System.out.println("O informe o RA: ");
		String ra = scanner.nextLine();
		List<Aluno> registros = banco_de_dados.getAlunosRA(ra);
		/*
		 * Tabela sendo filtrada pelo RA
		 * E mostrando os Atributos
		 */
		System.out.printf("-------------------------------------------------------------------------------%n");
		System.out.printf("|                                     RA " + ra + "                              |%n");
		System.out.printf("-------------------------------------------------------------------------------%n");
		System.out.printf("| %-11s | %-20s | %-25s | %-10s |%n", "Nome", "Genero", "Curso", "Turno", "RA", "Semestre");
		System.out.printf("-------------------------------------------------------------------------------%n");
		for (Aluno aluno : registros) {
			System.out.printf("| %-11s | %-20s | %-25s | %-10s |%n", aluno.getNome(),
					aluno.getGenero(), aluno.getCurso(), aluno.getTurno(), aluno.getRa());
		}
		System.out.printf("-------------------------------------------------------------------------------%n");
		System.out.print("\nPressione enter para prosseguir...");
		scanner.nextLine();

	}

	/*
	 * Metodo para filtrar os alunos
	 * Busca Por Nome
	 */
	private static void filtrarPorNome(Scanner scanner, Database banco_de_dados) {

		System.out.println("O informe o Nome: ");
		String nome = scanner.nextLine();
		List<Aluno> registros = banco_de_dados.getAlunosNome(nome);
		/*
		 * Tabela sendo filtrada pelo Nome
		 * E mostrando os Atributos
		 */
		System.out.printf("-------------------------------------------------------------------------------%n");
		System.out.printf("|                                     Nome " + nome + "                        |%n");
		System.out.printf("-------------------------------------------------------------------------------%n");
		System.out.printf("| %-11s | %-20s | %-25s | %-10s |%n", "Nome", "Genero", "Curso", "Turno", "RA");
		System.out.printf("-------------------------------------------------------------------------------%n");
		for (Aluno aluno : registros) {
			System.out.printf("| %-11s | %-20s | %-25s | %-10s |%n", aluno.getNome(),
					aluno.getGenero(), aluno.getCurso(), aluno.getTurno(), aluno.getRa());
		}
		System.out.printf("-------------------------------------------------------------------------------%n");
		System.out.print("\nPressione enter para prosseguir...");
		scanner.nextLine();
	}

	/*
	 * Metodo para filtrar os alunos
	 * Busca Por Curso
	 */
	private static void filtrarPorCurso(Scanner scanner, Database banco_de_dados) {
		System.out.println("O informe o Curso: ");
		String curso = scanner.nextLine();
		List<Aluno> registros = banco_de_dados.getAlunosCurso(curso);
		/*
		 * Tabela sendo filtrada pelo Curso
		 * E mostrando os Atributos
		 */
		System.out.printf("-------------------------------------------------------------------------------%n");
		System.out.printf("|                                     Curso " + curso + "                        |%n");
		System.out.printf("-------------------------------------------------------------------------------%n");
		System.out.printf("| %-11s | %-20s | %-25s | %-10s |%n", "Nome", "Genero", "Curso", "Turno", "RA");
		System.out.printf("-------------------------------------------------------------------------------%n");
		for (Aluno aluno : registros) {
			System.out.printf("| %-11s | %-20s | %-25s | %-10s |%n", aluno.getNome(),
					aluno.getGenero(), aluno.getCurso(), aluno.getTurno(), aluno.getRa());
		}
		System.out.printf("-------------------------------------------------------------------------------%n");
		System.out.print("\nPressione enter para prosseguir...");
		scanner.nextLine();
	}

	/*
	 * Metodo para filtrar os alunos
	 * Busca Por Turno
	 */
	private static void filtrarPorTurno(Scanner scanner, Database banco_de_dados) {
		System.out.println("O informe o Turno: ");
		String turno = scanner.nextLine();
		List<Aluno> registros = banco_de_dados.getAlunosTurno(turno);
		/*
		 * Tabela sendo filtrada pelo Turno
		 * E mostrando os Atributos
		 */
		System.out.printf("-------------------------------------------------------------------------------%n");
		System.out.printf("||                                     Turno " + turno + "                          |%n");
		System.out.printf("-------------------------------------------------------------------------------%n");
		System.out.printf("| %-11s | %-20s | %-25s | %-10s |%n", "Nome", "Genero", "Curso", "Turno", "RA");
		System.out.printf("-------------------------------------------------------------------------------%n");
		for (Aluno aluno : registros) {
			System.out.printf("| %-11s | %-20s | %-25s | %-10s |%n", aluno.getNome(),
					aluno.getGenero(), aluno.getCurso(), aluno.getTurno(), aluno.getRa());
		}
		System.out.printf("-------------------------------------------------------------------------------%n");
		System.out.print("\nPressione enter para prosseguir...");
		scanner.nextLine();
	}

	/*
	 * Metodo para filtrar os alunos
	 * Busca Por Genero
	 */
	private static void filtrarPorGenero(Scanner scanner, Database banco_de_dados) {
		System.out.println("O informe o Genero: ");
		String genero = scanner.nextLine();
		List<Aluno> registros = banco_de_dados.getAlunosGenero(genero);
		/*
		 * Tabela sendo filtrada pelo Genero
		 * E mostrando os Atributos
		 */
		System.out.printf("-------------------------------------------------------------------------------%n");
		System.out
				.printf("|                                     Genero " + genero + "                        |%n");
		System.out.printf("-------------------------------------------------------------------------------%n");
		System.out.printf("| %-11s | %-20s | %-25s | %-10s |%n", "Nome", "Genero", "Curso", "Turno", "RA");
		System.out.printf("-------------------------------------------------------------------------------%n");
		for (Aluno aluno : registros) {
			System.out.printf("| %-11s | %-20s | %-25s | %-10s |%n", aluno.getNome(),
					aluno.getGenero(), aluno.getCurso(), aluno.getTurno(), aluno.getRa());
		}
		System.out.printf("-------------------------------------------------------------------------------%n");
		System.out.print("\nPressione enter para prosseguir...");
		scanner.nextLine();
	}
}
