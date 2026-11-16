public abstract class MaquinaVirtual {
    public final String id;
    public final double custoHora;

    protected MaquinaVirtual(String id, double custoHora) {
        this.id = id;
        this.custoHora = custoHora;
    }
}
