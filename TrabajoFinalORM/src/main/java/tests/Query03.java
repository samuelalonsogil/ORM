package tests;

import daoModel.VehiculoDAO;

import java.util.Iterator;

public class Query03 {
    public VehiculoDAO vehiculoDAO = new VehiculoDAO();

    public void listarVehiculosSinAlquilar(){
        Iterator iterator = vehiculoDAO.generateListVehiculosSinAlquilar();
        while (iterator.hasNext()){
            Object[]row = (Object[]) iterator.next();
            System.out.println("matricula: " + row[0] + " marca: " + row[1] + " dias:" + row[2]);
        }
    }

    /*test 03*/
    public static void main(String[] args) {
        Query03 listVehiculosSinAlquilar = new Query03();
        listVehiculosSinAlquilar.listarVehiculosSinAlquilar();
    }
}
