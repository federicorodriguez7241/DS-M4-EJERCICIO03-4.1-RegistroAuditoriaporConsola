public interface SujetoObservable {
    void registrarObservador(Observador observador);
    void eliminarObservador(Observador observador);
    void notificarObservadores();
}