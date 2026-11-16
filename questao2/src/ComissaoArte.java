public class ComissaoArte extends RegraComissao {
    public ComissaoArte() {
        super("Arte (20%)");
    }

    public double calcular(double valorVenda) {
        return valorVenda * 0.20;
    }
}
