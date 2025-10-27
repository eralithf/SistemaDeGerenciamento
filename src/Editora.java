public class Editora {
    private String nome;
    private String cnpj;

    public Editora(String nome, String cnpj) {
        this.nome = nome;
        this.cnpj = cnpj;
    }

    public String getNome() { return nome; }

    @Override
    public String toString() {
        return nome + " (CNPJ: " + cnpj + ")";
    }
}
