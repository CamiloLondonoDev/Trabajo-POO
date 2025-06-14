package main;

import modelos.*;
import operaciones.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        IOperacionEmpleado opEmpleado = new OperacionEmpleado();
        IOperacionEmpresa opEmpresa = new OperacionEmpresa();

        int opcion;
        do {
            System.out.println("\n1. Ingresar Empresa\n2. Ingresar Empleado\n3. Ver Empresas\n4. Ver Empleados\n5. Buscar Empleado\n6. Calcular Sueldo\n7. Contar Empleados por Empresa\n0. Salir");
            opcion = sc.nextInt(); sc.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("NIT: "); String nit = sc.nextLine();
                    System.out.print("Nombre: "); String nombre = sc.nextLine();
                    System.out.print("Dirección: "); String dir = sc.nextLine();
                    System.out.print("Ciudad: "); String ciudad = sc.nextLine();
                    Empresa emp = new EmpresaDesarrollo(nit, nombre, dir, ciudad);
                    opEmpresa.agregarEmpresa(emp);
                    break;
                case 2:
                    System.out.print("Documento: "); String doc = sc.nextLine();
                    System.out.print("Nombre: "); String nom = sc.nextLine();
                    System.out.print("Sueldo por Hora: "); double sueldo = sc.nextDouble(); sc.nextLine();
                    System.out.print("NIT Empresa: "); String nitEmp = sc.nextLine();
                    Empresa empresa = opEmpresa.buscarEmpresaPorNit(nitEmp);
                    Empleado nuevo = new Desarrollador(doc, nom, sueldo, empresa);
                    opEmpleado.agregarEmpleado(nuevo);
                    break;
                case 3:
                    for (Empresa e : opEmpresa.listarEmpresas()) {
                        System.out.println(e);
                    }
                    break;
                case 4:
                    for (Empleado e : opEmpleado.listarEmpleados()) {
                        System.out.println(e);
                    }
                    break;
                case 5:
                    System.out.print("Documento a buscar: ");
                    Empleado buscado = opEmpleado.buscarEmpleadoPorDocumento(sc.nextLine());
                    System.out.println(buscado != null ? buscado : "Empleado no encontrado");
                    break;
                case 6:
                    System.out.print("Documento: ");
                    String d = sc.nextLine();
                    System.out.print("Horas trabajadas: ");
                    int h = sc.nextInt(); sc.nextLine();
                    double sueldoTotal = opEmpleado.calcularSueldoEmpleado(d, h);
                    System.out.println("Sueldo total: " + sueldoTotal);
                    break;
                case 7:
                    System.out.print("NIT Empresa: ");
                    String nitContar = sc.nextLine();
                    int cantidad = opEmpleado.contarEmpleadosPorEmpresa(nitContar);
                    System.out.println("Total empleados: " + cantidad);
                    break;
            }
        } while (opcion != 0);
        sc.close();
    }
}