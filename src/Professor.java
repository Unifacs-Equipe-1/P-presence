
public class Professor implements Pessoa {
    private String nome;
    private final String ra;
    private final String turno;
    private String curso;
    private final String uc;

    public Professor(String nome, String ra, String turno, String curso, String uc) {
        this.nome = nome;
        this.ra = ra;
        this.turno = ra;
        this.curso = curso;
        this.uc = uc;
    }

    public String getNome() {
        return nome;
    }

    public String getRa() {
        return ra;
    }

    public String getTurno() {
        return turno;
    }

    public String getCurso() {
        return curso;
    }

    public String getUc() {
        return uc;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    @Override
    public String getSenha() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getSenha'");
    }
}
