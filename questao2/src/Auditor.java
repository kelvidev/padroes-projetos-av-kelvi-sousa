import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Auditor extends Interessado {
    private static final DateTimeFormatter FORMATO = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
    public final List<String> registros = new ArrayList<>();

    public Auditor() {
        super("Auditor");
    }

    public void atualizar(Lote lote, Lance lance) {
        String registro = String.format("%s | lote '%s' | %s | R$ %.2f",
                LocalDateTime.now().format(FORMATO), lote.nome, lance.participante.nome, lance.valor);
        registros.add(registro);
        System.out.println("   [Auditor] Lance registrado");
    }

    public void imprimirRegistros() {
        System.out.println("=== Registros do auditor (" + registros.size() + " lances aceitos) ===");
        for (String registro : registros) {
            System.out.println(registro);
        }
    }
}
