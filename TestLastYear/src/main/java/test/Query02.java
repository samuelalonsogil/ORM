package test;

import daoModels.AvionDAO;

import java.util.Iterator;

public class Query02 {

    public AvionDAO avionDAO = new AvionDAO();

    public void query02(){
        Iterator iterator = avionDAO.listAvionesNoVuelos();

        while (iterator.hasNext()){
            Object[]row = (Object[]) iterator.next();
            System.out.println("nombre: " + row[0] + "\napellidos: " + row[1] + "\nnumero_de_tarjetas:" + row[2] +
                    "\n----------------------------------------------------------------");
        }
    }

    public static void main(String[] args) {
        Query02 query02 = new Query02();
        query02.query02();
    }
}
