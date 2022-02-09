package connection;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Connection {

    public static EntityManagerFactory emf;
    public static EntityManager em;

    public Connection(){
        emf = Persistence.createEntityManagerFactory("HibernateEjemplo1");
        em = emf.createEntityManager();
    }

    public static EntityManager getConnection() {return em;}

    public static void disconnect(){
        em.close();
        emf.close();
    }

}
