package test;

import daoModel.InmuebleDAO;
import utilities.Utilities;
import java.util.Iterator;


public class ListarInmueblesLibresZona {
    public InmuebleDAO inmuebleDAO;
    public Utilities utilities;

    /*versión devolviendo Query*/
    public void listContracts(){
        Iterator inmuebles = inmuebleDAO.listInmueblesZona( utilities.introduceData() );

        while (inmuebles.hasNext() ){
            Object[] row = (Object[]) inmuebles.next();
            System.out.println(row[0] + " " + row[1] + " " + row[2] + " " + row[3]);
        }

    }

    public void initVariables(){
        inmuebleDAO = new InmuebleDAO();
        utilities = new Utilities();
    }

    /*test 02*/
    public static void main(String[] args) {
        ListarInmueblesLibresZona listarInmuebles = new ListarInmueblesLibresZona();
        listarInmuebles.initVariables();
        listarInmuebles.listContracts();
    }

}
