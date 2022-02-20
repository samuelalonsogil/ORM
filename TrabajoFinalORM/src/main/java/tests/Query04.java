package tests;

import daoModel.VehiculoClienteDAO;
import utilities.Utilities;

import java.util.Iterator;

public class Query04 {
    public Utilities utilities = new Utilities();
    public VehiculoClienteDAO vehiculoClienteDAO = new VehiculoClienteDAO();

    public void listAlquileresPorMatricula(){
        Iterator iterator = vehiculoClienteDAO.generateListAlquileresPorMatricula(utilities.introduceData("Introduce la matricula: ") );

        while (iterator.hasNext() ){
            Object[] row = (Object[]) iterator.next();
            System.out.println("nombre: " + row[0] + "\nmatricula: " + row[1] + "\nmarca: " + row[2]
                    + "\ndias: " + row[3] + "\nseguro: " + row[4] + "\nprecio: " + row[5] );
        }
    }

    /*test 04*/
    public static void main(String[] args) {
        Query04 listar = new Query04();
        listar.listAlquileresPorMatricula();
    }
}
