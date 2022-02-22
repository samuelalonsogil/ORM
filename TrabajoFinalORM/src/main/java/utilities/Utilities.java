package utilities;

import connection.Connection;
import voModel.VehiculoCliente;

import javax.persistence.PersistenceException;
import javax.persistence.Query;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Utilities {

    public Connection myConnection = new Connection();
    public Scanner scanner = new Scanner(System.in);


    public String introduceData(String data){
        System.out.println(data);
        return scanner.next();
    }

    public int introduceDataInt(String data){
        System.out.println(data);
        return scanner.nextInt();
    }



    public String introduceDataChar(String data){
        System.out.println(data);
        return String.valueOf(scanner.nextLine().charAt(0)).toUpperCase(Locale.ROOT);
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

    public List stablishConnectionList(String hql){
        myConnection = new Connection();
        return myConnection.getConnection().createQuery(hql).getResultList();
    }


    public void connectionTransactionsUpdateQuery(Query hql){
        try{
            myConnection.getConnection().getTransaction().begin();
            hql.executeUpdate();
            myConnection.getConnection().getTransaction().commit();

        }catch (PersistenceException pe){
            pe.printStackTrace();
            myConnection.getConnection().getTransaction().rollback();

        }

        myConnection.disconnect();
    }

    public void connectionTransactions(Object object ){
        myConnection = new Connection();

        try{
            myConnection.getConnection().getTransaction().begin();
            myConnection.getConnection().merge(object);
            myConnection.getConnection().getTransaction().commit();

        }catch (PersistenceException pe){

            myConnection.getConnection().getTransaction().rollback();
            pe.printStackTrace();
        }

        myConnection.disconnect();
    }




}
