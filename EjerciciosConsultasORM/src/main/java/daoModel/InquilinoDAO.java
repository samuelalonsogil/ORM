package daoModel;

import connection.Connection;
import voModel.Inquilino;

public class InquilinoDAO {

    public Connection myConnection = new Connection();

    public Inquilino findInquilino(String coInquilino){
        return myConnection.getConnection().find( Inquilino.class, coInquilino );
    }
}
