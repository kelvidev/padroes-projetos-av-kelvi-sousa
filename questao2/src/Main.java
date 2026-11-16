public class Main {
    public static void main(String[] args) {
        Lote quadro = new Lote("Quadro Abstrato", "Arte", 10000.00, 15000.00, new ComissaoArte());
        Lote fusca = new Lote("Fusca 1975", "Veículos", 30000.00, 60000.00, new ComissaoVeiculos());

        Participante ana = new Participante("Ana");
        Participante bruno = new Participante("Bruno");
        Participante carla = new Participante("Carla");
        PainelLeiloeiro painel = new PainelLeiloeiro();
        Auditor auditor = new Auditor();

        Interessado[] todos = { ana, bruno, carla, painel, auditor };
        for (Interessado interessado : todos) {
            quadro.adicionarInteressado(interessado);
            fusca.adicionarInteressado(interessado);
        }

        System.out.println("---------- Lances no Quadro Abstrato ----------");
        quadro.darLance(ana, 11000.00);
        quadro.darLance(bruno, 11200.00);
        quadro.darLance(bruno, 12000.00);
        quadro.removerInteressado(carla);
        quadro.darLance(ana, 13000.00);
        quadro.darLance(bruno, 16000.00);

        System.out.println("\n---------- Lances no Fusca 1975 ----------");
        fusca.darLance(carla, 32000.00);
        fusca.darLance(ana, 33000.00);
        fusca.darLance(ana, 34000.00);

        System.out.println("\n---------- Campanha ----------");
        quadro.trocarRegraComissao(new ComissaoEletronicos());

        System.out.println("\n---------- Encerramentos ----------");
        quadro.encerrar();
        fusca.encerrar();
        fusca.darLance(bruno, 40000.00);

        System.out.println();
        Fatura fatura = new Fatura(quadro);
        fatura.contratar(new SeguroTransporte());
        fatura.contratar(new EmbalagemEspecial());
        fatura.contratar(new EmbalagemEspecial());
        fatura.contratar(new CertificadoAutenticidade());
        fatura.contratar(new EntregaExpressa());
        fatura.imprimir();

        System.out.println();
        AcertoVendedor.imprimir(quadro);
        System.out.println();
        AcertoVendedor.imprimir(fusca);

        System.out.println();
        auditor.imprimirRegistros();
    }
}
