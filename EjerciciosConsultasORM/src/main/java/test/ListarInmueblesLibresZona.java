package test;

import daoModel.InmuebleDAO;
import utilities.Utilities;
import java.util.Iterator;

public class ListarInmueblesLibresZona {
    public InmuebleDAO inmuebleDAO = new InmuebleDAO();
    public Utilities utilities = new Utilities();

    public void listContracts(){
        Iterator inmuebles = inmuebleDAO.listInmueblesZona( utilities.introduceData("zone name: ") );

        while (inmuebles.hasNext() ){
            Object[] row = (Object[]) inmuebles.next();
            System.out.println(row[0] + "\t" + row[1] );
        }
    }

    /*test 02*/
    public static void main(String[] args) {
        ListarInmueblesLibresZona listarInmuebles = new ListarInmueblesLibresZona();
        listarInmuebles.listContracts();
    }

}
