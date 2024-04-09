package clientes;

public abstract class Pessoa {
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

    protected final String getNome() {
        return nome;
    }

    protected final String getRa() {
        return ra;
    }

    protected final String getSenha() {
        return senha;
    }

    protected final String getTurno() {
        return turno;
    }

    protected final String getCurso() {
        return curso;
    }

}