import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Auditoria {
    private static final Auditoria INSTANCIA = new Auditoria();
    private static final DateTimeFormatter FORMATO = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss.SSS");

    private final List<String> registros = new ArrayList<>();

    private Auditoria() { }

    public static Auditoria getInstancia() {
        return INSTANCIA;
    }

    public synchronized void registrar(String nomeAmbiente, String provedor, String resultado) {
        String dataHora = LocalDateTime.now().format(FORMATO);
        registros.add(dataHora + " | " + nomeAmbiente + " | " + provedor + " | " + resultado);
    }

    public synchronized void imprimirHistorico() {
        System.out.println("=== Histórico de auditoria (" + registros.size() + " registros) ===");
        for (String registro : registros) {
            System.out.println(registro);
        }
    }
}
