package daoModel;

import connection.Connection;
import utilities.Utilities;
import voModel.Contrato;
import voModel.Inmueble;

import java.util.Iterator;
import java.util.List;

@SuppressWarnings("ALL")
public class ContratoDAO {

    public Connection myConnection = new Connection();
    public Utilities utilities = new Utilities();
    public InmuebleDAO inmuebleDAO = new InmuebleDAO();
    public Inmueble inmueble = new Inmueble();
    public Contrato contrato = new Contrato();

    /*1a) Actualizar la fecha de vencimiento de un contrato que introducimos como parámetro.*/
    public Contrato findContrato(String codContrato) {
        return (Contrato) myConnection.getConnection().find(Contrato.class, codContrato);
    }

    public Contrato modifyContract(Contrato contrato) {
        utilities.connectionTransactions(contrato);
        return contrato;
    }


    /*5ª) Insertar un nuevo contrato, la fecha del contrato es el día que se da de alta y la
            duración del contrato es de 4 años. Hay que utilizar funciones de fecha. El inmueble
            obligatoriamente debe estar dado de alta, lo mismo que el propietario, en el caso que
            el inquilino no esté en la BBDD hay que insertarlo.*/
    public void newContrato(Contrato contrato) {
        inmueble = inmuebleDAO.findInmueble(contrato.getInmueble().getCodInmueble());
        utilities.connectionTransactions(contrato);
    }

    /*7ª) Insertar en una nueva tabla ContratosVencen, mismas columnas que la tabla
        Contratos, los contratos que venzan en el presente año.*/
    public List<Contrato> createContratosVencen() {
        String hql = "FROM Contrato c WHERE YEAR(c.fechaVencimiento) = YEAR(CURRENT_DATE())";
        return (List<Contrato>) utilities.stablishConnectionList(hql);
    }

    /*9º) Mostrar el contrato más caro, indicando el nombre del inquilino*/
    public List<Contrato> mostExpensiveContrato() {
        String hql = "FROM Contrato WHERE precio = (SELECT MAX(co.precio) FROM Contrato co)";
        return  utilities.stablishConnectionList(hql);
    }

    /*10º) Listar el total recaudado en alquileres por cada contrato. Hay que tener en cuenta
        que el precio es mensual.*/
    public Iterator listTotalRent(){
        String query = "SELECT c.codContrato, TRUNCATE(DATEDIFF(c.fechaVencimiento, c.fechaContrato)/30, 0)*c.precio FROM Contrato c";
        return utilities.stablishConnectionIterator(query);
    }
}
