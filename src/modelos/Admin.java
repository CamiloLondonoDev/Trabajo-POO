package modelos;

class Admin extends Empleado {
    public Admin() {}
    public Admin(String documento, String nombre, double sueldoHora, Empresa empresa) {
        super(documento, nombre, sueldoHora, empresa);
    }
}
