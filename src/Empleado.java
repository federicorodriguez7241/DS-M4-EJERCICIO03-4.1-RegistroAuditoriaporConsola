public class Empleado {
    private String legajo;
    private String nombre;
    private String puesto;
    private double salario;

    public Empleado(String legajo, String nombre, String puesto, double salario) {
        this.legajo = legajo;
        this.nombre = nombre;
        this.puesto = puesto;
        this.salario = salario;
    }

    public String getLegajo() { return legajo; }
    public String getNombre() { return nombre; }
    public String getPuesto() { return puesto; }
    public double getSalario() { return salario; }

    public void setPuesto(String puesto) { this.puesto = puesto; }
    public void setSalario(double salario) { this.salario = salario; }
}