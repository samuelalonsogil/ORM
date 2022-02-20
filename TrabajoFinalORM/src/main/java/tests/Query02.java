package tests;

import daoModel.VehiculoDAO;
import java.util.Iterator;

public class Query02 {
    public VehiculoDAO vehiculoDAO = new VehiculoDAO();

    public void listarVehiculosDiasYprecioTotal(){
        Iterator iterator = vehiculoDAO.generateListVehiculosDiasYcobrado();
        while (iterator.hasNext()){
            Object[]row = (Object[]) iterator.next();
            System.out.println("matricula: " + row[0] + " num_dias: " + row[1] + " total cobrado:" + row[2]);
        }
    }
    /*test 02*/
    public static void main(String[] args) {
        Query02 listTotalDiasYCobrado = new Query02();
        listTotalDiasYCobrado.listarVehiculosDiasYprecioTotal();
    }
}
