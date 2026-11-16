public class ComissaoVeiculos extends RegraComissao {
    public ComissaoVeiculos() {
        super("Veículos (8%, máx. R$ 5.000,00)");
    }

    public double calcular(double valorVenda) {
        return Math.min(valorVenda * 0.08, 5000.00);
    }
}
