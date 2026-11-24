public class Main {
    public static void main(String[] args) {

        SistemaEmpleados sistema = new SistemaEmpleados();

        Observador auditorConsola = new AuditorConsola();
        Observador bitacoraArchivo = new BitacoraArchivo("auditoria_rrhh.log");

        // suscribimos ambos auditores al iniciar
        sistema.registrarObservador(auditorConsola);
        sistema.registrarObservador(bitacoraArchivo);

        System.out.println("--- 1. ALTA Y MODIFICACION CON AMBOS AUDITORES ACTIVOS ---");
        Empleado emp1 = new Empleado("EMP-101", "Laura Fernandez", "Analista QA", 950000);
        Empleado emp2 = new Empleado("EMP-102", "Martin Sosa", "Desarrollador Backend", 1200000);

        sistema.registrarAlta(emp1);
        sistema.registrarAlta(emp2);
        sistema.modificarDatosEmpleado("EMP-101", "Lider QA", 1350000);

        System.out.println("\n--- 2. DESUSCRIPCION DINAMICA DEL AUDITOR DE CONSOLA ---");
        sistema.eliminarObservador(auditorConsola);

        // esta operacion solo queda registrada en la bitacora de archivo
        sistema.modificarDatosEmpleado("EMP-102", "Arquitecto Java", 1800000);

        System.out.println("\n--- 3. RE-SUSCRIPCION DE CONSOLA Y BAJA DE EMPLEADO ---");
        sistema.registrarObservador(auditorConsola);
        sistema.darDeBaja("EMP-101");
    }
}
