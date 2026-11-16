public class Participante extends Interessado {

    public Participante(String nome) {
        super(nome);
    }

    public void atualizar(Lote lote, Lance lance) {
        System.out.printf("   [%s] Novo lance no lote '%s': R$ %.2f%n", nome, lote.nome, lance.valor);
    }
}
