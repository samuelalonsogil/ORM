package tests;

import daoModel.VehiculoDAO;
import utilities.Utilities;

public class Query11 {
    VehiculoDAO vehiculoDAO = new VehiculoDAO();
    Utilities utilities = new Utilities();

    public void actualizarPrecioMarca(){
        vehiculoDAO.actualizarPrecioAlquileres(utilities.introduceDataInt("Introduce el nuevo precio: "),
                utilities.introduceData("Introduce la marca: "));
        }

    public static void main(String[] args) {
        Query11 query11 = new Query11();
        query11.actualizarPrecioMarca();
    }
}
