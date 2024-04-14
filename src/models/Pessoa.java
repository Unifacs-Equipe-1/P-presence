package models;

import java.io.Serializable;

public abstract class Pessoa implements Serializable {
    private String nome = "";
    private String ra = "";
    private String senha = "";
    private String turno = "";
    private String curso = "";

    protected Pessoa(String nome, String ra, String senha, String turno, String curso) {
        this.nome = nome;
        this.ra = ra;
        this.senha = senha;
        this.turno = turno;
        this.curso = curso;
    }

    public final String getNome() {
        return nome;
    }

    public final void setNome(String nome) {
        this.nome = nome;
    }

    protected final String getRa() {
        return ra;
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
