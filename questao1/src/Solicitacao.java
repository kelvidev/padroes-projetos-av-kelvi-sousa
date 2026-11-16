public class Solicitacao {
    public final String nomeAmbiente;
    public final String provedor;
    public final int quantidadeMaquinas;
    public final int gbArmazenamento;

    public Solicitacao(String nomeAmbiente, String provedor, int quantidadeMaquinas, int gbArmazenamento) {
        this.nomeAmbiente = nomeAmbiente;
        this.provedor = provedor;
        this.quantidadeMaquinas = quantidadeMaquinas;
        this.gbArmazenamento = gbArmazenamento;
    }
}
