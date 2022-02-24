package tests;

import daoModel.ClienteDao;
import daoModel.OficinaDAO;
import daoModel.VehiculoClienteDAO;
import daoModel.VehiculoDAO;
import utilities.Utilities;
import voModel.Cliente;
import voModel.Oficina;
import voModel.Vehiculo;
import voModel.VehiculoCliente;


public class Query05 {

    public Utilities utilities = new Utilities();
    public VehiculoClienteDAO vehiculoClienteDAO = new VehiculoClienteDAO();
    public VehiculoCliente vehiculoCliente;
    public Cliente cliente = new Cliente();
    public Vehiculo vehiculo = new Vehiculo();
    public ClienteDao clienteDao = new ClienteDao();
    public VehiculoDAO vehiculoDAO = new VehiculoDAO();
    public Oficina oficina = new Oficina();
    public OficinaDAO oficinaDAO = new OficinaDAO();

    public Cliente newCliente(String dni){
        cliente = new Cliente();
        vehiculoCliente = new VehiculoCliente();

        System.out.println("Introduce los datos del cliente nuevo: ");
        cliente.setDni(utilities.introduceData("Introduce un dni: "));
        cliente.setCiudad(utilities.introduceData("Introduce una ciudad: "));
        cliente.setCodigoPostal(utilities.introduceDataInt("Introduce code postal: "));
        cliente.setDireccion(utilities.introduceData("Introduce la dirección: "));
        cliente.setNombre(utilities.introduceData("Introduce un nombre: "));
        cliente.setNumTarjeta(utilities.introduceData("Introduce el num de tarjeta: "));
        cliente.setProvincia(utilities.introduceData("Introduce provincia: "));
        cliente.setTelefono(utilities.introduceDataInt("Introduce tlf: "));

        clienteDao.newCliente(cliente);

        return cliente;
    }


    public Vehiculo newVehiculo(String matricula){
        vehiculo = new Vehiculo();
        vehiculo.setMatricula(matricula);

        System.out.println("Introduce los datos del vehiculo nuevo: ");
        vehiculo.setEdad(utilities.introduceDataInt("Introduce edad: "));
        vehiculo.setGrupo(Vehiculo.Grupo.valueOf(utilities.introduceData("Introduce grupo: ")));
        vehiculo.setMatricula(utilities.introduceData("Introduce matricula: "));
        vehiculo.setMarca(utilities.introduceData("Introduce marca: "));
        vehiculo.setPlazas(utilities.introduceDataInt("Introduce plazas: "));
        vehiculo.setPuertas(utilities.introduceDataInt("Introduce puertas: "));
        vehiculo.setMaletero(utilities.introduceDataInt("Introduce capacidad maletero: "));

        vehiculoDAO.newVehiculo(vehiculo);

        return  vehiculo;
    }


    public void newAlquiler(){

        vehiculoCliente = new VehiculoCliente();

        System.out.println("Insertando nuevo alquiler: ");

        String matricula = utilities.introduceData("Introduce la matrícula del vehículo: ");
        if (vehiculoDAO.findVehiculo( matricula ) == null ){
            vehiculo = newVehiculo(matricula);
        }else{
            vehiculo = vehiculoDAO.findVehiculo(matricula);
        }

        vehiculoCliente.setVehiculo(vehiculo);

        System.out.println("Introduce el cliente: ");

        String dniCliente = utilities.introduceData("Introduce el dni:");
        if (clienteDao.findAlquiler(dniCliente) == null ) cliente = newCliente(dniCliente);
        else cliente = clienteDao.findAlquiler(dniCliente);

        vehiculoCliente.setCliente(cliente);
        vehiculoCliente.setVehiculo(vehiculo);
        vehiculoCliente.setIdVehiculoCliente(utilities.introduceDataInt("IUntroduce el id del alquiler: "));
        vehiculoCliente.setDias(utilities.introduceDataInt("Introduce los días: "));
        vehiculoCliente.setPrecio(utilities.introduceDataInt("Introduce el precio: "));
        vehiculoCliente.setSeguro(utilities.introduceData("Introduce el tipo de seguro: "));

        vehiculoClienteDAO.newAlquiler(vehiculoCliente);

    }

    public static void main(String[] args) {
        Query05 query05 = new Query05();
        query05.newAlquiler();
    }
}
