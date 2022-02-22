package daoModel;

import connection.Connection;
import utilities.Utilities;
import voModel.Vehiculo;
import voModel.VehiculoCliente;

import java.util.Iterator;

public class VehiculoClienteDAO {

    public Utilities utilities = new Utilities();
    public Connection myConnection = new Connection();

    /*4.Obtener un listado con todos los alquileres de un determinado coche cuya matrícula
        introducimos por teclado, por ejemplo 'HHM-4572'. Los datos que se mostrarán son: el
        nombre del cliente, la matricula y la marca del coche, los días que duró el alquiler, el tipo de
        seguro y el precio.*/
    public Iterator generateListAlquileresPorMatricula(String matricula){
        String hql = "SELECT cl.nombre, v.matricula, v.marca, vc.dias, vc.seguro, vc.precio " +
                "FROM Cliente cl JOIN VehiculoCliente vc ON cl.dni = vc.cliente " +
                "JOIN Vehiculo v ON vc.vehiculo = v.matricula WHERE v.matricula=:matricula";
        return utilities.stablishConnection(hql).setParameter("matricula",matricula).getResultList().iterator();
    }

    /*5. Insertar un alquiler, en el caso de que el cliente o el vehículo no existan hay que darlos de
        alta previamente. Los datos del alquiler se introducirán por teclado.*/
    public VehiculoCliente findAlquiler(int idAlquiler){
        return myConnection.getConnection().find(VehiculoCliente.class,idAlquiler);
    }

    public void newAlquiler(VehiculoCliente vehiculoCliente){
        vehiculoCliente = findAlquiler(vehiculoCliente.getIdVehiculoCliente());
        utilities.connectionTransactions(vehiculoCliente);
<<<<<<< HEAD

=======
>>>>>>> bb3ee6feddacf817cf9ce9c5fd36d118d4e4e0eb
    }

    /*6. Obtener un listado de los alquileres mostrando los siguientes datos: Matrídula, DNI, Nombre
        y teléfono del cliente, días y precio. Ordenado por el nombre del cliente y por matrícula.*/
    public Iterator generateListAlquileresOrdenada(){
        String hql = "SELECT vc.vehiculo.matricula, vc.cliente.dni, cl.nombre, cl.telefono, vc.dias, vc.precio " +
                "FROM Cliente cl JOIN VehiculoCliente vc ON cl.dni = vc.cliente.dni " +
                "ORDER BY cl.nombre, vc.vehiculo.matricula";
        return utilities.stablishConnectionIterator(hql);
    }
}
