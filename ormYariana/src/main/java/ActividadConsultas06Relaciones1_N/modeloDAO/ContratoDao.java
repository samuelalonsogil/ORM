package ActividadConsultas06Relaciones1_N.modeloDAO;

import ActividadConsultas06Relaciones1_N.modeloVO.Contrato;
import ActividadConsultas06Relaciones1_N.modeloVO.Propietario;
import Ejemplo05RelacionesNM.conexion.Conexion;

import javax.persistence.Query;
import java.util.Iterator;
import java.util.List;

public class ContratoDao {
    public static Iterator listarPrecios() {
        Conexion con = new Conexion();
        String hql = "SELECT  c.codContrato, c.precio, c.precio*0.21, c.precio*1.21 FROM Contrato c ";

        Query query = con.getConexion().createQuery(hql);
        Iterator iterator = query.getResultList().iterator();

        con.desconectar();
        return iterator;
    }


    public static Iterator listadoContratosPropietariios(){
        Conexion conexion = new Conexion();
        String hql = "SELECT c.codContrato, c.fechaVencimiento, c.inquilino.nombre,c.inmueble.direcicon," +
                "c.inmueble.zona.nombre,c.inmueble.propietario.nombre FROM Contrato c";

        Query query = conexion.getConexion().createQuery(hql);
        Iterator iterator = (Iterator) query.getResultList().iterator();

        conexion.desconectar();
        return iterator;
    }

    public static Iterator listadoPreciosMaxMin() {
        Conexion conexion = new Conexion();
        String hql = "SELECT MAX(c.precio), MIN(c.precio), SUM(c.precio), AVG(c.precio), COUNT(*)" +
                "FROM Contrato c";
        Query query = conexion.getConexion().createQuery(hql);
        Iterator iterator = query.getResultList().iterator();
        conexion.desconectar();
        return iterator;
    }


}
