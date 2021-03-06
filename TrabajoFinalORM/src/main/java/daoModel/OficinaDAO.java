package daoModel;

import connection.Connection;
import utilities.Utilities;
import voModel.Oficina;

public class OficinaDAO {
    public Connection myConnection = new Connection();
    public Utilities utilities = new Utilities();

    public Oficina findOficina(int idOficina){
        return myConnection.getConnection().find(Oficina.class,idOficina);
    }

    public void newOficina(Oficina oficina){
        utilities.connectionTransactions(oficina);

    }
}
