public class ComissaoEletronicos extends RegraComissao {
    public ComissaoEletronicos() {
        super("Eletrônicos (12%, mín. R$ 50,00)");
    }

    public double calcular(double valorVenda) {
        return Math.max(valorVenda * 0.12, 50.00);
    }
}
