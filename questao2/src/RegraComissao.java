public abstract class RegraComissao {
    public final String descricao;

    protected RegraComissao(String descricao) {
        this.descricao = descricao;
    }

    public abstract double calcular(double valorVenda);
}
