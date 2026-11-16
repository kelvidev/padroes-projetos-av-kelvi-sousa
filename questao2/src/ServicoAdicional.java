public abstract class ServicoAdicional {
    public final String descricao;

    protected ServicoAdicional(String descricao) {
        this.descricao = descricao;
    }

    public abstract double calcularCusto(double valorVenda);
}
