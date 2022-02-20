package tests;

import daoModel.ClienteDao;
import utilities.Utilities;
import voModel.Cliente;
import java.util.List;

public class Query08 {
    ClienteDao clienteDao = new ClienteDao();
    Utilities utilities = new Utilities();

    public void listarClientesPorLetra(){
        List<Cliente> clientes = clienteDao.listarClientesPorLetra( utilities.introduceDataChar("Introduce la letra: ") );
        for(Cliente cliente:clientes){
            System.out.println("nombre: " + cliente.getNombre());
        }
    }

    /*test 08*/
    public static void main(String[] args) {
        Query08 query08 = new Query08();
        query08.listarClientesPorLetra();
    }
}
