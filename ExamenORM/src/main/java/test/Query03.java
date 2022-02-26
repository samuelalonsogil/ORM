package test;

import daoModel.EmpleadoDAO;

import java.util.Iterator;

public class Query03 {
    public EmpleadoDAO empleadoDAO = new EmpleadoDAO();

    public void query03(){
        Iterator iterator = empleadoDAO.listarEdadYTiempoEmpleados();;
        while (iterator.hasNext()){
            Object[]row = (Object[]) iterator.next();
            System.out.println("nombre : " + row[0] + "\ntiempo_trabajado : " + row[1] + "\nedad: " + row[2] +
                    "\n----------------------------------------------------------------");
        }
    }

    public static void main(String[] args) {
        Query03 query03 = new Query03();
        query03.query03();
    }
}
