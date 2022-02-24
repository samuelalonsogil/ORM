package test;

import daoModels.AsientoDAO;
import daoModels.ClienteDAO;
import daoModels.TarjetaEmbarqueDAO;
import daoModels.VueloDAO;
import utilities.TransformDates;
import utilities.Utilities;
import voModels.Asiento;
import voModels.Cliente;
import voModels.TarjetaEmbarque;
import voModels.Vuelo;

public class Query04 {

    public TarjetaEmbarque tarjetaEmbarque;
    public TarjetaEmbarqueDAO tarjetaEmbarqueDAO = new TarjetaEmbarqueDAO();
    public Utilities utilities = new Utilities();
    public ClienteDAO clienteDAO = new ClienteDAO();
    public Cliente cliente;
    public Asiento asiento = new Asiento();
    public AsientoDAO asientoDAO = new AsientoDAO();
    public Vuelo vuelo;
    public VueloDAO vueloDAO = new VueloDAO();
    public TransformDates transformDates = new TransformDates();

    public Cliente newCliente(String dni){
        cliente = new Cliente();
        cliente.setDni(dni);

        System.out.println("Introduce los datos del cliente nuevo: ");
        cliente.setNombre(utilities.introduceData("Introduce el nombre: "));
        cliente.setApellidos(utilities.introduceData("Introduce los apellidos: "));
        cliente.setDireccion(utilities.introduceData("Introduce la dirección: "));
        cliente.setNumTarjeta(utilities.introduceDataInt("Introduce el num de tarjeta: "));
        cliente.setTelefono(utilities.introduceDataInt("Introduce num tlf: ") );

        clienteDAO.newCliente(cliente);
        return cliente;
    }

    /*4º) Queremos sacar una tarjeta de embarque, para ello introduciremos el Nº de la tarjeta, el Nº
        de Vuelo, el nombre completo del pasajero y le asignamos un asiento. Actualizaremos las tablas
        necesarias.*/
    public void newTarjeta(){
        tarjetaEmbarque = new TarjetaEmbarque();

        System.out.println("Insertando nueva tarjeta de embarque: ");
        String dniPasajero = utilities.introduceData("Introduce el dni del pasajero");

        if (clienteDAO.findCliente(dniPasajero) == null ){
            cliente = newCliente(dniPasajero);
        }else{
            cliente = clienteDAO.findCliente(dniPasajero);
        }

        tarjetaEmbarque.setCliente(cliente);

        int codAsiento = utilities.introduceDataInt("Introduce code de asiento: ");
        if (asientoDAO.findAsiento(codAsiento) == null ){
            asiento = newAsiento(codAsiento);
        }else{
            asiento = asientoDAO.findAsiento(codAsiento);
        }

        tarjetaEmbarque.setAsiento(asiento);

        int codeVuelo = utilities.introduceDataInt("Introduce el code del vuelo: ");
        if (vueloDAO.findVuelo(codeVuelo) == null ) vuelo = newVuelo(codeVuelo);
        else vuelo = vueloDAO.findVuelo(codeVuelo);

        tarjetaEmbarque.setVuelo(vuelo);
        tarjetaEmbarque.setTeCodigo(utilities.introduceDataInt("Introduce el codigo de embarque"));

        tarjetaEmbarqueDAO.newTarjetaEmbarque(tarjetaEmbarque);
    }

    public Vuelo newVuelo(int codeVuelo) {
        vuelo = new Vuelo();
        vuelo.setCodigo(codeVuelo);

        System.out.println("Introduce los datos del vuelo: ");
        vuelo.setFechaSalida( transformDates.StringToDate( utilities.introduceData("Introduce la fecha de salida") ) );
        vuelo.setFechaLlegada( transformDates.StringToDate( utilities.introduceData("Introduce la fecha de llegada") ) );

        vueloDAO.newVuelo(vuelo);
        return  vuelo;
    }

    public Asiento newAsiento(int codAsiento) {
        asiento = new Asiento();
        asiento.setCodigo(codAsiento);

        System.out.println("Introduce los datos del asiento: ");
        asiento.setColumna(utilities.introduceDataInt("Introduce la columna: ") );
        asiento.setFila(utilities.introduceDataInt("Introduce la fila: "));
        asiento.setLibre(utilities.introduceDataBoolean("Introduce opción: (T para true y F para false)") );

        asientoDAO.newAsiento(asiento);
        return asiento;
    }

    public static void main(String[] args) {
        Query04 query04 = new Query04();
        query04.newTarjeta();
    }

}
