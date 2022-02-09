package ActividadConsultas06Relaciones1_N.modeloDAO;

import ActividadConsultas06Relaciones1_N.conexion.Conexion;
import ActividadConsultas06Relaciones1_N.modeloVO.Inmueble;
import ActividadConsultas06Relaciones1_N.modeloVO.Inquilino;


import javax.persistence.Query;
import java.util.List;

public class InquilinoDao {
    public static Inquilino buscarInquilino(String s) {
        String hql = "FROM Inquilino i where i.dni = '12345678G' ";

        Query query = Conexion.getConexion().createQuery(hql);

        //se puede hacer de dos maneras
        Inquilino inquilino = (Inquilino) query.getSingleResult();

        //esto solo devuelve una fila
        //Inquilino inquilino1 = (Inquilino) con.getConexion().createQuery(hql).getSingleResult();

        Conexion.desconectar();
        return inquilino;
    }

    public static List<Inquilino> listaInquilino(){
        String hql = "SELECT new Inquilino(i.dni, i.nombre) FROM Inquilino i ORDER BY i.nombre";

        Query query = (Query) Conexion.getConexion().createQuery(hql);
        List<Inquilino>inquilinos = query.getResultList();

        Conexion.desconectar();
        return inquilinos;
    }

    public static List<Object> listadoCreandoLista(){
        String hql = "SELECT new list(i.dni, i.nombre) FROM Inquilino i";

        Query query = (Query) Conexion.getConexion().createQuery(hql);
        List<Object>lista = query.getResultList();

        Conexion.desconectar();
        return lista;
    }

    public static List<Object> listadoInmueblesLibresZonas(String zona){
        String hql = "FROM Inmuebles i WHERE i.zona.nombre = zona AND i.estado = false";

        Query query = (Query) Conexion.getConexion().createQuery(hql);
        query.setParameter("zona", zona);
        List<Inmueble> inmuebles= query.getResultList();

        Conexion.desconectar();
        return inmuebles;
    }


}
