package tests;

import daoModel.VehiculoDAO;
import utilities.Utilities;

import java.util.Locale;

public class Query12 {
    Utilities utilities = new Utilities();
    VehiculoDAO vehiculoDAO = new VehiculoDAO();

    public void deleteVehiculos(){
        vehiculoDAO.deleteCochePorMatricula(utilities.introduceData("Introduce la maricula").toUpperCase(Locale.ROOT));
    }

    public static void main(String[] args) {
        Query12 query12 = new Query12();
        query12.deleteVehiculos();
    }
}
