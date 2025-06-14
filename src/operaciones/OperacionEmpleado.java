package operaciones;

import modelos.*;
import java.util.*;


public class OperacionEmpleado implements IOperacionEmpleado {
    private List<Empleado> empleados = new ArrayList<>();

    public void agregarEmpleado(Empleado empleado) { empleados.add(empleado); }

    public Empleado buscarEmpleadoPorDocumento(String documento) {
        return empleados.stream().filter(e -> e.getDocumento().equals(documento)).findFirst().orElse(null);
    }

    public List<Empleado> listarEmpleados() { return empleados; }

    public List<Empleado> listarEmpleadosPorEmpresa(String nit) {
        List<Empleado> lista = new ArrayList<>();
        for (Empleado e : empleados) {
            if (e.getEmpresa() != null && e.getEmpresa().getNit().equals(nit)) {
                lista.add(e);
            }
        }
        return lista;
    }

    public double calcularSueldoEmpleado(String documento, int horasTrabajadas) {
        Empleado emp = buscarEmpleadoPorDocumento(documento);
        return emp != null ? emp.getSueldoHora() * horasTrabajadas : 0;
    }

    public int contarEmpleadosPorEmpresa(String nit) {
        return (int) empleados.stream().filter(e -> e.getEmpresa() != null && e.getEmpresa().getNit().equals(nit)).count();
    }
}

