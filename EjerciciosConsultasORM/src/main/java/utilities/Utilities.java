package utilities;

import connection.Connection;
import voModel.Contrato;

import javax.persistence.PersistenceException;
import javax.persistence.Query;
import java.util.Iterator;
import java.util.Scanner;

public class Utilities {

    public Connection myConnection;
    public Scanner scanner = new Scanner(System.in);


    public String introduceData(String data){
        System.out.println(data);
        return scanner.next();
    }

    public int introduceDataInt(String data){
        System.out.println(data);
        return scanner.nextInt();
    }

    public double introduceDataDouble(String data){
        System.out.println(data);
        return scanner.nextDouble();
    }

    public Query stablishConnection(String hql){
        myConnection = new Connection();
        return myConnection.getConnection().createQuery(hql);
    }


    public Iterator stablishConnectionIterator(String hql){
        myConnection = new Connection();
        return myConnection.getConnection().createQuery(hql).getResultList().iterator();
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


    public void connectionTransactionsUpdate(String hql){
        myConnection = new Connection();

        try{
            myConnection.getConnection().getTransaction().begin();
            stablishConnection(hql).executeUpdate();
            myConnection.getConnection().getTransaction().commit();

        }catch (PersistenceException pe){

            myConnection.getConnection().getTransaction().rollback();
            pe.printStackTrace();
        }

        myConnection.disconnect();
    }



}
