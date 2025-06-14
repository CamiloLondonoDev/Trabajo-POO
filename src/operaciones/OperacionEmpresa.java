package operaciones;

import java.util.ArrayList;
import java.util.List;

import modelos.Empresa;

public class OperacionEmpresa implements IOperacionEmpresa {
    private List<Empresa> empresas = new ArrayList<>();

    public void agregarEmpresa(Empresa empresa) { empresas.add(empresa); }

    public Empresa buscarEmpresaPorNit(String nit) {
        return empresas.stream().filter(e -> e.getNit().equals(nit)).findFirst().orElse(null);
    }

    public List<Empresa> listarEmpresas() { return empresas; }
}
