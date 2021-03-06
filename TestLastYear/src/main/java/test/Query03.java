package test;

import daoModels.ClienteDAO;
import utilities.TransformDates;
import utilities.Utilities;

import java.util.Iterator;

public class Query03 {
    public ClienteDAO clienteDAO = new ClienteDAO();
    public Utilities utilities = new Utilities();
    public TransformDates transformDates = new TransformDates();


    public void query03(){
        Iterator iterator = clienteDAO.listSalirAeropuerto(transformDates.StringToDate( utilities.introduceData("Introduce una fecha") )  );
        while (iterator.hasNext()){
            Object[]row = (Object[]) iterator.next();
            System.out.println("nombre: " + row[0] + "\napellidos: " + row[1] + "\nfecha salida:" + row[2] + "\ncodigo aeropuerto:" + row[3]+
                    "\n----------------------------------------------------------------");
        }
    }

    public static void main(String[] args) {
        Query03 query03 = new Query03();
        query03.query03();
    }
}
