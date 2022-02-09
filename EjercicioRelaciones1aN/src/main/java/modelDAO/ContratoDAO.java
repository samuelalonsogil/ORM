package modelDAO;

import connection.Connection;
import modelVO.Contrato;

import javax.persistence.PersistenceException;

public class ContratoDAO {

    public static Contrato buscarContrato(int numContrato) {
        Contrato contrato = Connection.getConnection().find(Contrato.class, numContrato);
        Connection.disconnect();

        return contrato;
    }

    public static void nuevoContrato(Contrato contrato) {
        System.out.println("Contrato: " + contrato);
        try{
            Connection.getConnection().getTransaction().begin();
            Connection.getConnection().persist(contrato);
            Connection.getConnection().getTransaction().commit();
        }catch (PersistenceException pe){
            Connection.getConnection().getTransaction().rollback();
            pe.printStackTrace();
        }
    }
}
