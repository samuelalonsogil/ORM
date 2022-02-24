package daoModels;

import utilities.Utilities;

import java.util.Iterator;

public class AvionDAO {

    public Utilities utilities = new Utilities();

    /*2º) Mostrar los aviones que no hayan realizado ningún vuelo desde la ciudad de Vigo.*/
    public Iterator listAvionesNoVuelos(){
        String hql = "SELECT av.codigo, av.modelo, vu.codigo, vu.origen.nombre FROM Avion av JOIN Vuelo vu ON av.codigo = vu.avion.codigo " +
                "WHERE vu.origen.codigo <> 100";
        return utilities.stablishConnectionIterator(hql);
    }
}
