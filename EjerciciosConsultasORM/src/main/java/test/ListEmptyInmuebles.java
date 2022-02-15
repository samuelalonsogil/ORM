package test;

import daoModel.InmuebleDAO;

import java.util.Iterator;

public class ListEmptyInmuebles {

    InmuebleDAO inmuebleDAO = new InmuebleDAO();

    public void listEmptyInmueblesOrAlmostEmpty(){
        Iterator iterator =  inmuebleDAO.listContratosVencimientoMesActual();

        while (iterator.hasNext() ){
            Object[] row = (Object[]) iterator.next();
            System.out.println(
                    "code: " + row[0] + "\t" +
                    " direction: " + row[1] + "\t" +
                    " expiration date: " + row[2] + "\t" +
                    " name: " + row[3] + "\t" +
                    "tlf: " + row[4] );
        }
    }

    public static void main(String[] args) {
        ListEmptyInmuebles consulta = new ListEmptyInmuebles();
        consulta.listEmptyInmueblesOrAlmostEmpty();
    }
}
