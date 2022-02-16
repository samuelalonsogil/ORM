package test;

import daoModel.InquilinoDAO;
import voModel.Inquilino;

import java.util.List;

public class DeleteInquilinos {
    public InquilinoDAO inquilinoDAO = new InquilinoDAO();

    public void query08(){
        List<Inquilino> inquilinos =inquilinoDAO.listadoInquilinoSinContrato();
        System.out.println(inquilinos);
        inquilinoDAO.deleteInquilinosSinContrato();
        System.out.println(inquilinos);
    }

    public static void main(String[] args) {
        DeleteInquilinos deleteInquilinos = new DeleteInquilinos();
        deleteInquilinos.query08();
    }
}
