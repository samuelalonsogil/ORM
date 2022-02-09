package modeloDAO;

import conexion.Conexion;
import modeloVO.Contrato;

import javax.persistence.PersistenceException;

public class ContratoDao {
    public static Contrato buscarContrato(int numContrato) {
        Conexion conexion = new Conexion();

        Contrato contrato = conexion.getConexion().find(Contrato.class, numContrato);

        conexion.desconectar();

        return contrato;

    }

    public static void nuevoContrato(Contrato contrato) {
        Conexion conexion = new Conexion();

        System.out.println("Contrato: " +contrato);
        try{
            conexion.getConexion().getTransaction().begin();
            conexion.getConexion().persist(contrato);
            conexion.getConexion().getTransaction().commit();
        }catch (PersistenceException pe){
            conexion.getConexion().getTransaction().rollback();
            pe.printStackTrace();
        }
    }

    public static void nuevoContrato01(Contrato contrato) {

        try{
            Conexion.getConexion().getTransaction().begin();
            Conexion.getConexion().persist(contrato);
            Conexion.getConexion().getTransaction().commit();

        }catch (PersistenceException pe){
            Conexion.getConexion().getTransaction().rollback();
            pe.printStackTrace();
            Conexion.desconectar();
        }
    }
}
