package clientes;

import java.util.ArrayList;

public class Database {
    private ArrayList<Aluno> alunos = new ArrayList<>();
    private ArrayList<Professor> professores = new ArrayList<>();

    public Database(ArrayList<Aluno> alunosStart, ArrayList<Professor> professoresStart) {
        if (alunosStart != null && professoresStart != null) {
            for (Aluno aluno : alunosStart) {
                alunos.add(aluno);
            }
            for (Professor professor : professoresStart) {
                professores.add(professor);
            }
        }
    }

    public ArrayList<Aluno> getAlunos() {
        return this.alunos;
    }

    public ArrayList<Professor> getProfessores() {
        return this.professores;
    }

    public void cadastrarAluno(Aluno aluno) {
        alunos.add(aluno);
    }

    public Aluno getAluno(String name) {
        for (Aluno a : this.alunos) {
            if (a.getNome().equals(name)) {
                return a;
            }
        }
        return null;
    }

    public void atualizarAluno(Aluno aluno) {
        for (Aluno a : this.alunos) {
            if (a.getRa().equals(aluno.getRa())) {
                this.alunos.set(this.alunos.indexOf(a), aluno);
                break;
            }
        }
    }

    public void excluirAluno(Aluno aluno) {
        alunos.remove(aluno);
    }
}
