package controllers.logins.admin;

import controllers.logins.admin.gerenciar.GerenciarAlunosController;
import controllers.logins.admin.gerenciar.GerenciarProfessoresController;
import extras.Util;
import java.util.Scanner;
import models.Database;

public class AdministradorController {

	public static void loginAdmin(Scanner sc, Database db, String administrador,
			String senhaAdministrador) {
		while (true) {
			// Metodo de login ADM
			Util.limparTela();
			System.out.print("Informe o usuário para login:\t");
			String user = sc.nextLine();
			System.out.print("Informe a senha para login:\t");
			String senha = sc.nextLine();
			if (!administrador.equals(user) || !senhaAdministrador.equals(senha)) {
				Util.limparTela();
				System.out.println("Usuário ou senha incorretos!");
				System.out.println("Deseja tentar novamente?");
				int prosseguir =
						Util.optionPainel(sc, new String[] {"[0]- Não (default)", "[1]- Sim"});
				switch (prosseguir) {
					case 1:
						continue;
					case 0:
					default:
						System.out.println("Retornando a página inicial");
						return;
				}
			}
			Util.limparTela();
			int option = Util.optionPainel(sc, new String[] {
					/*
					 * Opções de ações para o ADM 1 - Vai para gerenciamento de Aluno
					 * (GerenciarAlunoController) 2 - Vai para gerenciamento de Prof
					 * (GerenciarProfessorController) 3 - Sair
					 */
					"[1]- Gerenciar alunos", "[2]- Gerenciar professores", "[3]- Sair da conta"});
			switch (option) {
				case 1:
					GerenciarAlunosController.gerenciarAlunos(sc, db);
					break;
				case 2:
					// Programa.gerenciarProfessores();
					GerenciarProfessoresController.gerenciarProfessores(sc, db);
					break;
				case 3:
					System.out.println("Voltando a página inicial");
					return;
				default:
					System.out.println("\nDigite uma opção válida!\n");
					break;
			}
		}
	}
}
