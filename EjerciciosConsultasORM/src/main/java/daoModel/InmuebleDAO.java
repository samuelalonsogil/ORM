package daoModel;

import connection.Connection;
import utilities.Utilities;
import java.util.Iterator;

public class InmuebleDAO {

    public Utilities utilities = new Utilities();
    public Connection myConnection = new Connection();


    /*2a) Listar todos los inmuebles libres o que su contrato venza en el presente mes, de una determinada
    zona que introducimos como parámetro.*/
    public Iterator listInmueblesZona(String zona){
        String hql = "FROM Inmueble i JOIN i.contratos c WHERE  i.estado = 0 AND " +
                "i.zona.nombre = :zona OR MONTH(c.fechaVencimiento) = MONTH(CURDATE() ) ) ";

        return utilities.stablishConnection(hql).setParameter("zona", zona).getResultList().iterator();
    }

    /*3ª) Incrementar el precio de los inmuebles de una zona cuyo nombre introducimos
    como parámetro.*/
    public void incrementarPrecio(String zona, double incremento) {
        String hql = "UPDATE Contrato c SET c.precio = c.precio + :incremento WHERE c.inmueble.zona.nombre= :zona";

        utilities.stablishConnection(hql).setParameter("zona", zona);
        utilities.stablishConnection(hql).setParameter("incremento", incremento);

        utilities.connectionTransactionsUpdate(hql);
    }



}
