package test;

import daoModel.ContratoDAO;
import voModel.Contrato;

import java.util.List;

public class InsertContratosVencen {
    public ContratoDAO contratoDAO;
    public Contrato contrato;

    public void insertContractsFinish(){
        contratoDAO = new ContratoDAO();
        contrato = new Contrato();

        List<Contrato> contratos = contratoDAO.createContratosVencen();
        for(Contrato contrato:contratos){
            System.out.println(contrato.getCodContrato() + " " + contrato.getInquilino().getNombre());
        }
    }

    public static void main(String[] args) {
        InsertContratosVencen insertContratosVencen = new InsertContratosVencen();
        insertContratosVencen.insertContractsFinish();
    }
}
