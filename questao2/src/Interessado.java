public abstract class Interessado {
    public final String nome;

    protected Interessado(String nome) {
        this.nome = nome;
    }

    public abstract void atualizar(Lote lote, Lance lance);
}
