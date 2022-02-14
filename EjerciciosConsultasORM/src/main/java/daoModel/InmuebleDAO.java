package daoModel;

import utilities.Utilities;
import voModel.Inmueble;
import java.util.List;

public class InmuebleDAO {

    public Utilities utilities = new Utilities();

    /*2a) Listar todos los inmuebles libres o que su contrato venza en el presente mes, de una determinada
    zona que introducimos como parámetro.*/
    public List<Inmueble> listInmueblesZona(String zona){
        String hql = "FROM Inmueble i WHERE ( i.estado = 0 OR MONTH(i.contrato.fechaContrato) = MONTH(CURDATE() ) ) AND i.zona.nombre = :zona";

        return utilities.stablishConnection(hql).setParameter("zona", zona).getResultList();
    }

    /*3ª) Incrementar el precio de los inmuebles de una zona cuyo nombre introducimos
    como parámetro.*/

}
