package tests;

import daoModel.VehiculoDAO;
import utilities.Utilities;
import voModel.Vehiculo;

import java.util.List;
import java.util.Locale;

public class Query10 {
    VehiculoDAO vehiculoDAO = new VehiculoDAO();
    Utilities utilities = new Utilities();

    public void listarVehiculosMatriculaLetras(){
        List<Vehiculo> vehiculos = vehiculoDAO.listVehiculosMatriculaLetrasPorTeclado( utilities.introduceData("Introduce las letras: ").toUpperCase(Locale.ROOT) );
        for(Vehiculo vehiculo:vehiculos){
            System.out.println("matricula: " + vehiculo.getMatricula() + "marca: " + vehiculo.getMarca() );
        }
    }

    /*test 10*/
    public static void main(String[] args) {
        Query10 query10 = new Query10();
        query10.listarVehiculosMatriculaLetras();
    }
}
