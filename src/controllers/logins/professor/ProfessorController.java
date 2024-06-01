package controllers.logins.professor;

import extras.Util;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;
import models.Aluno;
import models.Database;
import models.Professor;

public class ProfessorController {
	public static void loginProfessor(Scanner scanner, Database database) {
		String sessionProf = "";
		String user = "";
		String senha = "";
		while (true) {
			// Metodo de Login como professor
			Util.limparTela();
			if (sessionProf == "") {
				System.out.print("Informe o nome para login:\t");
				user = scanner.nextLine();
				System.out.print("Informe a senha para login:\t");
				senha = scanner.nextLine();
				sessionProf = "logado";
			}
			Professor professor = database.getProfessor(user);
			if (professor == null) {
				System.out.println("Usuário não encontrado! Pressione enter para voltar...");
				scanner.nextLine();
				return;
			}
			if (!professor.getSenha().equals(senha)) {
				System.out.println("Usuário ou senha incorretos! Pressione enter para voltar a página inicial...");
				scanner.nextLine();
				return;
			}
			Util.limparTela();
			int option = Util.optionPainel(scanner, new String[] { "[1]- Configurar sala", "[2]- Gerar código da sala",
					"[3]- Ver todos os alunos", "[4]- Sair da conta" });
			switch (option) {
				/*
				 * Cada opção serve para um caso em especifico 1 - Configuração = Criação de
				 * sala 2 - Gerar código =
				 * Uma espécie de senha para o Aluno para confirmar que ele estava realmente
				 * presente 3 - Ver os
				 * Alunos = Visualizar uma lista com todos os alunos 4 - Sair = Sair
				 */
				case 1:
					ProfessorController.configurarSala(scanner, database, professor);
					break;
				case 2:
					ProfessorController.gerarCodigo(scanner, database, professor);
					break;
				case 3:
					ProfessorController.verAlunos(scanner, database);
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

	private static void gerarCodigo(Scanner sc, Database database, Professor professor) {
		professor.setCodigo(UUID.randomUUID().toString());
		database.atualizarProfessor(professor);
		System.out.printf("Informe esse código para os alunos marcarem presença: %s%n", professor.getCodigoSala());
		System.out.println("Pressione enter para voltar a página anterior...");
		sc.nextLine();
	}

	private static void configurarSala(Scanner sc, Database database, Professor professor) {
		List<Aluno> alunos = database.getAlunos();
		for (int index = 0; index < 1; index++) {
			try {
				System.out.print("Informe a sala que deseja usar:\t");
				int sala = sc.nextInt();
				sc.nextLine();
				professor.setSala(sala);
				database.atualizarProfessor(professor);
			} catch (Exception _e) {
				sc.nextLine();
				System.out.println("Sala inexistente, digite uma sala válida");
				index--;
			}
		}
		for (Aluno aluno : alunos) {
			aluno.setUc(professor.getUc());
			aluno.setSala(professor.getSala());
			database.atualizarAluno(aluno);
		}
		System.out.println("Sala criada!");
		System.out.println("Pressione enter para voltar a página anterior...");
		sc.nextLine();
	}

	private static void verAlunos(Scanner sc, Database database) {
		List<Aluno> alunos = database.getAlunos();
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
		sc.nextLine();
	}
}
