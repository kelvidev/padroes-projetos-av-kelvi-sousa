import java.util.concurrent.atomic.AtomicInteger;

public class FabricaAws extends FabricaNuvem {
    private static final AtomicInteger contadorMaquinas = new AtomicInteger();
    private static final AtomicInteger contadorArmazenamentos = new AtomicInteger();
    private static final AtomicInteger contadorFilas = new AtomicInteger();

    public FabricaAws() {
        super("Aws", MaquinaVirtualAws.CUSTO_HORA, ArmazenamentoAws.CUSTO_POR_GB, FilaAws.CUSTO_MENSAL);
    }

    public MaquinaVirtual criarMaquinaVirtual() {
        return new MaquinaVirtualAws(contadorMaquinas.incrementAndGet());
    }

    public Armazenamento criarArmazenamento() {
        return new ArmazenamentoAws(contadorArmazenamentos.incrementAndGet());
    }

    public Fila criarFila() {
        return new FilaAws(contadorFilas.incrementAndGet());
    }
}
