import java.util.ArrayList;
import java.util.List;

public class Lote {
    public final String nome;
    public final String categoria;
    public final double precoInicial;
    public final double precoReserva;

    public double lanceAtual;
    public int quantidadeLances = 0;
    public RegraComissao regraComissao;

    public boolean aberto = true;
    public boolean vendido = false;
    public double valorVenda;
    public double comissao;
    public Interessado comprador;

    private final List<Interessado> interessados = new ArrayList<>();
    private final List<Lance> lances = new ArrayList<>();

    public Lote(String nome, String categoria, double precoInicial, double precoReserva, RegraComissao regraComissao) {
        this.nome = nome;
        this.categoria = categoria;
        this.precoInicial = precoInicial;
        this.precoReserva = precoReserva;
        this.lanceAtual = precoInicial;
        this.regraComissao = regraComissao;
    }

    public void adicionarInteressado(Interessado interessado) {
        interessados.add(interessado);
    }

    public void removerInteressado(Interessado interessado) {
        interessados.remove(interessado);
        System.out.println("-- " + interessado.nome + " deixou de acompanhar o lote '" + nome + "'");
    }

    private void notificarInteressados(Lance lance) {
        for (Interessado interessado : interessados) {
            if (interessado != lance.participante) {
                interessado.atualizar(this, lance);
            }
        }
    }

    public boolean darLance(Interessado participante, double valor) {
        if (!aberto) {
            System.out.printf("XX Lance de %s (R$ %.2f) recusado: o lote '%s' está encerrado.%n",
                    participante.nome, valor, nome);
            return false;
        }
        double minimo = lanceAtual * 1.05;
        if (valor * 100 < lanceAtual * 105) {
            System.out.printf("XX Lance de %s (R$ %.2f) recusado no lote '%s': deve ser pelo menos 5%% maior que o lance atual de R$ %.2f (mínimo R$ %.2f).%n",
                    participante.nome, valor, nome, lanceAtual, minimo);
            return false;
        }
        Lance lance = new Lance(participante, valor);
        lances.add(lance);
        lanceAtual = valor;
        quantidadeLances++;
        System.out.printf(">> Lance aceito: %s ofereceu R$ %.2f no lote '%s'%n", participante.nome, valor, nome);
        notificarInteressados(lance);
        return true;
    }

    public void trocarRegraComissao(RegraComissao novaRegra) {
        if (!aberto) {
            System.out.println("XX Não é possível trocar a regra: o lote '" + nome + "' já foi encerrado.");
            return;
        }
        System.out.println("** Campanha: lote '" + nome + "' passa da regra " + regraComissao.descricao
                + " para " + novaRegra.descricao);
        regraComissao = novaRegra;
    }

    public void encerrar() {
        aberto = false;
        Lance maiorLance = lances.isEmpty() ? null : lances.get(lances.size() - 1);

        if (maiorLance != null && maiorLance.valor >= precoReserva) {
            vendido = true;
            valorVenda = maiorLance.valor;
            comprador = maiorLance.participante;
            comissao = regraComissao.calcular(valorVenda);
            System.out.printf("## Lote '%s' VENDIDO para %s por R$ %.2f%n", nome, comprador.nome, valorVenda);
        } else {
            System.out.printf("## Lote '%s' NÃO VENDIDO (maior lance R$ %.2f abaixo da reserva de R$ %.2f)%n", nome, lanceAtual, precoReserva);
        }
    }
}
