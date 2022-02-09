package ActividadConsultas06Relaciones1_N.modeloDAO;

import ActividadConsultas06Relaciones1_N.modeloVO.Inmueble;
import Ejemplo05RelacionesNM.conexion.Conexion;

import javax.persistence.Query;
import java.util.List;

public class InmuebleDao {

    public static List<Inmueble> listadoInmuebles() {
        Conexion con = new Conexion();
        String hql = "FROM Inmueble i";

        //equivale al PreparedStatement de jdbc
        Query query = con.getConexion().createQuery(hql);
        List<Inmueble> inmuebles = query.getResultList();

        con.desconectar();
        return inmuebles;
    }
}
