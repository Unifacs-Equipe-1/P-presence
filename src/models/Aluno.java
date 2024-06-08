package models;

import extras.Util;
import java.util.UUID;

public class Aluno extends models.Pessoa {
	// atributos dos alunos
	private final String registro_aluno;
	private String genero;
	private String uc;
	private String sala;
	private String semestre;
	private Boolean presente = null;

	public Aluno(String nome, String senha, String genero, String turno, String curso, String semestre) {
		super(nome, senha, turno, curso);
		this.registro_aluno = Util.generateUuidNumber(UUID.randomUUID().toString(), 11);
		this.genero = genero;
		this.semestre = semestre;
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

	public String getRegistro_aluno() {
		return registro_aluno;
	}

	public String getSemestre() {
		return semestre;
	}

	public void setSemestre(String semestre) {
		this.semestre = semestre;
	}

	public void setPresente(Boolean presente) {
		this.presente = presente;
	}
}
