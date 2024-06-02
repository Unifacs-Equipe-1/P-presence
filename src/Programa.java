import controllers.logins.admin.AdministradorController;
import controllers.logins.aluno.AlunoController;
import controllers.logins.professor.ProfessorController;
import extras.Util;
import java.util.Scanner;
import models.Aluno;
import models.Database;
import models.Professor;

public class Programa {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Database database = new Database();
		// Informações referente aos dados dos alunos
		database.cadastrarAluno(new Aluno("Marcilio", "123", "Masculino", "Matutino",
				"Ciência da Computação"));
		database.cadastrarAluno(new Aluno("Erick ", "abc", "Masculino", "Matutino",
				"Ciência da Computação"));
		database.cadastrarAluno(new Aluno("Rodson", "teste", "Masculino", "Matutino",
				"Ciência da Computação"));
		database.cadastrarAluno(new Aluno("Arthur", "789", "Masculino", "Matutino",
				"Ciência da Computação"));
		database.cadastrarAluno(new Aluno("Marcus", "senha", "Masculino", "Matutino",
				"Ciência da Computação"));
		database.cadastrarAluno(new Aluno("Marcela", "password", "Feminino", "Matutino",
				"Ciência da Computação"));
		database.cadastrarProfessor(new Professor("Eliane", "profeliane", "Matutino",
				"Ciência da Computação", "Programas e soluções computacionais"));
		String administrador = "admin";
		String senhaAdministrador = "admin";
		while (true) {
			Util.limparTela();
			// Apresenta as opções na tela e retorna a opção escolhida
			int option = Util.optionPainel(scanner,
					new String[] { " 1  Fazer login como aluno", " 2  Fazer login como professor",
							" 3  Fazer login como administrador", " 4  Sair do programa" });
			// Abre um novo painel com base na opção escolhida
			switch (option) {
				case 1:
					/*
					 * Método responsável por logar o aluno
					 */
					AlunoController.loginAluno(scanner, database);
					break;
				case 2:
					/*
					 * Método responsável por logar o professor
					 */
					ProfessorController.loginProfessor(scanner, database);
					break;
				case 3:
					/*
					 * Método responsável por logar o administrador
					 */
					AdministradorController.loginAdmin(scanner, database, administrador, senhaAdministrador);
					break;
				case 4:
					/*
					 * Uma pequena mensagem para simbolizar que finalizou o programa
					 */
					System.out.println("Volte sempre!");
					scanner.close();
					return;
				default:
					/*
					 * O metodo caso o usuário utilize outro valor
					 */
					System.out.println("\nDigite uma opção válida!\n");
					break;
			}
		}
	}
}
