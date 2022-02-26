package test;

import daoModel.EmpleadoDAO;
import utilities.Utilities;
import voModel.Empleado;

import java.util.List;

public class Query02 {

    public EmpleadoDAO empleadoDAO = new EmpleadoDAO();
    public Utilities utilities = new Utilities();

    public void query02(){
        List<Empleado> empleados = empleadoDAO.listEmpleadosSueldoMayorSinComision(utilities.introduceDataInt("Introduce el salario: "));
        for(Empleado empleado:empleados){
            System.out.println("nombre: " + empleado.getNombre() );
        }
    }

    /*test 02*/
    public static void main(String[] args) {
        Query02 query02 = new Query02();
        query02.query02();
    }
}
