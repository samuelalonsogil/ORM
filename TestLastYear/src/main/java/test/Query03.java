package test;

import daoModels.ClienteDAO;
import utilities.Utilities;

import java.util.Iterator;

public class Query03 {
    public ClienteDAO clienteDAO = new ClienteDAO();
    public Utilities utilities = new Utilities();

    public void query03(){
        Iterator iterator = clienteDAO.listSalirAeropuerto(utilities.introduceData("Introduce una fecha")  );
        while (iterator.hasNext()){
            Object[]row = (Object[]) iterator.next();
            System.out.println("nombre: " + row[0] + "\napellidos: " + row[1] + "\nnumero_de_tarjetas:" + row[2] +
                    "\n----------------------------------------------------------------");
        }
    }

    public static void main(String[] args) {
        Query03 query03 = new Query03();
        query03.query03();
    }
}
