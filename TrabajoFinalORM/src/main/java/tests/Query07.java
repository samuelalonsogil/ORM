package tests;

import daoModel.VehiculoDAO;
import utilities.Utilities;
import voModel.Vehiculo;

import java.util.List;

public class Query07 {

    public Utilities utilities = new Utilities();
    public VehiculoDAO vehiculoDAO = new VehiculoDAO();

    public void listarVehiculosPuertasMaletero(){
        List<Vehiculo> vehiculos = vehiculoDAO.listVehiculosPuertasMaletero(utilities.introduceDataInt("Introduce num puertas: "), utilities.introduceDataInt("Introduce capacidad maletero: ") );
        for(Vehiculo vehiculo:vehiculos){
            System.out.println( "matricula: " + vehiculo.getMatricula() + "\npuertas: " + vehiculo.getPuertas() + "\ncapacidad_maletero: " + vehiculo.getMaletero() +
                    "\n------------------------------------------------------");
        }
    }

    /*test 01*/
    public static void main(String[] args) {
        Query07 listVehiculosPuertasMaletero = new Query07();
        listVehiculosPuertasMaletero.listarVehiculosPuertasMaletero();
    }
}
