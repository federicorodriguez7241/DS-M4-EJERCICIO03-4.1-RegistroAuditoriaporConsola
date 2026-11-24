import java.util.ArrayList;
import java.util.List;

public class SistemaEmpleados implements SujetoObservable {
    private final List<Observador> observadores;
    private final List<Empleado> empleados;
    private String ultimaOperacion;
    private String ultimoDetalle;

    public SistemaEmpleados() {
        this.observadores = new ArrayList<>();
        this.empleados = new ArrayList<>();
    }

    @Override
    public void registrarObservador(Observador observador) {
        if (observador != null && !observadores.contains(observador)) {
            observadores.add(observador);
        }
    }

    @Override
    public void eliminarObservador(Observador observador) {
        if (observador != null) {
            observadores.remove(observador);
        }
    }

    @Override
    public void notificarObservadores() {
        List<Observador> copiaSegura = new ArrayList<>(observadores);
        for (Observador auditor : copiaSegura) {
            auditor.actualizar(ultimaOperacion, ultimoDetalle);
        }
    }

    public void registrarAlta(Empleado nuevoEmpleado) {
        if (nuevoEmpleado == null) {
            return;
        }
        empleados.add(nuevoEmpleado);
        this.ultimaOperacion = "ALTA";
        this.ultimoDetalle = "Legajo: " + nuevoEmpleado.getLegajo()
                + " | Nombre: " + nuevoEmpleado.getNombre()
                + " | Puesto: " + nuevoEmpleado.getPuesto()
                + " | Salario: $" + nuevoEmpleado.getSalario();
        notificarObservadores();
    }

    public void modificarDatosEmpleado(String legajo, String nuevoPuesto, double nuevoSalario) {
        Empleado empleado = buscarPorLegajo(legajo);
        if (empleado == null) {
            return;
        }
        empleado.setPuesto(nuevoPuesto);
        empleado.setSalario(nuevoSalario);

        this.ultimaOperacion = "MODIFICACION";
        this.ultimoDetalle = "Legajo: " + empleado.getLegajo()
                + " (" + empleado.getNombre() + ") -> Nuevo puesto: " + nuevoPuesto
                + " | Nuevo salario: $" + nuevoSalario;
        notificarObservadores();
    }

    public void darDeBaja(String legajo) {
        Empleado empleado = buscarPorLegajo(legajo);
        if (empleado == null) {
            return;
        }
        empleados.remove(empleado);

        this.ultimaOperacion = "BAJA";
        this.ultimoDetalle = "Legajo: " + empleado.getLegajo()
                + " | Empleado eliminado: " + empleado.getNombre();
        notificarObservadores();
    }

    private Empleado buscarPorLegajo(String legajo) {
        for (Empleado emp : empleados) {
            if (emp.getLegajo().equalsIgnoreCase(legajo)) {
                return emp;
            }
        }
        return null;
    }
}