public class BitacoraArchivo implements Observador {
    private String nombreArchivo;

    public BitacoraArchivo(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }

    @Override
    public void actualizar(String tipoOperacion, String detalle) {
        // simulamos la escritura del evento en el archivo de bitacora
        System.out.println("[BITACORA ARCHIVO - " + nombreArchivo + "] Registro guardado -> [" + tipoOperacion + "] " + detalle);
    }
}
