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
        Iterator<Inmueble> inmuebles = inmuebleDAO.listInmueblesZona( utilities.introduceData() );

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
