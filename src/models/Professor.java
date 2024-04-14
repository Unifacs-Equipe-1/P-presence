package models;

public class Professor extends Pessoa {
    private final String uc;
    private int sala;
    private String codigoSala;

    public Professor(String nome, String ra, String senha, String turno, String curso, String uc) {
        super(nome, ra, senha, turno, curso);
        this.uc = uc;
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
}
