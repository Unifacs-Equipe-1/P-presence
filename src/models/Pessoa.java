package models;

//Classe pai designando pessoa
public abstract class Pessoa implements Comparable<Pessoa> {
	// Atributos de Pessoa
	private String nome = "";
	private String senha = "";
	private String turno = "";
	private String curso = "";

	// Constutor de Pessoa
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

	// Comparar os nomes dos objetos
	@Override
	public int compareTo(Pessoa pessoa) {
		return this.nome.compareTo(pessoa.getNome());
	}
}
