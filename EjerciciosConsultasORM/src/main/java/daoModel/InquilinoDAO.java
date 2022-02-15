package daoModel;

import connection.Connection;
import voModel.Inquilino;

import java.util.Iterator;

public class InquilinoDAO {

    public Connection myConnection = new Connection();

    public Inquilino findInquilino(String coInquilino){
        return myConnection.getConnection().find( Inquilino.class, coInquilino );
    }

    /*8º) Eliminar los inquilinos que no tengan ningún contrato.*/

}
