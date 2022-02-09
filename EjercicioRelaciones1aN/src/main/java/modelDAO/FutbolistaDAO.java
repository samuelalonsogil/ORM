package modelDAO;

import connection.Connection;
import modelVO.Futbolista;

import javax.persistence.PersistenceException;

public class FutbolistaDAO {

    public static void newFootballPlayer(Futbolista futbolista) {

        try {
            Connection.getConnection().getTransaction().begin();
            Connection.getConnection().persist(futbolista);
            Connection.getConnection().getTransaction().commit();

        } catch (PersistenceException pe) {
            Connection.getConnection().getTransaction().rollback();
            pe.printStackTrace();
        }
        Connection.disconnect();
    }

    public static Futbolista findFootballPlayer(int numFicha) {

        Futbolista futbolista = Connection.getConnection().find(Futbolista.class, numFicha);
        Connection.disconnect();

        return futbolista;
    }
}
