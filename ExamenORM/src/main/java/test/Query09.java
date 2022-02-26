package test;

import daoModel.DepartamentoDAO;
import daoModel.EmpleadoDAO;
import utilities.Utilities;

public class Query09 {

    Utilities utilities = new Utilities();
    DepartamentoDAO departamentoDAO = new DepartamentoDAO();

    public void query09(){
        String departamento = utilities.introduceData("Nombre del departamento: : ");
        int incremento = utilities.introduceDataInt("incremento: ");
        departamentoDAO.incrementarSueldosEmpleados(departamento, incremento);
    }

    public static void main(String[] args) {
        Query09 query09 = new Query09();
        query09.query09();
    }
}
