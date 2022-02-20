package tests;

import daoModel.VehiculoDAO;
import voModel.Vehiculo;
import java.util.List;

public class Query01 {
    public VehiculoDAO vehiculoDAO = new VehiculoDAO();

    public void listarVehiculosGrupos(){
        List<Vehiculo> vehiculos = vehiculoDAO.generateListVehiculoGroups();
        for(Vehiculo vehiculo:vehiculos){
            System.out.println("matrícula: " + vehiculo.getMatricula() + "\ngrupo: " + vehiculo.getGrupo());
        }
    }

    /*test 01*/
    public static void main(String[] args) {
        Query01 listarVehiculosGrupos = new Query01();
        listarVehiculosGrupos.listarVehiculosGrupos();
    }
}
