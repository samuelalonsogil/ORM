package daoModels;

import connection.Connection;
import utilities.Utilities;
import voModels.Asiento;
import voModels.Vuelo;

public class VueloDAO {

    public Utilities utilities = new Utilities();
    public Connection myConnection = new Connection();

    /*ej 4*/
    public Vuelo findVuelo(int code){
        return myConnection.getConnection().find(Vuelo.class,code);
    }

    public void newVuelo(Vuelo vuelo){
        utilities.connectionTransactions(vuelo);

    }
}
