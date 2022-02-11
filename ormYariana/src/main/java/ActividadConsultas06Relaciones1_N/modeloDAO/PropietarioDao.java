package ActividadConsultas06Relaciones1_N.modeloDAO;

import ActividadConsultas06Relaciones1_N.conexion.Conexion;
import ActividadConsultas06Relaciones1_N.modeloVO.Propietario;


import javax.management.Query;
import java.util.Iterator;
import java.util.List;

public class PropietarioDao {
    public static Iterator listarPropietarios() {
        Conexion con = new Conexion();
        String hql = "SELECT  p.dni, p.nombre, p.apellidos FROM Propietario p ";

        Query query = con.getConexion().createQuery(hql);
        Iterator iterator = query.getResultList().iterator();

        con.desconectar();
        return iterator;
    }

    public static Propietario buscarPropietario(String buscar) {
        Conexion conexion = new Conexion();

        //sin utilizar parámetros
        String hql = "FROM Propietario p WHERE p.dni = '" + buscar + "'";

        //con parámetros
        String hql1 = "FROM Propietario p WHERE p.dni = :dni";

        Query query = conexion.getConexion().createQuery(hql1);

        query.setParameter("dni", buscar);

        Propietario propietario = (Propietario) query.getSingleResult();

        conexion.desconectar();

        return propietario;
    }

    public static List<Propietario> listadoPropietariosInmuebles01(){
        Conexion conexion = new Conexion();
        String hql = "FROM Propietario p";
        Query query = conexion.getConexion().createQuery(hql);
        List<Propietario> propietarios = query
    }

    public static Iterator listadoPropietariosInmueblesJoin01() {
        Conexion conexion = new Conexion();
        String hql = "FROM Propietario pro JOIN pro.inmuebles";
        Query query = conexion.getConexion().createQuery(hql);
        Iterator iterator = query.getResultList().iterator();
        conexion.desconectar();
        return iterator;
    }

    public static Iterator listadoPropietariosSinInmuebles() {
        Conexion conexion = new Conexion();
        String hql = "FROM Inmueble i JOIN i.propietario WHERE i.codInmueble IS NULL";
        Query query = conexion.getConexion().createQuery(hql);
        Iterator iterator = query.getResultList().iterator();
        conexion.desconectar();
        return iterator;
    }
}
