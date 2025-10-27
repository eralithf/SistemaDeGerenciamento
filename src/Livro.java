public class Livro {
    private String titulo;
    private String autor;
    private int ano;
    private String isbn;
    private String categoria;
    private int exemplaresDisponiveis;
    private Editora editora;

    public Livro(String titulo, String autor, int ano, String isbn, String categoria, int exemplaresDisponiveis, Editora editora) {
        this.titulo = titulo;
        this.autor = autor;
        this.ano = ano;
        this.isbn = isbn;
        this.categoria = categoria;
        this.exemplaresDisponiveis = exemplaresDisponiveis;
        this.editora = editora;
    }

    public String getTitulo() { return titulo; }
    public String getCategoria() { return categoria; }
    public int getExemplaresDisponiveis() { return exemplaresDisponiveis; }

    public void emprestar() { exemplaresDisponiveis--; }
    public void devolver() { exemplaresDisponiveis++; }

    @Override
    public String toString() {
        return titulo + " - " + autor + " (" + ano + ")";
    }
}
