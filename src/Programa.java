
import java.util.ArrayList;
import java.util.Scanner;
import java.util.UUID;

import controllers.logins.admin.AdministradorController;
import controllers.logins.aluno.AlunoController;
import controllers.logins.professor.ProfessorController;
import extras.Util;
import models.Aluno;
import models.Database;
import models.Professor;

public class Programa {
        public static void main(String[] args) {
                String administrador = "admin";
                String senhaAdministrador = "admin";

                ArrayList<Aluno> alunosStart = new ArrayList<Aluno>();
                alunosStart.add(new Aluno("erick gomes", "masculino", UUID.randomUUID().toString(), "abc", "manhã",
                                "Ciência da Computação"));
                alunosStart.add(new Aluno("marcilio", "masculino", UUID.randomUUID().toString(), "123", "manhã",
                                "Ciência da Computação"));
                alunosStart.add(new Aluno("rodson", "masculino", UUID.randomUUID().toString(), "teste", "manhã",
                                "Ciência da Computação"));
                alunosStart.add(new Aluno("arthur", "masculino", UUID.randomUUID().toString(), "789", "manhã",
                                "Ciência da Computação"));
                alunosStart.add(new Aluno("marcus", "masculino", UUID.randomUUID().toString(), "senha", "manhã",
                                "Ciência da Computação"));
                alunosStart.add(new Aluno("marcela", "feminino", UUID.randomUUID().toString(), "password", "manhã",
                                "Ciência da Computação"));

                ArrayList<Professor> professoresStart = new ArrayList<Professor>();
                professoresStart.add(
                                new Professor("Eliane", UUID.randomUUID().toString(), "manhã", "Ciência da Computação",
                                                "Programas e soluções computacionais"));

                Database db = new Database(alunosStart, professoresStart);

                Scanner sc = new Scanner(System.in);
                while (true) {
                        Util.limparTela();
                        // Apresenta as opções na tela e retorna a opção escolhida
                        int option = Util.optionPainel(sc, new String[] {
                                        "[1]- Fazer login como aluno",
                                        "[2]- Fazer login como professor",
                                        "[3]- Fazer login como administrador",
                                        "[4]- Sair do programa"
                        });
                        // abre um novo painel com base na opção escolhida
                        switch (option) {
                                case 1:
                                        /*
                                         * Aqui deve ser implementado o método responsável por logar o aluno
                                         */
                                        AlunoController.loginAluno(sc);
                                        break;
                                case 2:
                                        /*
                                         * Aqui deve ser implementado o método responsável por logar o professor
                                         */
                                        ProfessorController.loginProfessor(sc, db);
                                        break;
                                case 3:
                                        /*
                                         * Aqui deve ser implementado o método responsável por logar o administrador
                                         */
                                        AdministradorController.loginAdmin(sc, db, administrador, senhaAdministrador);
                                        break;
                                case 4:
                                        System.out.println("Volte sempre!");
                                        sc.close();
                                        return;
                                default:
                                        System.out.println("\nDigite uma opção válida!\n");
                                        break;
                        }
                }
        }
}
