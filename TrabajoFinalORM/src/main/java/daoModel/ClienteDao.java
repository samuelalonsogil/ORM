package daoModel;

import connection.Connection;
import utilities.Utilities;
import voModel.Cliente;
import voModel.VehiculoCliente;

import java.util.List;

public class ClienteDao {

    Utilities utilities = new Utilities();
    Connection myConnection = new Connection();

    /*8. Listar todos los clientes cuyo apellido comience por una letra que introducimos por teclado.
        Por ejemplo la A.*/
    public List<Cliente> listarClientesPorLetra(String letra){
        String hql = "FROM Cliente c WHERE SUBSTRING(c.nombre, LOCATE(' ', c.nombre )+1 ,1 )=:letra";
        return utilities.stablishConnection(hql).setParameter("letra",letra).getResultList();
    }

    /*ej 5*/
    public Cliente findAlquiler(String dni){
        return myConnection.getConnection().find(Cliente.class,dni);
    }


    public void newCliente(Cliente cliente){
        utilities.connectionTransactions(cliente);

    }
}
