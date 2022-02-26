package test;

import daoModel.DepartamentoDAO;
import utilities.Utilities;

import java.util.Locale;

public class Query08 {
    Utilities utilities = new Utilities();
    DepartamentoDAO departamentoDAO = new DepartamentoDAO();

    public void deleteVehiculos(){
        departamentoDAO.deleteDepartamento(utilities.introduceData("Introduce el nomrbe del departamento: ").toUpperCase(Locale.ROOT));
    }

    public static void main(String[] args) {
        Query08 query08 = new Query08();
        query08.deleteVehiculos();
    }
}
