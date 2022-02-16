package test;

import daoModel.ContratoDAO;
import voModel.Contrato;

import java.util.List;

public class MostExpensiveContrato {
    public ContratoDAO contratoDAO = new ContratoDAO();

    public void query09(){
    List<Contrato> contratos = contratoDAO.mostExpensiveContrato();
    for(Contrato contrato:contratos){
        System.out.println(contrato.getCodContrato() + " " + contrato.getInquilino().getNombre());
        }
    }

    public static void main(String[] args) {
        MostExpensiveContrato mostExpensiveContrato = new MostExpensiveContrato();
        mostExpensiveContrato.query09();
    }


}
