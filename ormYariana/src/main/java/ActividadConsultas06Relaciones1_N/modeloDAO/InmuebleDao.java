package ActividadConsultas06Relaciones1_N.modeloDAO;

import ActividadConsultas06Relaciones1_N.modeloVO.Inmueble;
import Ejemplo05RelacionesNM.conexion.Conexion;

import javax.persistence.Query;
import java.util.Iterator;
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

    public static List<Inmueble> listadoInmueblesLibresZona(String zona) {
        Conexion conexion = new Conexion();
        //select * from join zonas on zocodigo = incodzona where zonombre = ? and
        //inestado = 0

        String hql = "FROM Inmueble i WHERE i.zona.nombre = :zona AND i.estado= false";

        Query query = conexion.getConexion().createQuery(hql);
        query.setParameter("zona", zona);

        List<Inmueble> inmuebles = query.getResultList();

        conexion.desconectar();

        return inmuebles;
    }

    public static Iterator contarInmbueblesZonas01() {
        Conexion conexion = new Conexion();
        String hql = "SELECT i.zona.codZona, i.zona.nombre, COUNT(i.codInmueble) FROM Inmueble i" +
                "GROUP BY i.zona.codZona, i.zona.nombre";
        Query query = conexion.getConexion().createQuery(hql);
        Iterator iterator = query.getResultList().iterator();
        conexion.desconectar();
        return iterator;

    }
}

