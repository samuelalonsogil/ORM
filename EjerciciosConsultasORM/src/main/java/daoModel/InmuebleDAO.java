package daoModel;

import connection.Connection;
import utilities.Utilities;
import voModel.Inmueble;

import java.util.List;

public class InmuebleDAO {

    public Connection myConnection;
    public Utilities utilities = new Utilities();

    /*2a) Listar todos los inmuebles libres o que su contrato venza en el presente mes, de una determinada
    zona que introducimos como parámetro.*/
    public List<Inmueble> listInmueblesZona(String zona){
        String hql = "FROM Inmueble i WHERE (i.estado = 0 || MONTH(c.coFechaVencimiento) = MONTH(CURDATE() ) )" +
                "AND z.zoNombre = " + zona;

        return utilities.stablishConnection(hql).setParameter("zona", zona).getResultList();
    }
}
