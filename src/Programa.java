import controllers.logins.admin.AdministradorController;
import controllers.logins.aluno.AlunoController;
import controllers.logins.professor.ProfessorController;
import extras.Util;
import java.util.Scanner;
import java.util.UUID;
import models.Aluno;
import models.Database;
import models.Professor;

public class Programa {
	public static void main(String[] args) {
		String administrador = "admin";
		String senhaAdministrador = "admin";
		Database db = new Database();
		// Informações referente aos dados dos alunos
		db.cadastrarAluno(new Aluno("Erick", "Masculino", UUID.randomUUID().toString(), "abc", "Matutino",
				"Ciência da Computação"));
		db.cadastrarAluno(new Aluno("Marcilio", "Masculino", UUID.randomUUID().toString(), "123", "Matutino",
				"Ciência da Computação"));
		db.cadastrarAluno(new Aluno("Rodson", "Masculino", UUID.randomUUID().toString(), "teste", "Matutino",
				"Ciência da Computação"));
		db.cadastrarAluno(new Aluno("Arthur", "Masculino", UUID.randomUUID().toString(), "789", "Matutino",
				"Ciência da Computação"));
		db.cadastrarAluno(new Aluno("Marcus", "Masculino", UUID.randomUUID().toString(), "senha", "Matutino",
				"Ciência da Computação"));
		db.cadastrarAluno(new Aluno("Marcela", "Feminino", UUID.randomUUID().toString(), "password", "Matutino",
				"Ciência da Computação"));
		db.cadastrarProfessor(new Professor("Eliane", UUID.randomUUID().toString(), "profeliane", "Matutino",
				"Ciência da Computação", "Programas e soluções computacionais"));
		Scanner sc = new Scanner(System.in);
		while (true) {
			Util.limparTela();
			// Apresenta as opções na tela e retorna a opção escolhida
			int option = Util.optionPainel(sc,
					new String[] { "[1]- Fazer login como aluno", "[2]- Fazer login como professor",
							"[3]- Fazer login como administrador", "[4]- Sair do programa" });
			// Abre um novo painel com base na opção escolhida
			switch (option) {
				case 1:
					/*
					 * Método responsável por logar o aluno
					 */
					AlunoController.loginAluno(sc, db);
					break;
				case 2:
					/*
					 * Método responsável por logar o professor
					 */
					ProfessorController.loginProfessor(sc, db);
					break;
				case 3:
					/*
					 * Método responsável por logar o administrador
					 */
					AdministradorController.loginAdmin(sc, db, administrador, senhaAdministrador);
					break;
				case 4:
					/*
					 * Uma pequena mensagem para simbolizar que finalizou o programa
					 */
					System.out.println("Volte sempre!");
					sc.close();
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
