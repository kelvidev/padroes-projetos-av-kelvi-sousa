public class CertificadoAutenticidade extends ServicoAdicional {
    public CertificadoAutenticidade() {
        super("Certificado de autenticidade");
    }

    public double calcularCusto(double valorVenda) {
        return 300.00;
    }
}
