package tests;

import daoModel.VehiculoClienteDAO;
import utilities.Utilities;

import java.util.Iterator;

public class Query06 {

    public Utilities utilities = new Utilities();
    public VehiculoClienteDAO vehiculoClienteDAO = new VehiculoClienteDAO();

    public void listAlquileresOrderedBy(){
        Iterator iterator = vehiculoClienteDAO.generateListAlquileresOrdenada();

        while (iterator.hasNext() ){
            Object[] row = (Object[]) iterator.next();
            System.out.println("matricula: " + row[0] + "\ndni: " + row[1] + "\nnombre: " + row[2]
                    + "\ntlf: " + row[3] + "\ndias: " + row[4] + "\nprecio: " + row[5]
                    + "\n-----------------------------------------------------------" );
        }
    }

    /*test 06*/
    public static void main(String[] args) {
        Query06 listAlquileresOrderedBy = new Query06();
        listAlquileresOrderedBy.listAlquileresOrderedBy();
    }
}
