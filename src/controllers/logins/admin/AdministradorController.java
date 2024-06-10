package controllers.logins.admin;

import controllers.logins.admin.gerenciar.GerenciarAlunosController;
import controllers.logins.admin.gerenciar.GerenciarProfessoresController;
import extras.Util;
import java.util.Scanner;
import models.Database;

public class AdministradorController {
	// Metodo de login como administrador / admin & admin
	public static void loginAdmin(Scanner scanner, Database banco_de_dados, String administrador,
			String senha_administrador) {
		String sessao_usuario = "";
		while (true) {
			String usuario = null;
			String senha = null;
			// Verificação de usuário e senha
			if (sessao_usuario.isEmpty()) {
				System.out.print("Informe o usuário para login:\t");
				usuario = scanner.nextLine();
				System.out.print("Informe a senha para login:\t");
				senha = scanner.nextLine();
				Util.limparTela();
			}
			// Verificação de usuário e senha
			if (!sessao_usuario.equals("admin")
					&& (!administrador.equals(usuario) || !senha_administrador.equals(senha))) {

				System.out.println("Usuário ou senha incorretos!");
				System.out.println("Deseja tentar novamente?");
				System.out.println("Pressione enter para responder...");
				scanner.nextLine();
				Util.limparTela();

				int prosseguir = Util.optionPainel(scanner, new String[] { " 0  Não (default)", " 1  Sim" });
				switch (prosseguir) {
					case 1:
						continue;
					case 0:
					default:
						System.out.println("Retornando a página inicial");
						System.out.print("\nPressione enter para prosseguir...");
						scanner.nextLine();
						Util.limparTela();
						return;
				}
			} else {
				sessao_usuario = "admin";
			}

			int opcao = Util.optionPainel(scanner, new String[] {
					/*
					 * Opções de ações para o ADM 1 - Vai para gerenciamento de Aluno
					 * (GerenciarAlunoController) 2 - Vai para gerenciamento de Prof
					 * (GerenciarProfessorController) 3 - Sair
					 */
					" 1  Gerenciar alunos", " 2  Gerenciar professores", " 3  Sair da conta" });
			switch (opcao) {
				case 1:
					/*
					 * Método para gerenciar alunos
					 */
					GerenciarAlunosController.gerenciarAlunos(scanner, banco_de_dados);
					break;
				case 2:
					// Programa.gerenciarProfessores();
					GerenciarProfessoresController.gerenciarProfessores(scanner, banco_de_dados);
					break;
				case 3:
					/*
					 * Sair da conta
					 * 
					 */
					System.out.println("Voltando a página inicial");
					System.out.print("\nPressione enter para prosseguir...");
					scanner.nextLine();
					Util.limparTela();
					return;
				default:
					/*
					 * Caso o usuário digite uma opção inválida
					 */
					System.out.println("\nDigite uma opção válida!\n");
					System.out.println("Pressione enter para prosseguir...");
					scanner.nextLine();
					Util.limparTela();
					break;
			}
		}

	}
}
