
import java.util.ArrayList;
import java.util.Scanner;
import java.util.UUID;

import clientes.Aluno;
import clientes.Database;
import clientes.Professor;
import extras.Util;

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
        professoresStart.add(new Professor("Eliane", UUID.randomUUID().toString(), "manhã", "Ciência da Computação",
                "Programas e soluções computacionais"));

        Database db = new Database(alunosStart, professoresStart);

        Scanner sc = new Scanner(System.in);
        for (int index = 0; index < 1; index++) {
            // Apresenta as opções na tela e retorna a opção escolhida
            int option = Util.optionPainel(sc, new String[] {
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
                    Programa.loginProfessor(sc, db);
                    break;
                case 3:
                    /*
                     * Aqui deve ser implementado o método responsável por logar o administrador
                     */
                    System.out.print("Informe o usuário para login:\t");
                    String user = sc.next();
                    System.out.print("Informe a senha para login:\t");
                    String senha = sc.next();
                    if (administrador.equals(user) && senhaAdministrador.equals(senha)) {
                        // após login
                        Util.limparTela();
                        Programa.loginAdmin(sc, db);
                    } else {
                        System.out.println("Usuário ou senha incorretos!");
                        index--;
                    }
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
            int option = Util.optionPainel(sc, new String[] {
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
    private static void loginProfessor(Scanner sc, Database db) {
        for (int i = 0; i < 1; i++) {
            int option = Util.optionPainel(sc, new String[] {
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
                    Programa.verAlunos(db);
                    break;
                default:
                    System.out.println("\nDigite uma opção válida!\n");
                    i--;
                    break;
            }
        }

    }

    private static void verAlunos(Database db) {
        ArrayList<Aluno> alunos = db.getAlunos();
        for (Aluno aluno : alunos) {
            System.out.println(aluno.getNome());
        }
    }

    // apresenta o painel do administrador
    private static void loginAdmin(Scanner sc, Database db) {
        for (int i = 0; i < 1; i++) {
            int option = Util.optionPainel(sc, new String[] {
                    "[1]- Gerenciar alunos",
                    "[2]- Gerenciar professores"
            });
            switch (option) {
                case 1:
                    Programa.gerenciarAlunos(sc, db);
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

    private static void gerenciarAlunos(Scanner sc, Database db) {
        for (int i = 0; i < 1; i++) {
            int option = Util.optionPainel(sc, new String[] {
                    "[1] - Cadastrar Alunos",
                    "[2] - Atualizar Alunos",
                    "[3] - Excluir aluno"
            });
            switch (option) {
                case 1:
                    Programa.cadastrarAluno(sc, db);
                    break;
                case 2:
                    Programa.atualizarAluno(sc, db);
                    break;
                case 3:
                    Programa.excluirAluno(sc, db);
                    break;
                default:
                    System.out.println("\nDigite uma opção válida!\n");
                    break;
            }
        }
    }

    private static void excluirAluno(Scanner sc, Database db) {
        System.out.println("Digite o nome do aluno que deseja excluir:\t");
        sc.useDelimiter("\\n");
        String nomeAluno = sc.next();
        Aluno aluno = db.getAluno(nomeAluno);
        db.excluirAluno(aluno);
        System.out.println("Aluno excluído com sucesso!");
        sc.reset();
    }

    private static void atualizarAluno(Scanner sc, Database db) {
        System.out.print("Digite o aluno que deseja modificar:\t");
        String nomeAluno = sc.next();
        Aluno aluno = db.getAluno(nomeAluno);
        System.out.println("O que deseja modificar?");
        int option = Util.optionPainel(sc, new String[] {
                "[1] - Turno",
                "[2] - Curso"
        });
        int acc = 0;
        while (acc < 1) {
            switch (option) {
                case 1:
                    System.out.print("Digite o novo turno:\t");
                    String turno = sc.next();
                    aluno.setTurno(turno);
                    db.atualizarAluno(aluno);
                    break;
                case 2:
                    System.out.print("Digite o novo curso:\t");
                    String curso = sc.next();
                    aluno.setCurso(curso);
                    db.atualizarAluno(aluno);
                    break;
                default:
                    System.out.println("Essa opção não existe!");
                    acc--;
                    break;
            }

        }
    }

    private static void cadastrarAluno(Scanner sc, Database db) {
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
                Util.limparTela();
                System.out.println("As senhas não coincidem");
                i--;
            }
        }

        Aluno aluno = new Aluno(nome, genero, ra, senha, turno, curso);
        db.cadastrarAluno(aluno);
        System.out.println("Aluno cadastrado com sucesso!");
        sc.reset();
    }
}
