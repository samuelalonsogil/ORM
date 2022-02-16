package test;

import daoModel.InmuebleDAO;

import java.util.Iterator;

public class NumInmueblesOfEachInquilino {
    public InmuebleDAO inmuebleDAO = new InmuebleDAO();

    public void query11(){
        Iterator iterator = inmuebleDAO.listDifferentNumInmuebles();
        while (iterator.hasNext()){
            Object[]row = (Object[]) iterator.next();
            System.out.println("dni: " + row[0] + " inquilino: " + row[1] + " num contracts: " + row[2] );
        }
    }
}
