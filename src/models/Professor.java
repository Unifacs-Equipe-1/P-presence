package models;

public class Professor extends Pessoa {

    private final String uc;

    public Professor(String nome, String ra, String turno, String curso, String uc) {
        super(nome, ra, uc, turno, curso);
        this.uc = uc;
    }

    public String getUc() {
        return uc;
    }
}
