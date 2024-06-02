package controllers.logins.professor;

import extras.Util;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;
import models.Aluno;
import models.Database;
import models.Professor;

public class ProfessorController {

	public static void loginProfessor(Scanner scanner, Database banco_de_dados) {
		String sessao_professor = "";
		String usuario = "";
		String senha = "";
		while (true) {
			// Metodo de Login como professor
			Util.limparTela();
			if (sessao_professor == "") {
				System.out.print("Informe RP para login:\t");
				usuario = scanner.nextLine();
				System.out.print("Informe a senha para login:\t");
				senha = scanner.nextLine();
				sessao_professor = "logado";
			}
			Professor professor = banco_de_dados.getProfessor(usuario);
			if (professor == null) {
				System.out.println(" \n Usuário não encontrado! \n Pressione enter para voltar...");
				scanner.nextLine();
				return;
			}
			if (!professor.getSenha().equals(senha)) {
				System.out
						.println(" \n Usuário ou senha incorretos! \n Pressione enter para voltar a página inicial...");
				scanner.nextLine();
				return;
			}
			Util.limparTela();
			int opcao = Util.optionPainel(scanner, new String[] { " 1  Configurar sala", " 2  Gerar código da sala",
					" 3  Ver todos os alunos", " 4  Sair da conta" });
			switch (opcao) {
				/*
				 * Cada opção serve para um caso em especifico
				 * 1 - Configuração = Criação de sala
				 * 2 - Gerar código = Uma espécie de senha para o Aluno para confirmar que ele
				 * estava realmente presente
				 * 3 - Ver os alunos = Visualizar uma lista com todos os alunos
				 * 4 - Sair = Sair
				 */
				case 1:
					ProfessorController.configurarSala(scanner, banco_de_dados, professor);
					break;
				case 2:
					ProfessorController.gerarCodigo(scanner, banco_de_dados, professor);
					break;
				case 3:
					ProfessorController.verAlunos(scanner, banco_de_dados);
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

	private static void gerarCodigo(Scanner sc, Database banco_de_dados, Professor professor) {
		if (professor.getSala() == null) {
			System.out.println("Sala não configurada, configure a sala antes de gerar o código");
			System.out.println("Pressione enter para voltar a página anterior...");
			sc.nextLine();
			return;
		}
		professor.setCodigo(UUID.randomUUID().toString());
		banco_de_dados.atualizarProfessor(professor);
		System.out.printf("Informe esse código para os alunos marcarem presença: %s%n", professor.getCodigoSala());
		System.out.println("Pressione enter para voltar a página anterior...");
		sc.nextLine();
	}

	private static void configurarSala(Scanner sc, Database banco_de_dados, Professor professor) {
		List<Aluno> alunos = banco_de_dados.getAlunos();
		for (int index = 0; index < 1; index++) {
			try {
				System.out.print("Informe o número da sala que deseja usar: \t");
				Integer sala = sc.nextInt();
				sc.nextLine();
				professor.setSala(sala.toString());
				banco_de_dados.atualizarProfessor(professor);
			} catch (Exception _e) {
				sc.nextLine();
				System.out.println("Sala inexistente, digite uma sala válida");
				index--;
			}
		}
		for (Aluno aluno : alunos) {
			aluno.setUc(professor.getUc());
			aluno.setSala(professor.getSala());
			banco_de_dados.atualizarAluno(aluno);
		}
		System.out.println("Sala criada!");
		System.out.println("Pressione enter para voltar a página anterior...");
		sc.nextLine();
	}

	private static void verAlunos(Scanner sc, Database banco_de_dados) {
		List<Aluno> alunos = banco_de_dados.getAlunos();
		System.out.printf(
				"------------------------------------------------------------------------------------------------------%n");
		System.out.printf(
				"|                                              ALUNOS                                                |%n");
		System.out.printf(
				"------------------------------------------------------------------------------------------------------%n");
		System.out.printf("| %-20s | %-25s | %-10s | %-34s |%n", "Nome", "Curso", "Turno", "Presença");
		System.out.printf(
				"------------------------------------------------------------------------------------------------------%n");

		for (Aluno aluno : alunos) {
			System.out.printf("| %-20s | %-25s | %-10s | ", aluno.getNome(), aluno.getCurso(),
					aluno.getTurno());
			if (aluno.getPresente() != null) {
				System.out.printf("%-34s |%n", aluno.getPresente() ? "Sim" : "Não");
			} else {
				System.out.println("Ainda não foi configurado uma sala |");
			}
		}
		System.out.printf(
				"------------------------------------------------------------------------------------------------------%n");

		System.out.print("\nPressione enter para prosseguir...");
		sc.nextLine();
	}
}
