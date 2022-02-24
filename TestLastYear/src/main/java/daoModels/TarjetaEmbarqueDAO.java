package daoModels;

import connection.Connection;
import utilities.Utilities;
import voModels.TarjetaEmbarque;

public class TarjetaEmbarqueDAO {

    public Connection myConnection = new Connection();
    public TarjetaEmbarque tarjetaEmbarque;
    public Utilities utilities = new Utilities();

    /*4º) Queremos sacar una tarjeta de embarque, para ello introduciremos el Nº de la tarjeta, el Nº
        de Vuelo, el nombre completo del pasajero y le asignamos un asiento. Actualizaremos las tablas
        necesarias.*/
    public TarjetaEmbarque findTarjetaEmbarque(String code){
        return myConnection.getConnection().find(TarjetaEmbarque.class, code);
    }

    public void newTarjetaEmbarque(TarjetaEmbarque tarjetaEmbarque){
        utilities.connectionTransactions(tarjetaEmbarque);
    }

}
