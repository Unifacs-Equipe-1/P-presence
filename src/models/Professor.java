package models;

import extras.Util;
import java.util.UUID;

public class Professor extends Pessoa {

	private final String registro_professor;
	private final String uc;
	private String sala;
	private String codigo_sala;

	public Professor(String nome, String senha, String turno, String curso, String uc) {
		super(nome, senha, turno, curso);
		this.uc = uc;
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
}
