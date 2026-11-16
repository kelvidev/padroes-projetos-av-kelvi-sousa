import java.util.concurrent.atomic.AtomicInteger;

public class FabricaAzure extends FabricaNuvem {
    private static final AtomicInteger contadorMaquinas = new AtomicInteger();
    private static final AtomicInteger contadorArmazenamentos = new AtomicInteger();
    private static final AtomicInteger contadorFilas = new AtomicInteger();

    public FabricaAzure() {
        super("Azure", MaquinaVirtualAzure.CUSTO_HORA, ArmazenamentoAzure.CUSTO_POR_GB, FilaAzure.CUSTO_MENSAL);
    }

    public MaquinaVirtual criarMaquinaVirtual() {
        return new MaquinaVirtualAzure(contadorMaquinas.incrementAndGet());
    }

    public Armazenamento criarArmazenamento() {
        return new ArmazenamentoAzure(contadorArmazenamentos.incrementAndGet());
    }

    public Fila criarFila() {
        return new FilaAzure(contadorFilas.incrementAndGet());
    }
}
