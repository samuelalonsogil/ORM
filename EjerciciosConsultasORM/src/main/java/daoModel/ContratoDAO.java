package daoModel;

import connection.Connection;
import utilities.Utilities;
import voModel.Contrato;

import java.util.Iterator;

@SuppressWarnings("ALL")
public class ContratoDAO {

    public Connection myConnection = new Connection();
    public Utilities utilities = new Utilities();

    /*1a) Actualizar la fecha de vencimiento de un contrato que introducimos como parámetro.*/
    public Contrato findContrato(String codContrato){
        return (Contrato) myConnection.getConnection().find( Contrato.class, codContrato );
    }

    public Contrato modifyContract(Contrato contrato){
        utilities.connectionTransactions(contrato);
        return contrato;
    }



    /*4ª) Listar los inmuebles libres o cuya fecha de vencimiento sea el presente mes,
        mostrando el código, la dirección, la fecha de vencimiento, el nombre de y el teléfono del propietario.*/
    public Iterator listContratosVencimientoMesActual(){
        String hql = "SELECT c.inmueble.codInmueble, c.inmueble.direccion, c.fechaVencimiento, c.inmueble.propietario.nombre," +
                "c.inmueble.propietario.telefono FROM Contrato c WHERE MONTH(c.fechaVencimiento) = MONTH(CURRENT_DATE )";
        return utilities.stablishConnectionIterator(hql);
    }

}
