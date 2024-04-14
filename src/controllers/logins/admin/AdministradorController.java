package controllers.logins.admin;

import java.util.Scanner;

import controllers.logins.admin.gerenciar.GerenciarAlunosController;
import extras.Util;
import models.Database;

public class AdministradorController {
    public static void loginAdmin(Scanner sc, Database db, String administrador, String senhaAdministrador) {
        for (int i = 0; i < 1; i++) {
            System.out.print("Informe o usuário para login:\t");
            String user = sc.next();
            System.out.print("Informe a senha para login:\t");
            String senha = sc.next();
            if (!administrador.equals(user) || !senhaAdministrador.equals(senha)) {
                Util.limparTela();
                System.out.println("Usuário ou senha incorretos!");
                i--;
                continue;
            }
            Util.limparTela();
            int option = Util.optionPainel(sc, new String[] {
                    "[1]- Gerenciar alunos",
                    "[2]- Gerenciar professores"
            });
            switch (option) {
                case 1:
                    GerenciarAlunosController.gerenciarAlunos(sc, db);
                    break;
                case 2:
                    // Programa.gerenciarProfessores();
                    break;
                default:
                    System.out.println("\nDigite uma opção válida!\n");
                    i--;
                    break;
            }
        }
    }
}
