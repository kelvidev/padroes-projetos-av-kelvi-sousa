public class MaquinaVirtualAws extends MaquinaVirtual {
    public static final double CUSTO_HORA = 0.10;

    public MaquinaVirtualAws(int numero) {
        super("i-" + numero, CUSTO_HORA);
    }
}
