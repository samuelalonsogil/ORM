package daoModels;

import voModels.Cliente;

import java.util.Iterator;
public class ClienteDAO {

    /*1º) Para fomentar el turismo se quiere regalar un viaje al cliente o clientes que más viajes haya
        realizado (el que tenga 3 o más tarjetas de embarque). Mostrar el nombre completo del cliente
        y el nº de viaje realizados.*/
    public Iterator<Cliente> listWinnerClients(){
        String hql = "SELECT cl.nombre, cl.apellidos, COUNT(cl.numTarjeta) FROM";
    }
}
