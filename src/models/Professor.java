package models;

import extras.Util;
import java.util.UUID;

public class Professor extends Pessoa {
	private final String registroProfessor;
	private final String uc;
	private int sala;
	private String codigoSala;

	public Professor(String nome, String senha, String turno, String curso, String uc) {
		super(nome, senha, turno, curso);
		this.uc = uc;
		this.registroProfessor = Util.generateUuidNumber(UUID.randomUUID().toString(), 11);
	}

	public String getUc() {
		return uc;
	}

	public int getSala() {
		return this.sala;
	}

	public void setSala(int sala) {
		this.sala = sala;
	}

	public String getCodigoSala() {
		return this.codigoSala;
	}

	public void setCodigo(String codigoSala) {
		this.codigoSala = codigoSala;
	}

	public String getRp() {
		return registroProfessor;
	}
}
