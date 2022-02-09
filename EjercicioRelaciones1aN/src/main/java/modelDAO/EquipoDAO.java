package modelDAO;

import connection.Connection;
import modelVO.Equipo;

import javax.persistence.PersistenceException;

public class EquipoDAO {

    public static void newTeam(Equipo equipo){
        try{
            Connection.getConnection().getTransaction().begin();
            Connection.getConnection().persist(equipo);
            Connection.getConnection().getTransaction().commit();
        }catch (PersistenceException pe){
            pe.printStackTrace();
        }
        Connection.disconnect();
    }

    public static Equipo buscarEquipo(String eqNombre) {
        Equipo equipo = Connection.getConnection().find(Equipo.class, eqNombre);

        Connection.disconnect();

        return equipo;
    }
}
