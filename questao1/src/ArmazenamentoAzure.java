public class ArmazenamentoAzure extends Armazenamento {
    public static final double CUSTO_POR_GB = 0.02;

    public ArmazenamentoAzure(int numero) {
        super("blob://" + numero, CUSTO_POR_GB);
    }
}
