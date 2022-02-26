package daoModel;

import connection.Connection;
import utilities.Utilities;
import voModel.Empleado;

import java.util.Iterator;
import java.util.List;

public class EmpleadoDAO {
    public Utilities utilities = new Utilities();
    public Empleado empleado;
    public Connection myConnection = new Connection();

    /*ejercicio 1*/
    public Iterator listarEmpleadosDepartamentosOrdered(){
        String hql = "SELECT em.departamento.nombre, em.nombre, em.salario " +
                "FROM Departamento em GROUP BY em.departamento.nombre";
        return utilities.stablishConnectionIterator(hql);
    }

    /*ejercicio 02*/
    public List<Empleado> listEmpleadosSueldoMayorSinComision(int salario){
        String hql = "FROM Empleado em WHERE em.salario > :salario AND em.comision=0";

        return utilities.stablishConnection(hql).setParameter("salario",salario).getResultList();
    }

    /*ejercicio 03*/
    public Iterator listarEdadYTiempoEmpleados(){
        String hql = "SELECT em.nombre, ( YEAR( CURDATE() ) - YEAR( em.fecIngreso ) ), ( YEAR( CURDATE() ) - YEAR( em.fecNacimiento ) ) " +
                "FROM Empleado em";
        return utilities.stablishConnectionIterator(hql);
    }

    /*ejercicio 07*/
    public Empleado findEmpleado(int idAlquiler){
        return myConnection.getConnection().find(Empleado.class,idAlquiler);
    }

    public void newEmpleado(Empleado empleado){
        utilities.connectionTransactions(empleado);

    }
}
