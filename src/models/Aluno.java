package models;

public class Aluno extends models.Pessoa {

    private String genero;
    private String uc;

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
}
