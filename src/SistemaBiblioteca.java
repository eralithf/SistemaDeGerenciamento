import java.util.*;

public class SistemaBiblioteca {

    private List<Aluno> alunos = new ArrayList<>();
    private List<Livro> livros = new ArrayList<>();
    private List<Editora> editoras = new ArrayList<>();
    private List<UnidadeBiblioteca> unidades = new ArrayList<>();
    private Map<String, List<Emprestimo>> emprestimosAtivos = new HashMap<>();
    private Stack<Livro> livrosDevolvidos = new Stack<>();
    private Queue<Aluno> filaAtendimento = new LinkedList<>();
    private Set<String> categorias = new HashSet<>();

    public void cadastrarAluno(Aluno aluno) {
        alunos.add(aluno);
        System.out.println("Aluno cadastrado: " + aluno.getNome());
    }

    public void cadastrarLivro(Livro livro) {
        livros.add(livro);
        categorias.add(livro.getCategoria());
        System.out.println("Livro cadastrado: " + livro.getTitulo());
    }

    public void cadastrarEditora(Editora editora) {
        editoras.add(editora);
        System.out.println("Editora cadastrada: " + editora.getNome());
    }

    public void cadastrarUnidade(UnidadeBiblioteca unidade) {
        unidades.add(unidade);
        System.out.println("Unidade cadastrada: " + unidade.getNome());
    }

    public Aluno buscarAluno(String ra) {
        return alunos.stream()
                .filter(a -> a.getRa().equalsIgnoreCase(ra))
                .findFirst()
                .orElse(null);
    }

    public Livro buscarLivroPorTitulo(String titulo) {
        return livros.stream()
                .filter(l -> l.getTitulo().equalsIgnoreCase(titulo))
                .findFirst()
                .orElse(null);
    }

    public void registrarEmprestimo(String ra, List<Livro> livrosEmprestados, Funcionario funcionario) {
        Aluno aluno = buscarAluno(ra);
        if (aluno == null) {
            System.out.println("❌ Aluno não encontrado!");
            return;
        }

        for (Livro l : livrosEmprestados) {
            if (l.getExemplaresDisponiveis() <= 0) {
                System.out.println("❌ Livro indisponível: " + l.getTitulo());
                return;
            }
        }

        for (Livro l : livrosEmprestados) l.emprestar();

        Emprestimo emprestimo = new Emprestimo(aluno, livrosEmprestados, funcionario);
        emprestimosAtivos.computeIfAbsent(ra, k -> new ArrayList<>()).add(emprestimo);

        System.out.println("✅ Empréstimo registrado para " + aluno.getNome());
    }

    public void registrarDevolucao(Emprestimo emprestimo) {
        emprestimo.encerrarEmprestimo();
        for (Livro l : emprestimo.getLivros()) {
            livrosDevolvidos.push(l);
        }
        System.out.println("📚 Devolução registrada. Livros aguardando conferência.");
    }

    public void conferirLivrosDevolvidos() {
        System.out.println("\n🔍 Iniciando conferência de livros...");
        while (!livrosDevolvidos.isEmpty()) {
            Livro l = livrosDevolvidos.pop();
            l.devolver();
            System.out.println("✔ Livro conferido e retornado ao acervo: " + l.getTitulo());
        }
        System.out.println("✅ Todos os livros foram conferidos.");
    }

    public void listarEmprestimosAtivos() {
        System.out.println("\n--- Empréstimos Ativos ---");
        emprestimosAtivos.forEach((ra, lista) -> {
            System.out.println("RA: " + ra);
            lista.forEach(e -> System.out.println("   • " + e.getDescricao()));
        });
    }

    public Map<String, List<Emprestimo>> getEmprestimosAtivos() {
        return emprestimosAtivos;
    }
}
