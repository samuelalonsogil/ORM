package daoModel;

import connection.Connection;
import utilities.Utilities;
import voModel.Inquilino;

import java.util.Iterator;
import java.util.List;


public class InquilinoDAO {

    public Connection myConnection = new Connection();
    public Utilities utilities = new Utilities();

    public Inquilino findInquilino(String coInquilino){
        return myConnection.getConnection().find( Inquilino.class, coInquilino );
    }

    /*6ª) Necesitamos separar en tres columnas diferentes el nombre y los apellidos de los
        inquilinos.*/
    /*el select se usa cuando devuelve rows manipuladas (calculo de iva, esto...)*/
    public Iterator divideNames(){
                                                        /*primer apellido*/
        String hql =
                "SELECT SUBSTRING( i.nombre,1, LOCATE(' ', i.nombre)), " +
                "SUBSTRING(i.nombre,LOCATE(' ', i.nombre),LOCATE(',',i.nombre) - LOCATE('',i.nombre))," +
                " SUBSTRING(i.nombre, LOCATE(',', i.nombre)+1, LENGHT(i.nombre)), " +
                "SUBSTRING(i.nombre, 1, LOCATE(i.nombre, ',')) FROM Inquilino i";
        return utilities.stablishConnectionIterator(hql);
    }

    /*8º) Eliminar los inquilinos que no tengan ningún contrato.*/
    public List<Inquilino> listadoInquilinoSinContrato(){
        String hql = "FROM Inquilino i WHERE i.dni NOT IN(SELECT c.inquilino.dni FROM Contrto c)";

        List<Inquilino> inquilinos = utilities.stablishConnectionList(hql);
        for (Inquilino inquilino:inquilinos){
            System.out.println(inquilino);
        }
        myConnection.disconnect();
        return inquilinos;
    }

    public void deleteInquilinosSinContrato(){
        String hql = "DELETE FROM Inquilino i WHERE i.dni NOT IN(SELECT c.inquilino.dni FROM Contrato c)";
        utilities.connectionTransactionsUpdate(hql);
    }


}
