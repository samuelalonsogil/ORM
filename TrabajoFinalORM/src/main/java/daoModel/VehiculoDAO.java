package daoModel;

import connection.Connection;
import utilities.Utilities;
import voModel.Vehiculo;

import javax.persistence.PersistenceException;
import javax.persistence.Query;
import java.util.Iterator;
import java.util.List;

public class VehiculoDAO {

    public Connection myConnection = new Connection();
    public Utilities utilities = new Utilities();

    /*1. Generar un listado con todos los vehículos de los grupos E, F y G.*/
    public List<Vehiculo> generateListVehiculoGroups(){
        String hql = "FROM Vehiculo v WHERE v.grupo = 'E' OR  v.grupo = 'F' OR v.grupo = 'G'";
        return utilities.stablishConnectionList(hql);
    }

    /*2. Obtener para cada vehículo el total de días alquilados y el importe total cobrado. Ordenados
        por el número de matrícula.*/
    public Iterator generateListVehiculosDiasYcobrado(){
        String hql = "SELECT v.matricula, SUM(vc.dias), SUM(vc.precio) FROM Vehiculo v " +
                "JOIN VehiculoCliente vc ON v.matricula = vc.vehiculo GROUP BY v.matricula";

        return utilities.stablishConnectionIterator(hql);
    }

    /*3. Listar los vehículos que no hayan sido alquilados.*/
    public Iterator generateListVehiculosSinAlquilar(){
        String hql = "SELECT v.matricula, v.marca, vc.dias FROM Vehiculo v " +
                "JOIN VehiculoCliente vc ON v.matricula = vc.vehiculo WHERE vcDias = 0";

        return utilities.stablishConnectionIterator(hql);
    }

    /*7. Listar los vehículos con un número de puertas y cuyo maletero tenga una capacidad superior
        a unos valores que introducimos por teclado. Por ejemplo 5 y 500*/
    public List<Vehiculo> listVehiculosPuertasMaletero(int puertas, int maletero){
        String hql = "FROM Vehiculo v WHERE v.puertas > :puertas AND maletero > :maletero";
        return utilities.stablishConnection(hql).setParameter("puertas", puertas).setParameter("maletero", maletero).getResultList();
    }

    /*9. Listar el coche o coches cuyo precio de alquiler haya sido el más caro.*/
    public Iterator listCocheMasCaro(){
        String hql= "SELECT v.matricula, v.marca, vc.precio " +
                "FROM Vehiculo v JOIN VehiculoCliente vc ON v.matricula = vc.vehiculo.matricula " +
                "WHERE vc.precio = (SELECT MAX(vc.precio) FROM VehiculoCliente vc)";
        return utilities.stablishConnectionIterator(hql);
    }

    /*10. Listar todos los vehículos cuya matricula contenga una combinación de letras determinada
            que introducimos por teclado. Por ejemplo HHM.*/
    public List<Vehiculo> listVehiculosMatriculaLetrasPorTeclado(String letrasMatricula){
        String hql = "FROM Vehiculo v WHERE SUBSTRING(v.matricula,1,3)=:letrasMatricula";
        return utilities.stablishConnection(hql).setParameter("letrasMatricula", letrasMatricula).getResultList();
    }

    /*11. Actualizar el precio de los alquileres de los vehículos de una determinada marca.*/
    public void actualizarPrecioAlquileres(int nuevoPrecio, String marca){
        String hql = "UPDATE VehiculoCliente vc SET vc.precio=:nuevoPrecio WHERE vc.vehiculo.marca IN (SELECT v.marca FROM Vehiculo v WHERE v.marca=:marca)";

        utilities.connectionTransactionsUpdateQuery(utilities.stablishConnection(hql).setParameter("nuevoPrecio", nuevoPrecio).setParameter("marca", marca));


    }

    /*12. Realizar una consulta para eliminar un determinado coche cuya matricula introducimos como
        parémetro*/
    public void deleteCochePorMatricula(String matricula){
        String hql01 = "DELETE FROM VehiculoCliente vc WHERE vc.vehiculo.matricula=:matricula";
        String hql02 = "DELETE FROM Vehiculo v WHERE v.matricula=:matricula";

        try{
            myConnection.getConnection().getTransaction().begin();

            Query query01 = myConnection.getConnection().createQuery(hql01);
            query01.setParameter("matricula", matricula).executeUpdate();

            Query query02 = myConnection.getConnection().createQuery(hql02);
            query02.setParameter("matricula", matricula).executeUpdate();

            myConnection.getConnection().getTransaction().commit();

        }catch (PersistenceException pe){
            pe.printStackTrace();
            myConnection.getConnection().getTransaction().rollback();

        }
        myConnection.disconnect();

    }

    /*ej 5*/
    public Vehiculo findVehiculo(String matricula){
        return myConnection.getConnection().find(Vehiculo.class,matricula);
    }
}
