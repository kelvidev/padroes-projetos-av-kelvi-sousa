import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Solicitacao[] solicitacoes = {
            new Solicitacao("loja-virtual", "Aws", 2, 100),
            new Solicitacao("api-pagamentos", "Azure", 3, 200),
            new Solicitacao("relatorios", "Aws", 1, 500),
            new Solicitacao("cluster-ia", "Aws", 10, 1000)
        };

        List<Thread> threads = new ArrayList<>();
        for (Solicitacao solicitacao : solicitacoes) {
            Thread thread = new Thread(() -> provisionar(solicitacao));
            threads.add(thread);
            thread.start();
        }
        for (Thread thread : threads) {
            thread.join();
        }

        System.out.println();
        Auditoria.getInstancia().imprimirHistorico();
    }

    private static void provisionar(Solicitacao solicitacao) {
        FabricaNuvem fabrica = escolherFabrica(solicitacao.provedor);
        new Provisionador(fabrica).provisionar(solicitacao);
    }

    private static FabricaNuvem escolherFabrica(String provedor) {
        switch (provedor) {
            case "Aws":   return new FabricaAws();
            case "Azure": return new FabricaAzure();
            default: throw new IllegalArgumentException("Provedor desconhecido: " + provedor);
        }
    }
}
