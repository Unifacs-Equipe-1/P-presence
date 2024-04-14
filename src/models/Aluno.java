package models;

public class Aluno extends models.Pessoa {

    private String genero;
    private String uc;
    private int sala;
    private Boolean presente = null;

    public Aluno(String nome, String genero, String ra, String senha, String turno, String curso) {
        super(nome, ra, senha, turno, curso);
        this.genero = genero;
    }

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

    public int getSala() {
        return this.sala;
    }

    public void setSala(int sala) {
        this.presente = false;
        this.sala = sala;
    }

    public Boolean getPresente() {
        return this.presente;
    }

    public void setPresente(boolean presente) {
        this.presente = presente;
    }
}
