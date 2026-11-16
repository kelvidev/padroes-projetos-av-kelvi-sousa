public class Configuracao {
    private static final Configuracao INSTANCIA = new Configuracao();

    public final String regiaoPadrao;
    public final double orcamentoMaximo;

    private Configuracao() {
        regiaoPadrao = "brasil-sul";
        orcamentoMaximo = 500.00;
        System.out.println("[Configuracao] configuração carregada (uma única vez).");
    }

    public static Configuracao getInstancia() {
        return INSTANCIA;
    }
}
