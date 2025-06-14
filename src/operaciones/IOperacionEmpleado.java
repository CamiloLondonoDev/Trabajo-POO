package operaciones;

import java.util.List;

import modelos.Empleado;

public interface IOperacionEmpleado {
    void agregarEmpleado(Empleado empleado);
    Empleado buscarEmpleadoPorDocumento(String documento);
    List<Empleado> listarEmpleados();
    List<Empleado> listarEmpleadosPorEmpresa(String nit);
    double calcularSueldoEmpleado(String documento, int horasTrabajadas);
    int contarEmpleadosPorEmpresa(String nit);
}
