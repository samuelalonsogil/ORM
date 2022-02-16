package test;

import daoModel.ContratoDAO;

import java.util.Iterator;

public class TotalRentsForContrato {
    ContratoDAO contratoDAO = new ContratoDAO();
    public void query10(){
        Iterator iterator = contratoDAO.listTotalRent();
        while (iterator.hasNext()){
            Object[]row = (Object[]) iterator.next();
            System.out.println("contract code: " + row[0] + " total: " + row[1] );
        }
    }

    public static void main(String[] args) {
        TotalRentsForContrato totalRentsForContrato = new TotalRentsForContrato();
        totalRentsForContrato.query10();
    }
}
