import java.util.*;

public class Main {
    public static void main(String[] args) {
        SistemaBiblioteca sistema = new SistemaBiblioteca();


        Editora editora = new Editora("Editora Campus", "12345678000100");
        sistema.cadastrarEditora(editora);

        UnidadeBiblioteca unidade = new UnidadeBiblioteca("12345678000199", "Biblioteca Central",
                "Av. Principal, 1000 - Centro", "Maria Oliveira");
        sistema.cadastrarUnidade(unidade);

        Livro l1 = new Livro("Java para Iniciantes", "Herbert Schildt", 2019, "9788576089722", "Programação", 3, editora);
        Livro l2 = new Livro("Estruturas de Dados", "Mark Allen Weiss", 2018, "9788576055635", "Computação", 2, editora);
        sistema.cadastrarLivro(l1);
        sistema.cadastrarLivro(l2);

        Aluno a1 = new Aluno("2023001", "João Silva", "Engenharia de Software", "(11) 99999-1111", "joao.silva@universidade.edu");
        sistema.cadastrarAluno(a1);

        Funcionario f1 = new Funcionario("Carlos Souza", "Atendente");
        BibliotecarioSupervisor supervisor = new BibliotecarioSupervisor("Ana Paula", "Supervisora");


        List<Livro> livrosParaEmprestimo = Arrays.asList(l1, l2);
        sistema.registrarEmprestimo("2023001", livrosParaEmprestimo, f1);


        sistema.listarEmprestimosAtivos();


        Emprestimo emprestimo = sistema.getEmprestimosAtivos().get("2023001").get(0);
        sistema.registrarDevolucao(emprestimo);


        sistema.conferirLivrosDevolvidos();


        supervisor.autorizarRenovacaoEspecial(emprestimo, 5);
    }
}
