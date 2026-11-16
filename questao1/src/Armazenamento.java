public abstract class Armazenamento {
    public final String id;
    public final double custoPorGb;

    protected Armazenamento(String id, double custoPorGb) {
        this.id = id;
        this.custoPorGb = custoPorGb;
    }
}
