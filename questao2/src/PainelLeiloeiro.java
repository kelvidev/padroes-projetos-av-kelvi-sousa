public class PainelLeiloeiro extends Interessado {

    public PainelLeiloeiro() {
        super("Painel do Leiloeiro");
    }

    public void atualizar(Lote lote, Lance lance) {
        System.out.printf("   [Painel] Lote '%s' | maior lance: R$ %.2f | total de lances: %d%n",
                lote.nome, lote.lanceAtual, lote.quantidadeLances);
    }
}
