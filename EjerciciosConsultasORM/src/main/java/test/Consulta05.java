package test;

import daoModel.ContratoDAO;
import utilities.Utilities;
import voModel.Contrato;
import voModel.Inquilino;

public class Consulta05 {

    public Contrato contrato = new Contrato();
    public ContratoDAO contratoDAO = new ContratoDAO();
    public Utilities utilities;
    public Inquilino inquilino = new Inquilino();
    public InquilinoDAO inquilinoDAO = new InquilinoDAO();

    public void consulta05(){
        String numContrato = utilities.introduceData();
        if (contratoDAO.findContrato(numContrato ) == null){
            contrato.setCodContrato(numContrato);
            inquilino =
        }
    }

    public static void main(String[] args) {

    }

}
