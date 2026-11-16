import java.util.ArrayList;
import java.util.List;

public class Provisionador {
    private static final int HORAS_POR_MES = 730;
    private final FabricaNuvem fabrica;

    public Provisionador(FabricaNuvem fabrica) {
        this.fabrica = fabrica;
    }

    public Ambiente provisionar(Solicitacao solicitacao) {
        Configuracao configuracao = Configuracao.getInstancia();
        Auditoria auditoria = Auditoria.getInstancia();
        String provedor = fabrica.nomeProvedor;

        double custo = solicitacao.quantidadeMaquinas * fabrica.custoHoraMaquina * HORAS_POR_MES
                + solicitacao.gbArmazenamento * fabrica.custoPorGb
                + fabrica.custoFila;

        if (custo > configuracao.orcamentoMaximo) {
            String motivo = String.format("custo estimado R$ %.2f ultrapassa o orçamento de R$ %.2f",
                    custo, configuracao.orcamentoMaximo);
            auditoria.registrar(solicitacao.nomeAmbiente, provedor, "RECUSADO (" + motivo + ")");
            System.out.println("=== Provisionamento recusado: " + solicitacao.nomeAmbiente + " - " + motivo + " ===");
            return null;
        }

        List<MaquinaVirtual> maquinas = new ArrayList<>();
        for (int i = 0; i < solicitacao.quantidadeMaquinas; i++) {
            maquinas.add(fabrica.criarMaquinaVirtual());
        }
        Armazenamento armazenamento = fabrica.criarArmazenamento();
        Fila fila = fabrica.criarFila();

        Ambiente ambiente = new Ambiente(solicitacao.nomeAmbiente, provedor,
                configuracao.regiaoPadrao, maquinas, armazenamento, fila, custo);

        auditoria.registrar(solicitacao.nomeAmbiente, provedor, "ACEITO");
        System.out.println(ambiente.gerarResumo());
        return ambiente;
    }
}
