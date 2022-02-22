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
    public VehiculoCliente vehiculoCliente = new VehiculoCliente();
    public Cliente cliente = new Cliente();
    public Vehiculo vehiculo = new Vehiculo();
    public ClienteDao clienteDao = new ClienteDao();
    public VehiculoDAO vehiculoDAO = new VehiculoDAO();
    public Oficina oficina = new Oficina();
    public OficinaDAO oficinaDAO = new OficinaDAO();

    public void newAlquiler(){
        int codeAlquiler= utilities.introduceDataInt("Introduce code de alquiler: ");

        if (vehiculoClienteDAO.findAlquiler(codeAlquiler)==null){
            vehiculoCliente.setIdVehiculoCliente(codeAlquiler);
            cliente = clienteDao.findAlquiler(utilities.introduceData("Introduce el dni: "));
            if (cliente!=null){

                vehiculoCliente.setCliente(cliente);
                vehiculo = vehiculoDAO.findVehiculo(utilities.introduceData("Introduce la matrícula: "));
                if (vehiculo!=null){
                    vehiculoCliente.setVehiculo(vehiculo);
                    vehiculoCliente.setDias(utilities.introduceDataInt("Introduce los días: "));
                    vehiculoCliente.setPrecio(utilities.introduceDataInt("Introduce el precio: "));
                    vehiculoCliente.setSeguro(utilities.introduceData("Introduce el tipo de seguro: "));
                }else{
                    vehiculo = new Vehiculo();
                    System.out.println("Introduce los datos del vehiculo nuevo: ");
                    vehiculo.setEdad(utilities.introduceDataInt("Introduce edad: "));
                    vehiculo.setGrupo(Vehiculo.Grupo.valueOf(utilities.introduceData("Introduce grupo: ")));
                    vehiculo.setMatricula(utilities.introduceData("Introduce matricula: "));
                    vehiculo.setMarca(utilities.introduceData("Introduce marca: "));
                    vehiculo.setPlazas(utilities.introduceDataInt("Introduce plazas: "));
                    vehiculo.setPuertas(utilities.introduceDataInt("Introduce puertas: "));
                    vehiculo.setMaletero(utilities.introduceDataInt("Introduce capacidad maletero: "));
                    vehiculoDAO.newVehiculo(vehiculo);

                    oficina = oficinaDAO.findOficina(utilities.introduceDataInt("Introduce el id de la oficina") );
                    if(oficina!=null){
                        vehiculo.setOficina( oficina );
                    }else{
                        oficina = new Oficina();
                        vehiculo = new Vehiculo();
                        System.out.println("Oficina no existe, crea una: ");
                        oficina.setIdOficina(utilities.introduceDataInt("Introduce el id de la oficina"));
                        oficina.setCiudad(utilities.introduceData("Introduce la ciudad: "));
                        oficina.setCodigoPostal(utilities.introduceDataInt("Introduce code postal: "));
                        oficina.setTelefono(utilities.introduceDataInt("Introduce el tlf: "));
                        oficina.setDireccion(utilities.introduceData("introduce la dirección: "));
                        oficinaDAO.newOficina(oficina);
                        vehiculo.setOficina(oficina);
                    }



                    vehiculo.setVehiculoClientes( vehiculoCliente.getVehiculo().getVehiculoClientes() );
                }
            }else{
                cliente = new Cliente();
                vehiculoCliente = new VehiculoCliente();
                System.out.println("Introduce los datos del cliente nuevo: ");
                cliente.setDni(utilities.introduceData("Introduce un dni: "));
                cliente.setCiudad(utilities.introduceData("Introduce una ciudad: "));
                cliente.setCodigoPostal(utilities.introduceDataInt("Introduce code postal: "));
                cliente.setNombre(utilities.introduceData("Introduce un nombre: "));
                cliente.setNumTarjeta(utilities.introduceData("Introduce el num de tarjeta: "));
                cliente.setProvincia(utilities.introduceData("Introduce provincia: "));
                cliente.setTelefono(utilities.introduceDataInt("Introduce tlf: "));

                clienteDao.newCliente(cliente);
            }

            vehiculoClienteDAO.newAlquiler(vehiculoCliente);

        }else{
            System.out.println("Ya existe ese código");
        }
    }

    public static void main(String[] args) {
        Query05 query05 = new Query05();
        query05.newAlquiler();
    }
}
