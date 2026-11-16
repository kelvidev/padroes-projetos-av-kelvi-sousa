public class SeguroTransporte extends ServicoAdicional {
    public SeguroTransporte() {
        super("Seguro de transporte (1,5%)");
    }

    public double calcularCusto(double valorVenda) {
        return valorVenda * 0.015;
    }
}
