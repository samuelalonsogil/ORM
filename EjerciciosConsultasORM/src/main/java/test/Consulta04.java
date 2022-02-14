package test;

import daoModel.ContratoDAO;

import java.util.Iterator;

public class Consulta04 {

    ContratoDAO contratoDAO = new ContratoDAO();

    public void consulta04(){
        Iterator iterator =  contratoDAO.listContratosVencimientoMesActual();

        while (iterator.hasNext() ){
            Object[] row = (Object[]) iterator.next();
            System.out.println("code: " + row[0] + " direction: " + row[1] + " " + row[2] + " " + row[3]);
        }
    }

    public static void main(String[] args) {
        Consulta04 consulta = new Consulta04();
    }
}
