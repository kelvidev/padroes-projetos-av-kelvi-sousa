public class FilaAws extends Fila {
    public static final double CUSTO_MENSAL = 0.40;

    public FilaAws(int numero) {
        super("sqs-" + numero, CUSTO_MENSAL);
    }
}
