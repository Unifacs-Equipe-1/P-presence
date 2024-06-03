package models;

public abstract class Pessoa {
	private String nome = "";
	private String senha = "";
	private String turno = "";
	private String curso = "";

	protected Pessoa(String nome, String senha, String turno, String curso) {
		this.nome = nome;
		this.senha = senha;
		this.turno = turno;
		this.curso = curso;
	}

	// Getter e Setters de Pessoa
	public final String getNome() {
		return nome;
	}

	public final void setNome(String nome) {
		this.nome = nome;
	}

	public final String getSenha() {
		return senha;
	}

	public final String getTurno() {
		return turno;
	}

	public final void setTurno(String turno) {
		this.turno = turno;
	}

	public final String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}
}
