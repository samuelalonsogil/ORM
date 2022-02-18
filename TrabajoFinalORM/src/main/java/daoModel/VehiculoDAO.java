package daoModel;

import utilities.Utilities;
import voModel.Vehiculo;

import java.util.Iterator;
import java.util.List;

public class VehiculoDAO {

    public Utilities utilities = new Utilities();

    /*1. Generar un listado con todos los vehículos de los grupos E, F y G.*/
    public List<Vehiculo> generateListVehiculoGroups(){
        String hql = "FROM Vehiculo v WHERE v.grupo = 'E' OR  v.grupo = 'F' OR v.grupo = 'G'";
        return utilities.stablishConnectionList(hql);
    }

}
