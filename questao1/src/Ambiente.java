import java.util.List;

public class Ambiente {
    public final String nome;
    public final String provedor;
    public final String regiao;
    public final List<MaquinaVirtual> maquinas;
    public final Armazenamento armazenamento;
    public final Fila fila;
    public final double custoMensal;

    public Ambiente(String nome, String provedor, String regiao, List<MaquinaVirtual> maquinas,
                    Armazenamento armazenamento, Fila fila, double custoMensal) {
        this.nome = nome;
        this.provedor = provedor;
        this.regiao = regiao;
        this.maquinas = maquinas;
        this.armazenamento = armazenamento;
        this.fila = fila;
        this.custoMensal = custoMensal;
    }

    public String gerarResumo() {
        StringBuilder sb = new StringBuilder();
        sb.append("=== Ambiente provisionado: ").append(nome).append(" ===\n");
        sb.append("Provedor: ").append(provedor).append("\n");
        sb.append("Região: ").append(regiao).append("\n");
        for (MaquinaVirtual maquina : maquinas) {
            sb.append("Máquina virtual: ").append(maquina.id).append("\n");
        }
        sb.append("Armazenamento: ").append(armazenamento.id).append("\n");
        sb.append("Fila: ").append(fila.id).append("\n");
        sb.append(String.format("Custo mensal estimado: R$ %.2f", custoMensal));
        return sb.toString();
    }
}
