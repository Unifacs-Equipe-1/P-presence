package controllers.logins.aluno;

import extras.Util;
import java.util.List;
import java.util.Scanner;
import models.Aluno;
import models.Database;
import models.Professor;

public class AlunoController {
	public static void loginAluno(Scanner sc, Database db) {
		while (true) {
			Util.limparTela();
			System.out.print("Informe o nome para login:\t");
			String user = sc.nextLine();
			System.out.print("Informe a senha para login:\t");
			String senha = sc.nextLine();
			Aluno aluno = db.getAluno(user);
			if (aluno == null) {
				System.out.println("Usuário não encontrado! Pressione enter para voltar...");
				sc.nextLine();
				return;
			}
			if (!aluno.getSenha().equals(senha)) {
				System.out.println("Usuário ou senha incorretos! Pressione enter para voltar a página inicial...");
				sc.nextLine();
				return;
			}
			Util.limparTela();
			System.out.println("Usuário logado com sucesso!");
			int option = Util.optionPainel(sc, new String[] {"[1]- Mostrar sala disponível", "[2]- Entrar na sala e marcar presença", "[3]- Ver meus dados", "[4]- Sair da conta"});
			switch (option) {
				case 1:
					AlunoController.informarDadosDaSala(sc, aluno);
					break;
				case 2:
					AlunoController.marcarPresenca(sc, db, aluno);
					break;
				case 3:
					AlunoController.mostrarDadosAluno(sc, aluno);
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

	private static void marcarPresenca(Scanner sc, Database db, Aluno aluno) {
		if (aluno.getSala() == 0) {
			System.out.println("Você não possui aulas para marcar presença");
			System.out.println("Pressione enter para voltar...");
			sc.nextLine();
			return;
		}
		System.out.print("Informe o código da sala para marcar presença:\t");
		String codigoSala = sc.nextLine();
		List<Professor> professores = db.getProfessores();
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
		sc.nextLine();
	}

	private static void informarDadosDaSala(Scanner sc, Aluno aluno) {
		if (aluno.getSala() != 0) {
			System.out.printf("Você tem uma aula: %s - Sala %d%n", aluno.getUc(), aluno.getSala());
		} else {
			System.out.println("Você ainda não possui aulas disponíveis, tente novamente mais tarde!");
		}
		System.out.println("Pressione enter para voltar...");
		sc.nextLine();
	}

	private static void mostrarDadosAluno(Scanner sc, Aluno aluno) {
		System.out.printf("O nome do aluno: %s%n", aluno.getNome());
		System.out.printf("O gênero do aluno: %s%n", aluno.getGenero());
		System.out.printf("O curso do aluno: %s%n", aluno.getCurso());
		System.out.printf("O turno do aluno: %s%n", aluno.getTurno());
		System.out.printf("A UC do aluno: %s%n%n", aluno.getUc() != null ? aluno.getUc() : "Ainda não possui");
		System.out.println("Pressione enter para voltar...");
		sc.nextLine();
	}
}
