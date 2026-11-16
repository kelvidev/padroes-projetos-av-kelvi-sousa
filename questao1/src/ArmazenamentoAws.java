public class ArmazenamentoAws extends Armazenamento {
    public static final double CUSTO_POR_GB = 0.023;

    public ArmazenamentoAws(int numero) {
        super("s3://" + numero, CUSTO_POR_GB);
    }
}
