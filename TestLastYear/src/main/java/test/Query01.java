package test;

import daoModels.ClienteDAO;

import java.util.Iterator;

public class Query01 {

    public ClienteDAO clienteDAO = new ClienteDAO();

    public void query01(){
        Iterator iterator = clienteDAO.listWinnerClients();
        while (iterator.hasNext()){
            Object[]row = (Object[]) iterator.next();
            System.out.println("nombre: " + row[0] + "\napellidos: " + row[1] + "\nnumero_de_tarjetas:" + row[2] +
                    "\n----------------------------------------------------------------");
        }
    }

    public static void main(String[] args) {
        Query01 query01 = new Query01();
        query01.query01();
    }

}
