public class AuditorConsola implements Observador {
    @Override
    public void actualizar(String tipoOperacion, String detalle) {
        System.out.println("[AUDITORIA CONSOLA] [" + tipoOperacion + "] " + detalle);
    }
}