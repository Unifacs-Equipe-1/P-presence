package models;

import extras.Util;
import java.util.UUID;

public class Aluno extends models.Pessoa {
	// atributos dos alunos
	private final String registro_aluno;
	private String genero;
	private String uc;
	private String sala;
	private Boolean presente = null;

	public Aluno(String nome, String senha, String genero, String turno, String curso) {
		super(nome, senha, turno, curso);
		this.registro_aluno = Util.generateUuidNumber(UUID.randomUUID().toString(), 11);
		this.genero = genero;
	}

	// Getters e Setters de Alunos
	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getUc() {
		return uc;
	}

	public void setUc(String uc) {
		this.uc = uc;
	}

	public String getSala() {
		return this.sala;
	}

	public void setSala(String sala) {
		this.presente = false;
		this.sala = sala;
	}

	public Boolean getPresente() {
		return this.presente;
	}

	public void setPresente(boolean presente) {
		this.presente = presente;
	}

	public String getRa() {
		return registro_aluno;
	}
}
