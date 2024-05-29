package models;

import java.util.ArrayList;
import java.util.List;

public class Database {
	private final List<Aluno> alunos;
	private final List<Professor> professores;

	public Database() {
		alunos = new ArrayList<>();
		professores = new ArrayList<>();
	}

	public List<Aluno> getAlunos() {
		return this.alunos;
	}

	public List<Professor> getProfessores() {
		return this.professores;
	}

	public void cadastrarAluno(Aluno aluno) {
		alunos.add(aluno);
	}

	public void cadastrarProfessor(Professor professor) {
		professores.add(professor);
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

	public Professor getProfessor(String name) {
		for (Professor p : this.professores) {
			if (p.getNome().equals(name)) {
				return p;
			}
		}
		return null;
	}

	public Professor getProfessorID(int id) {
		for (Professor p : this.professores) {
			if (p.getID() == (id)) {
				return p;
			}
		}
		return null;
	}

	public Aluno getAlunoID(int id) {
		for (Aluno a : this.alunos) {
			if (a.getID() == (id)) {
				return a;
			}
		}
		return null;
	}

	public void atualizarProfessor(Professor professor) {
		for (Professor p : this.professores) {
			if (p.getRa().equals(professor.getRa())) {
				this.professores.set(this.professores.indexOf(p), professor);
				break;
			}
		}
	}

	public void excluirProfessor(Professor professor) {
		professores.remove(professor);
	}
}
