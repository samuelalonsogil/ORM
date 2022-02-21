package daoModel;

import connection.Connection;
import voModel.Oficina;
import voModel.Vehiculo;

public class OficinaDAO {
    public Connection myConnection = new Connection();

    public Oficina findOficina(int idOficina){
        return myConnection.getConnection().find(Oficina.class,idOficina);
    }
}
