package daoModel;

import connection.Connection;
import voModel.Contrato;

import javax.persistence.Persistence;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

@SuppressWarnings("ALL")
public class ContratoDAO {

    public Connection myConnection;

    public Query stablishConnection(String hql){
        myConnection = new Connection();
        String queryHql = hql;
        Query query = myConnection.getConnection().createQuery(queryHql);
        myConnection.disconnect();
        return query;
    }

    public void connectionTransactions(Contrato contrato){
        myConnection = new Connection();

        try{
            myConnection.getConnection().getTransaction().begin();
            myConnection.getConnection().merge(contrato);
            myConnection.getConnection().getTransaction().commit();

        }catch (PersistenceException pe){

            myConnection.getConnection().getTransaction().rollback();
            pe.printStackTrace();
        }

        myConnection.disconnect();
    }

    /*1a) Actualizar la fecha de vencimiento de un contrato que introducimos como parámetro.*/
    public Contrato findContrato(String codContrato){
        String hql = "FROM Contratos c WHERE c.codContrato =" + codContrato;
        Contrato contrato = (Contrato) stablishConnection(hql).getSingleResult();
        return  contrato;
    }

    public Contrato modifyContract(Contrato contrato){
        connectionTransactions(contrato);
        return contrato;
    }



}
