import java.time.LocalDate;

public class BibliotecarioSupervisor extends Funcionario {

    public BibliotecarioSupervisor(String nome, String cargo) {
        super(nome, cargo);
    }

    public void autorizarRenovacaoEspecial(Emprestimo emprestimo, int diasAdicionais) {
        LocalDate novaData = emprestimo.getDataDevolucaoPrevista().plusDays(diasAdicionais);
        emprestimo.setDataDevolucaoPrevista(novaData);
        System.out.println("🔁 Renovação especial autorizada por " + getNome() +
                ". Novo prazo de devolução: " + novaData);
    }
}
