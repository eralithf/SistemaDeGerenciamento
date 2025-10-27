public class Aluno {
    private String ra;
    private String nome;
    private String curso;
    private String telefone;
    private String email;

    public Aluno(String ra, String nome, String curso, String telefone, String email) {
        this.ra = ra;
        this.nome = nome;
        this.curso = curso;
        this.telefone = telefone;
        this.email = email;
    }

    public String getRa() { return ra; }
    public String getNome() { return nome; }

    @Override
    public String toString() {
        return nome + " (" + ra + ")";
    }
}
