package controllers.logins.admin;

import java.util.Scanner;

import controllers.logins.admin.gerenciar.GerenciarAlunosController;
import extras.Util;
import models.Database;

public class AdministradorController {
    public static void loginAdmin(Scanner sc, Database db, String administrador, String senhaAdministrador) {
        while (true) {
            Util.limparTela();
            System.out.print("Informe o usuário para login:\t");
            String user = sc.next();
            System.out.print("Informe a senha para login:\t");
            String senha = sc.next();
            if (!administrador.equals(user) || !senhaAdministrador.equals(senha)) {
                Util.limparTela();
                System.out.println("Usuário ou senha incorretos!");
                System.out.println("Deseja tentar novamente? [0]Não/[1]Sim - Padrão: Não");
                int prosseguir = sc.nextInt();
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
                    "[1]- Gerenciar alunos",
                    "[2]- Gerenciar professores",
                    "[3]- Sair da conta"
            });
            switch (option) {
                case 1:
                    GerenciarAlunosController.gerenciarAlunos(sc, db);
                    break;
                case 2:
                    // Programa.gerenciarProfessores();
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
