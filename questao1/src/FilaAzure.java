public class FilaAzure extends Fila {
    public static final double CUSTO_MENSAL = 0.50;

    public FilaAzure(int numero) {
        super("sb-" + numero, CUSTO_MENSAL);
    }
}
