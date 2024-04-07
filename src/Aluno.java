public class Aluno implements Pessoa {
    private String nome;
    private String genero;
    private final String ra;
    private final String turno;
    private final String uc;

    public Aluno(String nome, String ra, String genero, String turno, String uc) {
        this.nome = nome;
        this.ra = ra;
        this.genero = genero;
        this.turno = turno;
        this.uc = uc;
    }

    public String getNome() {
        return nome;
    }

    public String getRa() {
        return ra;
    }

    public String getGenero() {
        return genero;
    }

    public String getTurno() {
        return turno;
    }

    public String getUc() {
        return uc;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    @Override
    public String getSenha() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getSenha'");
    }

    @Override
    public String getCurso() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getCurso'");
    }
}
