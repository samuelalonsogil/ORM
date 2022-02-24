package daoModels;

import connection.Connection;
import utilities.Utilities;
import voModels.Cliente;

import java.util.Date;
import java.util.Iterator;
public class ClienteDAO {

    public Utilities utilities = new Utilities();
    public Connection myConnection = new Connection();

    /*ej 4*/
    public Cliente findCliente(String dni){
        return myConnection.getConnection().find(Cliente.class,dni);
    }

    public void newCliente(Cliente cliente){
        utilities.connectionTransactions(cliente);

    }

    /*1º) Para fomentar el turismo se quiere regalar un viaje al cliente o clientes que más viajes haya
        realizado (el que tenga 3 o más tarjetas de embarque). Mostrar el nombre completo del cliente
        y el nº de viaje realizados.*/
    public Iterator listWinnerClients(){
        String hql = "SELECT te.cliente.nombre, te.cliente.apellidos, COUNT(te.cliente.numTarjeta) " +
                "FROM TarjetaEmbarque te GROUP BY (te.cliente.nombre) HAVING COUNT(te.cliente.numTarjeta) >= 3";
        return utilities.stablishConnectionIterator(hql);
    }

    /*3º) Listar los clientes que tienen que salir del aeropuerto
        de Vigo en una determinada fecha que introduciremos por teclado. (Por ejemplo hoy)." */
    public Iterator listSalirAeropuerto(Date date){
        String hql = "SELECT cl.nombre, cl.apellidos, vu.fechaSalida, vu.origen.codigo " +
                " FROM Cliente cl JOIN TarjetaEmbarque te ON cl.dni = te.cliente.dni " +
                "JOIN Vuelo vu ON te.vuelo.codigo = vu.codigo " +
                "WHERE vu.origen.codigo = 100 AND vu.fechaSalida = :date ";
        return utilities.stablishConnection(hql).setParameter("date", date).getResultList().iterator();

    }
}
