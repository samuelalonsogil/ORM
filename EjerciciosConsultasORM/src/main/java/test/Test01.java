package test;

import daoModel.ContratoDAO;
import transformDateFormat.TransformDates;
import voModel.Contrato;

import java.text.ParseException;
import java.util.Scanner;

public class Test01 {
    public Scanner scanner = new Scanner(System.in);
    public Contrato contrato;
    public ContratoDAO contratoDAO;
    public TransformDates transformDates;

    public static void main(String[] args) throws ParseException {
        Test01 test01 = new Test01();
        test01.actualizeDateContract();
    }

    public String introduceData(){
        System.out.println("Introduce data: ");
        return scanner.next();
    }

    /*ejercicio 01*/
    public void actualizeDateContract() throws ParseException {
        contrato = contratoDAO.findContrato(introduceData() );

        if (contrato!=null){
            contrato.setFechaVencimiento( transformDates.StringToDate( introduceData() ) );
            contratoDAO.modifyContract(contrato);

            System.out.println("Date actualized");
        }else{
            System.out.println("No contract found");
        }
    }
}
