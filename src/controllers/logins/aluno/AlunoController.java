package controllers.logins.aluno;

import extras.Util;
import java.util.List;
import java.util.Scanner;
import models.Aluno;
import models.Database;
import models.Professor;

public class AlunoController {

	// Login como Aluno / RA & Senha
	public static void loginAluno(Scanner scanner, Database banco_de_dados) {
		String sessao_aluno = "";
		String usuario = "";
		String senha = "";
		while (true) {
			Util.limparTela();
			// Verificação de usuário e senha
			if (sessao_aluno.equals("")) {
				System.out.print("Informe RA para login:\t");
				usuario = scanner.nextLine();
				System.out.print("Informe a senha para login:\t");
				senha = scanner.nextLine();
				sessao_aluno = "logado";
			}
			// Verificação de usuário
			Aluno aluno = banco_de_dados.getAluno(usuario);
			if (aluno == null) {
				System.out.println(" \n RA não encontrado! \n Pressione enter para voltar...");
				scanner.nextLine();
				return;
			}
			// Verificação de senha
			if (!aluno.getSenha().equals(senha)) {
				System.out
						.println(" \n RA ou senha incorretos! \n Pressione enter para voltar a página inicial...");
				scanner.nextLine();
				return;
			}
			Util.limparTela();
			// Painel do Aluno
			System.out.println("Usuário logado com sucesso!");
			int opcao = Util.optionPainel(scanner, new String[] { " 1  Mostrar sala disponível",
					" 2  Entrar na sala e marcar presença", " 3  Ver meus dados", " 4  Sair da conta" });
			/*
			 * Painel do Aluno:
			 * 1- Mostrar sala da aula disponível (A sala que o professor criou)
			 * 2- Entrar na sala de aula e marcar a presença com o código da sala (Enviado
			 * pelo professor)
			 * 3- Ver as informações (Nome / Genero / Curso / Turno / UC)
			 * 4-
			 */
			switch (opcao) {
				case 1:
					/*
					 * Método para informar a sala
					 */
					AlunoController.informarDadosDaSala(scanner, aluno);
					break;
				case 2:
					/*
					 * Método para marcar presença
					 */
					AlunoController.marcarPresenca(scanner, banco_de_dados, aluno);
					break;
				case 3:
					/*
					 * Método para mostrar os dados do aluno
					 */
					AlunoController.mostrarDadosAluno(scanner, aluno);
					break;
				case 4:
					/*
					 * Sair da conta
					 */
					System.out.println("Saindo da conta de aluno...");
					return;
				default:
					/*
					 * Caso o usuário digite uma opção inválida
					 */
					System.out.println("\nDigite uma opção válida!\n");
					break;
			}
		}
	}

	// Métodos para o Aluno
	private static void informarDadosDaSala(Scanner scanner, Aluno aluno) {
		// Método para visualizar a sala
		if (aluno.getSala() != null) {
			System.out.printf("Você tem uma aula: %s - Sala %s%n", aluno.getUc(), aluno.getSala());
		} else {
			System.out.println("Você ainda não possui aulas disponíveis, tente novamente mais tarde!");
		}
		System.out.println("Pressione enter para voltar...");
		scanner.nextLine();
	}

	// Método para marcar a presença
	private static void marcarPresenca(Scanner scanner, Database banco_de_dados, Aluno aluno) {
		// Método para maracar a presença na sala de aula
		// Caso a sala não esteja disponivel (O professor não criou)
		if (aluno.getSala() == null) {
			System.out.println("Você não possui aulas para marcar presença");
			System.out.println("Pressione enter para voltar...");
			scanner.nextLine();
			return;
		}
		// Caso a sala esteja disponivel (O professor criou)
		System.out.print("Informe o código da sala para marcar presença:\t");
		String codigo_sala = scanner.nextLine();
		List<Professor> professores = banco_de_dados.getProfessores();
		for (Professor p : professores) {
			if (aluno.getUc().equals(p.getUc())) {
				if (p.getCodigoSala().equals(codigo_sala)) {
					aluno.setPresente(true);
					// Colocou o código certo
					System.out.println("Você marcou presença na aula!");
				} else {
					// Colocou o código errado
					System.out.println("Código para marcar presença incorreto!");
				}
				break;
			}
		}
		System.out.println("Pressione enter para voltar...");
		scanner.nextLine();
	}

	// Método para vizualizar os dados do aluno
	private static void mostrarDadosAluno(Scanner scanner, Aluno aluno) {
		// Método para vizualizar os dados do aluno (Nome / Genero / Curso / Turno / UC)
		System.out.printf(
				"--------------------------------------------------------------------------------------------------------------------%n");
		System.out.printf(
				"|                                                      ALUNO                                                       |%n");
		System.out.printf(
				"--------------------------------------------------------------------------------------------------------------------%n");
		System.out.printf("| %-20s | %-10s | %-25s | %-10s | %-35s |%n", "Nome", "Gênero", "Curso", "Turno", "UC");
		System.out.printf(
				"--------------------------------------------------------------------------------------------------------------------%n");
		System.out.printf("| %-20s | %-10s | %-25s | %-10s |", aluno.getNome(),
				aluno.getGenero(), aluno.getCurso(), aluno.getTurno());

		System.out.printf(" %-35s |%n", aluno.getUc() != null ? aluno.getUc() : "Ainda não possui");
		System.out.printf(
				"--------------------------------------------------------------------------------------------------------------------%n");
		System.out.println("Pressione enter para voltar...");
		scanner.nextLine();
	}
}
