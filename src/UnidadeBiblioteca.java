public class UnidadeBiblioteca {
    private String cnpj;
    private String nome;
    private String endereco;
    private String responsavel;

    public UnidadeBiblioteca(String cnpj, String nome, String endereco, String responsavel) {
        this.cnpj = cnpj;
        this.nome = nome;
        this.endereco = endereco;
        this.responsavel = responsavel;
    }

    public String getNome() { return nome; }

    @Override
    public String toString() {
        return nome + " - " + endereco;
    }
}
