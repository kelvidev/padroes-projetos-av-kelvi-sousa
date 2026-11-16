public class MaquinaVirtualAzure extends MaquinaVirtual {
    public static final double CUSTO_HORA = 0.12;

    public MaquinaVirtualAzure(int numero) {
        super("vm-" + numero, CUSTO_HORA);
    }
}
