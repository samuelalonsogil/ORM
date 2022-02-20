package tests;

import daoModel.VehiculoDAO;
import java.util.Iterator;

public class Query09 {
    public VehiculoDAO vehiculoDAO = new VehiculoDAO();

    public void listCocheMasCaro(){
        Iterator iterator = vehiculoDAO.listCocheMasCaro();

        while (iterator.hasNext() ){
            Object[] row = (Object[]) iterator.next();
            System.out.println("matricula: " + row[0] + "\nmarca: " + row[1] + "\nprecio: " + row[2]
                    + "\n-----------------------------------------------------------" );
        }
    }

    public static void main(String[] args) {
        Query09 query09 = new Query09();
        query09.listCocheMasCaro();
    }
}
