public abstract class FabricaNuvem {
    public final String nomeProvedor;

    public final double custoHoraMaquina;
    public final double custoPorGb;
    public final double custoFila;

    protected FabricaNuvem(String nomeProvedor, double custoHoraMaquina, double custoPorGb, double custoFila) {
        this.nomeProvedor = nomeProvedor;
        this.custoHoraMaquina = custoHoraMaquina;
        this.custoPorGb = custoPorGb;
        this.custoFila = custoFila;
    }

    public abstract MaquinaVirtual criarMaquinaVirtual();
    public abstract Armazenamento criarArmazenamento();
    public abstract Fila criarFila();
}
