package ActividadConsultas06Relaciones1_N.modeloDAO;

import Ejemplo05RelacionesNM.conexion.Conexion;

import javax.persistence.Query;
import java.util.Iterator;

public class ContratoDao {
    public static Iterator listarPrecios() {
        Conexion con = new Conexion();
        String hql = "SELECT  c.codContrato, c.precio, c.precio*0.21, c.precio*1.21 FROM Contrato c ";

        Query query = con.getConexion().createQuery(hql);
        Iterator iterator = query.getResultList().iterator();

        con.desconectar();
        return iterator;
    }
}
