public class EntregaExpressa extends ServicoAdicional {
    public EntregaExpressa() {
        super("Entrega expressa");
    }

    public double calcularCusto(double valorVenda) {
        return 450.00;
    }
}
