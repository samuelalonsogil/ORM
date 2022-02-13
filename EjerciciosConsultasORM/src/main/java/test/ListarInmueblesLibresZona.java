package test;

import daoModel.InmuebleDAO;
import utilities.Utilities;
import voModel.Inmueble;

import java.util.Iterator;
import java.util.List;

public class ListarInmueblesLibresZona {

    public InmuebleDAO inmuebleDAO;
    public Utilities utilities;

    /*versión devolviendo Query*/
    public void listContracts(){
        List<Inmueble> inmuebles = inmuebleDAO.listInmueblesZona( utilities.introduceData() );

        for (Inmueble inmueble : inmuebles){
            System.out.println(inmueble);
        }
    }

    /*versión devolviendo Iterator*/
    public void listContractsIterator(){
        Iterator iterator = inmuebleDAO.listInmueblesZonaIterator( utilities.introduceData() );

        while (iterator.hasNext()) {
            Object[] fila = (Object[]) iterator.next();
            System.out.println(fila[0] + "\t" + fila[1] + "\t" + fila[2] + "\t" + fila[3]);
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
        //listarInmuebles.listContractsIterator();
    }

}
