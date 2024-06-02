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

	public Aluno getAluno(String registro_aluno) {
		for (Aluno a : this.alunos) {
			if (a.getRa().equals(registro_aluno)) {
				return a;
			}
		}
		return null;
	}

	public List<Aluno> getAlunos() {
		return this.alunos;
	}

	// método que retorna lista de alunos com base no nome
	public List<Aluno> getAlunos(String name) {
		List<Aluno> alunos = new ArrayList<>();
		for (Aluno a : this.alunos) {
			if (a.getNome().contains(name)) {
				alunos.add(a);
			}
		}
		return alunos;
	}

	public void cadastrarAluno(Aluno aluno) {
		alunos.add(aluno);
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

	public Professor getProfessor(String registro_professor) {
		for (Professor p : this.professores) {
			if (p.getRp().equals(registro_professor)) {
				return p;
			}
		}
		return null;
	}

	public List<Professor> getProfessores() {
		return this.professores;
	}

	// Método que retorna lista de professores com base no nome
	public List<Professor> getProfessores(String name) {
		List<Professor> profs = new ArrayList<>();
		for (Professor p : this.professores) {
			if (p.getNome().contains(name)) {
				profs.add(p);
			}
		}
		return profs;
	}

	public void cadastrarProfessor(Professor professor) {

		professores.add(professor);
	}

	public void atualizarProfessor(Professor professor) {
		for (Professor p : this.professores) {
			if (p.getRp().equals(professor.getRp())) {
				this.professores.set(this.professores.indexOf(p), professor);
				break;
			}
		}
	}

	public void excluirProfessor(Professor professor) {
		professores.remove(professor);
	}

}
