package test;

import daoModel.ContratoDAO;
import utilities.TransformDates;
import utilities.Utilities;
import voModel.Contrato;
import java.text.ParseException;

public class ActualizeContractDate {
    public Utilities utilities;
    public Contrato contrato;
    public ContratoDAO contratoDAO;
    public TransformDates transformDates;

    public static void main(String[] args) throws ParseException {
        ActualizeContractDate test01 = new ActualizeContractDate();
        test01.actualizeDateContract();
    }

    public void initVariables(){
        utilities = new Utilities();
        contrato = new Contrato();
        contratoDAO = new ContratoDAO();
        transformDates = new TransformDates();
    }

    /*ejercicio 01*/
    public void actualizeDateContract() throws ParseException {
        initVariables();

        contrato = contratoDAO.findContrato(utilities.introduceData("code contrato: ") );

        if (contrato!=null){
            contrato.setFechaVencimiento( transformDates.StringToDate( utilities.introduceData("new date: ") ) );
            contratoDAO.modifyContract(contrato);

            System.out.println("Date actualized");
        }else{
            System.out.println("No contract found");
        }
    }
}
