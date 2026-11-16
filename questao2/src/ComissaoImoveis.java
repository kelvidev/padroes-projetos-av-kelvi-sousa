public class ComissaoImoveis extends RegraComissao {
    public ComissaoImoveis() {
        super("Imóveis (3% + R$ 1.500,00)");
    }

    public double calcular(double valorVenda) {
        return valorVenda * 0.03 + 1500.00;
    }
}
