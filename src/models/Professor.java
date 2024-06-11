package models;

import extras.Util;
import java.util.UUID;

public class Professor extends Pessoa {
	// atributos dos professores
	private final String registro_professor;
	private final String uc;
	private String sala;
	private String codigo_sala;
	private String graduacao;
	private String area;

	// construtor de Professor
	public Professor(String nome, String senha, String turno, String curso, String uc, String graduacao, String area) {
		super(nome, senha, turno, curso);
		this.uc = uc;
		this.graduacao = graduacao;
		this.area = area;
		this.registro_professor = Util.generateUuidNumber(UUID.randomUUID().toString(), 11);
	}

	// Getters e Setters de Professor
	public String getUc() {
		return uc;
	}

	public String getSala() {
		return this.sala;
	}

	public void setSala(String sala) {
		this.sala = sala;
	}

	public String getCodigoSala() {
		return this.codigo_sala;
	}

	public void setCodigo(String codigo_sala) {
		this.codigo_sala = codigo_sala;
	}

	public String getRp() {
		return registro_professor;
	}

	public String getGraduacao() {
		return graduacao;
	}

	public void setGraduacao(String graduacao) {
		this.graduacao = graduacao;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

}
