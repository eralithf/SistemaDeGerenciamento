import java.time.LocalDate;
import java.util.List;

public class Emprestimo {
    private Aluno aluno;
    private List<Livro> livros;
    private LocalDate dataEmprestimo;
    private LocalDate dataDevolucaoPrevista;
    private Funcionario funcionario;
    private boolean ativo;

    public Emprestimo(Aluno aluno, List<Livro> livros, Funcionario funcionario) {
        this.aluno = aluno;
        this.livros = livros;
        this.funcionario = funcionario;
        this.dataEmprestimo = LocalDate.now();
        this.dataDevolucaoPrevista = dataEmprestimo.plusDays(7);
        this.ativo = true;
    }

    public LocalDate getDataDevolucaoPrevista() { return dataDevolucaoPrevista; }
    public void setDataDevolucaoPrevista(LocalDate novaData) { this.dataDevolucaoPrevista = novaData; }
    public List<Livro> getLivros() { return livros; }

    public void encerrarEmprestimo() {
        this.ativo = false;
    }

    public String getDescricao() {
        return "Empréstimo de " + livros.size() + " livro(s) para " + aluno.getNome() +
                " - Data: " + dataEmprestimo +
                " / Devolução prevista: " + dataDevolucaoPrevista +
                (ativo ? " (Ativo)" : " (Encerrado)");
    }
}
