package daoModel;

import connection.Connection;
import utilities.Utilities;
import voModel.Contrato;

@SuppressWarnings("ALL")
public class ContratoDAO {

    public Connection myConnection = new Connection();
    public Utilities utilities = new Utilities();

    /*1a) Actualizar la fecha de vencimiento de un contrato que introducimos como parámetro.*/
    public Contrato findContrato(String codContrato){
        Contrato contrato = myConnection.getConnection().find( Contrato.class, codContrato );
        return  contrato;
    }

    public Contrato modifyContract(Contrato contrato){
        utilities.connectionTransactions(contrato);
        return contrato;
    }



}
