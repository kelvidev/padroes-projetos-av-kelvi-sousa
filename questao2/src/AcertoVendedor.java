public class AcertoVendedor {
    public static void imprimir(Lote lote) {
        System.out.println("=========== ACERTO DO VENDEDOR ===========");
        System.out.println("Lote: " + lote.nome);
        if (!lote.vendido) {
            System.out.println("Lote não vendido: nada a repassar.");
        } else {
            System.out.printf("Valor de venda: R$ %.2f%n", lote.valorVenda);
            System.out.printf("Comissão cobrada (%s): R$ %.2f%n", lote.regraComissao.descricao, lote.comissao);
            System.out.printf("Valor líquido ao vendedor: R$ %.2f%n", lote.valorVenda - lote.comissao);
        }
        System.out.println("==========================================");
    }
}
