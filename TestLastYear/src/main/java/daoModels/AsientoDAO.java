package daoModels;

import connection.Connection;
import utilities.Utilities;
import voModels.Asiento;
import voModels.Cliente;

public class AsientoDAO {

    public Utilities utilities = new Utilities();
    public Connection myConnection = new Connection();

    /*ej 4*/
    public Asiento findAsiento(int code){
        return myConnection.getConnection().find(Asiento.class,code);
    }

    public void newAsiento(Asiento asiento){
        utilities.connectionTransactions(asiento);

    }

}
