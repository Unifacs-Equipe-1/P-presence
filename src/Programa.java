import java.util.InputMismatchException;
import java.util.Scanner;

public class Programa {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (int index = 0; index < 1; index++) {
            // Apresenta as opções na tela e retorna a opção escolhida
            int option = Programa.optionPainel(sc, new String[] {
                    "[1]- Fazer login como aluno",
                    "[2]- Fazer login como professor",
                    "[3]- Fazer login como administrador"
            });
            // abre um novo painel com base na opção escolhida
            switch (option) {
                case 1:
                    /*
                     * Aqui deve ser implementado o método responsável por logar o aluno
                     */

                    // após login
                    Programa.loginAluno(sc);
                    break;
                case 2:
                    /*
                     * Aqui deve ser implementado o método responsável por logar o professor
                     */

                    // após login
                    Programa.loginProfessor(sc);
                    break;
                case 3:
                    /*
                     * Aqui deve ser implementado o método responsável por logar o administrador
                     */

                    // após login
                    Programa.loginAdmin(sc);
                    break;
                default:
                    System.out.println("\nDigite uma opção válida!\n");
                    index--;
                    break;
            }
        }
        sc.close();
    }

    // apresenta painel de aluno
    private static void loginAluno(Scanner sc) {
        for (int i = 0; i < 1; i++) {
            int option = Programa.optionPainel(sc, new String[] {
                    "[1]- Mostrar sala disponível",
                    "[2]- Entrar na sala e marcar presença",
                    "[3]- Ver meus dados"
            });
            switch (option) {
                case 1:
                    // Programa.informarDadosDaSala();
                    break;
                case 2:
                    // Programa.marcarPresenca();
                    break;
                case 3:
                    // Programa.mostrarDadosAluno();
                    break;
                default:
                    System.out.println("\nDigite uma opção válida!\n");
                    i--;
                    break;
            }
        }

    }

    // apresenta painel do professor
    private static void loginProfessor(Scanner sc) {
        for (int i = 0; i < 1; i++) {
            int option = Programa.optionPainel(sc, new String[] {
                    "[1]- Configurar sala",
                    "[2]- Gerar código da sala",
                    "[3]- Ver todos os alunos"
            });

            switch (option) {
                case 1:
                    // Programa.configurarSala();
                    break;
                case 2:
                    // Programa.gerarCodigo();
                    break;
                case 3:
                    // Programa.verAlunos();
                    break;
                default:
                    System.out.println("\nDigite uma opção válida!\n");
                    i--;
                    break;
            }
        }

    }

    // apresenta o painel do administrador
    private static void loginAdmin(Scanner sc) {
        for (int i = 0; i < 1; i++) {
            int option = Programa.optionPainel(sc, new String[] {
                    "[1]- Gerenciar alunos",
                    "[2]- Gerenciar professores"
            });
            switch (option) {
                case 1:
                    // Programa.gerenciarAlunos();
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

    // verifica se a opção escolhida é válida e retorna a opção
    private static int optionPainel(Scanner sc, String[] options) {
        System.out.println("Selecione uma das opções:\n");
        for (String value : options) {
            System.out.println(value);
        }
        System.out.print("\nInsira aqui: ");
        int option = -1;
        try {
            option = sc.nextInt();
        } catch (InputMismatchException e) {
            sc.nextLine();
        }
        Programa.limparTela();
        return option;
    }

    // limpa o console
    private static void limparTela() {
        for (int i = 0; i < 1000; i++) {
            System.out.println("\n");
        }
    }
}
