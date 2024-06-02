package controllers.logins.aluno;

import extras.Util;
import java.util.List;
import java.util.Scanner;
import models.Aluno;
import models.Database;
import models.Professor;

public class AlunoController {
	public static void loginAluno(Scanner scanner, Database database) {
		String sessionAluno = "";
		String user = "";
		String senha = "";
		while (true) {
			Util.limparTela();
			if (sessionAluno == "") {
				System.out.print("Informe o nome para login:\t");
				user = scanner.nextLine();
				System.out.print("Informe a senha para login:\t");
				senha = scanner.nextLine();
				sessionAluno = "logado";
			}
			Aluno aluno = database.getAluno(user);
			if (aluno == null) {
				System.out.println("Usuário não encontrado! Pressione enter para voltar...");
				scanner.nextLine();
				return;
			}
			if (!aluno.getSenha().equals(senha)) {
				System.out.println("Usuário ou senha incorretos! Pressione enter para voltar a página inicial...");
				scanner.nextLine();
				return;
			}
			Util.limparTela();
			System.out.println("Usuário logado com sucesso!");
			int option = Util.optionPainel(scanner, new String[] { " 1  Mostrar sala disponível",
					" 2  Entrar na sala e marcar presença", " 3  Ver meus dados", " 4  Sair da conta" });
			switch (option) {
				case 1:
					AlunoController.informarDadosDaSala(scanner, aluno);
					break;
				case 2:
					AlunoController.marcarPresenca(scanner, database, aluno);
					break;
				case 3:
					AlunoController.mostrarDadosAluno(scanner, aluno);
					break;
				case 4:
					System.out.println("Saindo da conta de aluno...");
					return;
				default:
					System.out.println("\nDigite uma opção válida!\n");
					break;
			}
		}
	}

	private static void marcarPresenca(Scanner scanner, Database database, Aluno aluno) {
		if (aluno.getSala() == 0) {
			System.out.println("Você não possui aulas para marcar presença");
			System.out.println("Pressione enter para voltar...");
			scanner.nextLine();
			return;
		}
		System.out.print("Informe o código da sala para marcar presença:\t");
		String codigoSala = scanner.nextLine();
		List<Professor> professores = database.getProfessores();
		for (Professor p : professores) {
			if (aluno.getUc().equals(p.getUc())) {
				if (p.getCodigoSala().equals(codigoSala)) {
					aluno.setPresente(true);
					System.out.println("Você marcou presença na aula!");
				} else {
					System.out.println("Código para marcar presença incorreto!");
				}
				break;
			}
		}
		System.out.println("Pressione enter para voltar...");
		scanner.nextLine();
	}

	private static void informarDadosDaSala(Scanner scanner, Aluno aluno) {
		if (aluno.getSala() != 0) {
			System.out.printf("Você tem uma aula: %s - Sala %d%n", aluno.getUc(), aluno.getSala());
		} else {
			System.out.println("Você ainda não possui aulas disponíveis, tente novamente mais tarde!");
		}
		System.out.println("Pressione enter para voltar...");
		scanner.nextLine();
	}

	private static void mostrarDadosAluno(Scanner scanner, Aluno aluno) {

		System.out.printf("--------------------------------------------------------------------------------------------------------------------%n");
		System.out.printf("|                                                      ALUNO                                                       |%n");
		System.out.printf("--------------------------------------------------------------------------------------------------------------------%n");
		System.out.printf("| %-20s | %-10s | %-25s | %-10s | %-35s |%n", "Nome", "Gênero", "Curso", "Turno", "UC");
		System.out.printf("--------------------------------------------------------------------------------------------------------------------%n");
		System.out.printf("| %-20s | %-10s | %-25s | %-10s |", aluno.getNome(),
					aluno.getGenero(), aluno.getCurso(), aluno.getTurno());

		System.out.printf(" %-35s |%n", aluno.getUc() != null ? aluno.getUc() : "Ainda não possui");
		System.out.printf("--------------------------------------------------------------------------------------------------------------------%n");
		System.out.println("Pressione enter para voltar...");
		scanner.nextLine();
	}
}
