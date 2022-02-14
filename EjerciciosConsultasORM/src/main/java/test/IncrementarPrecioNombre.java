package test;

import daoModel.InmuebleDAO;
import utilities.Utilities;

public class IncrementarPrecioNombre {

    Utilities utilities = new Utilities();
    InmuebleDAO inmuebleDAO = new InmuebleDAO();

    public void increment(){
        String zona = utilities.introduceData();
        int incremento = utilities.introduceDataNums();
        inmuebleDAO.incrementarPrecio(zona, incremento);
    }

    public static void main(String[] args) {
        IncrementarPrecioNombre incrementar = new IncrementarPrecioNombre();
        incrementar.increment();
    }
}
