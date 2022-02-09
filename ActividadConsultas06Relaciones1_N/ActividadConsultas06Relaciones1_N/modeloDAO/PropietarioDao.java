package ActividadConsultas06Relaciones1_N.modeloDAO;

import Ejemplo05RelacionesNM.conexion.Conexion;

import javax.persistence.Query;
import java.util.Iterator;

public class PropietarioDao {
    public static Iterator listarPropietarios() {
        Conexion con = new Conexion();
        String hql = "SELECT  p.dni, p.nombre, p.apellidos FROM Propietario p ";

        Query query = con.getConexion().createQuery(hql);
        Iterator iterator = query.getResultList().iterator();

        con.desconectar();
        return iterator;
    }
}
