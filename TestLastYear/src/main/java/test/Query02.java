package test;

import daoModels.AvionDAO;

import java.util.Iterator;

public class Query02 {

    public AvionDAO avionDAO = new AvionDAO();

    public void query02(){
        Iterator iterator = avionDAO.listAvionesNoVuelos();

        while (iterator.hasNext()){
            Object[]row = (Object[]) iterator.next();
            System.out.println("code avión: " + row[0] + "\nmodelo avión: " + row[1] + "\ncode vuelo:" + row[2] +  "\nvuelo origen:" + row[3]+
                    "\n----------------------------------------------------------------");
        }
    }

    public static void main(String[] args) {
        Query02 query02 = new Query02();
        query02.query02();
    }
}
