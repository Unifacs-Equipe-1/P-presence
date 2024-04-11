
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.UUID;

import clientes.Aluno;
import clientes.Database;

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
                    Programa.verAlunos();
                    break;
                default:
                    System.out.println("\nDigite uma opção válida!\n");
                    i--;
                    break;
            }
        }

    }

    private static void verAlunos() {
        Database db = new Database(null, "./database/alunos.ser");
        try {
            ArrayList<Object> alunos = db.readOnFile();
            for (Object aluno : alunos) {
                System.out.println(((Aluno) aluno).getNome());
            }
        } catch (Exception e) {
            System.err.println(e);
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
                    Programa.gerenciarAlunos(sc);
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

    private static void gerenciarAlunos(Scanner sc) {
        for (int i = 0; i < 1; i++) {
            int option = Programa.optionPainel(sc, new String[] {
                    "[1] - Cadastrar Alunos",
                    "[2] - Atualizar Alunos",
                    "[3] - Excluir aluno"
            });
            switch (option) {
                case 1:
                    Programa.cadastrarAluno(sc);
                    break;
                case 2:
                    Programa.atualizarAluno();
                    break;
                case 3:
                    Programa.excluirAluno();
                    break;
                default:
                    System.out.println("\nDigite uma opção válida!\n");
                    break;
            }
        }
    }

    private static void excluirAluno() {

    }

    private static void atualizarAluno() {

    }

    private static void cadastrarAluno(Scanner sc) {
        String nome;
        String genero;
        String ra;
        String senha = "";
        String turno;
        String curso;
        sc.useDelimiter("\\n");
        System.out.print("Digite o nome do aluno: ");
        nome = sc.next();
        System.out.print("Digite o gênero do aluno: ");
        genero = sc.next();
        ra = UUID.randomUUID().toString();
        System.out.print("Escolha um turno para o aluno: ");
        turno = sc.next();
        System.out.print("Escolha um curso para o aluno: ");
        curso = sc.next();

        for (int i = 0; i < 1; i++) {
            System.out.print("Digite uma senha: ");
            senha = sc.next();
            System.out.print("Digite a senha novamente: ");
            String senhaRepetida = sc.next();
            if (!senha.equals(senhaRepetida)) {
                Programa.limparTela();
                System.out.println("As senhas não coincidem");
                i--;
            }
        }

        Aluno aluno = new Aluno(nome, genero, ra, senha, turno, curso);
        Database db = new Database(aluno, "./database/alunos.ser");
        db.saveOnFile();
        System.out.println("Aluno cadastrado com sucesso!");
        sc.reset();
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
