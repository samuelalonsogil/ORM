package daoModel;

import connection.Connection;
import utilities.Utilities;
import voModel.Inmueble;

import java.util.Iterator;

public class InmuebleDAO {

    public Utilities utilities = new Utilities();
    public Connection myConnection = new Connection();

    /*2a) Listar todos los inmuebles libres o que su contrato venza en el presente mes, de una determinada
    zona que introducimos como parámetro.*/
    public Iterator listInmueblesZona(String zona){
        String hql = "FROM Inmueble i JOIN Contrato c ON i.codInmueble = c.inmueble WHERE i.estado = false AND " +
                "i.zona.nombre = :zona OR (MONTH(c.fechaVencimiento) = MONTH(CURDATE() ) ) ";

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

    /*4ª) Listar los inmuebles libres o cuya fecha de vencimiento sea el presente mes,
            mostrando el código, la dirección, la fecha de vencimiento, el nombre de y el teléfono del propietario.*/
    public Iterator listContratosVencimientoMesActual(){
        String hql = "SELECT c.inmueble.codInmueble, c.inmueble.direccion, c.fechaVencimiento, c.inmueble.propietario.nombre," +
                "c.inmueble.propietario.telefono FROM Contrato c WHERE c.inmueble.estado = 0 OR " +
                "MONTH(c.fechaVencimiento) = MONTH(CURRENT_DATE )";
        return utilities.stablishConnectionIterator(hql);
    }


    public Inmueble findInmueble(String codInmueble) {
        return myConnection.getConnection().find( Inmueble.class, codInmueble );
    }

    /*11º) Listar para cada inquilino el número de inmuebles diferentes que nos ha alquilado.*/
    public Iterator listDifferentNumInmuebles(){
        String hql = "SELECT c.inquilino.dni, c.inquilino.nombre, COUNT(DISTINCT c.inmueble.codInmueble) FROM Contrato c" +
                "GROUP BY c.inquilino.dni";
        return utilities.stablishConnectionIterator(hql);
    }
}
