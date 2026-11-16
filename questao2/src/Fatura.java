import java.util.ArrayList;
import java.util.List;

public class Fatura {
    public final Lote lote;
    public final List<ServicoAdicional> servicos = new ArrayList<>();

    public Fatura(Lote lote) {
        if (!lote.vendido) {
            throw new IllegalStateException("O lote '" + lote.nome + "' não foi vendido.");
        }
        this.lote = lote;
    }

    public void contratar(ServicoAdicional servico) {
        servicos.add(servico);
    }

    public double calcularTotal() {
        double total = lote.valorVenda;
        for (ServicoAdicional servico : servicos) {
            total += servico.calcularCusto(lote.valorVenda);
        }
        return total;
    }

    public void imprimir() {
        System.out.println("=========== FATURA DO COMPRADOR ===========");
        System.out.printf("Lote: %s (%s)%n", lote.nome, lote.categoria);
        System.out.println("Comprador: " + lote.comprador.nome);
        System.out.printf("Valor de venda: R$ %.2f%n", lote.valorVenda);
        for (ServicoAdicional servico : servicos) {
            System.out.printf("  + %s: R$ %.2f%n", servico.descricao, servico.calcularCusto(lote.valorVenda));
        }
        System.out.printf("TOTAL A PAGAR: R$ %.2f%n", calcularTotal());
        System.out.println("===========================================");
    }
}
