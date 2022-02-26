package test;

import daoModel.EmpleadoDAO;
import voModel.Empleado;

import java.util.Iterator;

public class Query01 {

    EmpleadoDAO empleadoDAO = new EmpleadoDAO();


    public void query01(){
        Iterator iterator = empleadoDAO.listarEmpleadosDepartamentosOrdered();;
        while (iterator.hasNext()){
            Object[]row = (Object[]) iterator.next();
            System.out.println("codigo : " + row[0] + "\nnombre departamento : " + row[1] + "\nnombre empleado: " + row[2] +
                    "\n----------------------------------------------------------------");
        }
    }

    public static void main(String[] args) {
        Query01 query01 = new Query01();
        query01.query01();
    }
}
