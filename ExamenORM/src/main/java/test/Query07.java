package test;

import daoModel.DepartamentoDAO;
import daoModel.EmpleadoDAO;
import utilities.TransformDates;
import utilities.Utilities;
import voModel.Departamento;
import voModel.Empleado;

public class Query07 {
    public Utilities utilities = new Utilities();
    public Departamento departamento;
    public DepartamentoDAO departamentoDAO = new DepartamentoDAO();
    public Empleado empleado;
    public EmpleadoDAO empleadoDAO = new EmpleadoDAO();
    public TransformDates transformDates = new TransformDates();

    public void newEmpleado(){
        System.out.println("Introduce los datos del empleado nuevo: ");

        empleado = new Empleado();
        int codDepartamento = utilities.introduceDataInt("Introduce el codigo del departamento: ");

        if (departamentoDAO.findDepartamento(codDepartamento) == null) departamento = newDepartamento(codDepartamento);
        else departamento = departamentoDAO.findDepartamento(codDepartamento);

        empleado.setDepartamento(departamento);

        System.out.println("Introduce los dats del empleado: ");
        empleado.setNombre(utilities.introduceData("Nombre:"));
        empleado.setSalario(utilities.introduceDataInt("Salario: "));
        empleado.setComision(utilities.introduceDataInt("Comision: "));
        empleado.setFecNacimiento(transformDates.StringToDate(utilities.introduceData("Fecha nacimiento: ")) );
        empleado.setFecIngreso(transformDates.StringToDate(utilities.introduceData("Fecha ingreso: ")) );

        int codEmpleado = (utilities.introduceDataInt("Codigo empleado: "));

        if (empleadoDAO.findEmpleado(codEmpleado) == null) {
            empleado.setCodigo(codEmpleado);
            empleadoDAO.newEmpleado(empleado);
        }else{
            System.out.println("empleado existente");
        }
    }

    private Departamento newDepartamento(int codDepartamento) {
        departamento = new Departamento();
        departamento.setCodigo(codDepartamento);

        System.out.println("Introduce el nuevo departamento: ");
        departamento.setNombre(utilities.introduceData("Introduce el nombre: "));
        departamento.setPresupuesto(utilities.introduceDataInt("Introduce el presupuesto: "));
        departamento.setTipoDirector(utilities.introduceData("Tipo deirector: "));
        departamentoDAO.newDepartamento(departamento);
        return departamento;
    }

    public static void main(String[] args) {
        Query07 query07 = new Query07();
        query07.newEmpleado();
    }
}
