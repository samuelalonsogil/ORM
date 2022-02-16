package test;

import daoModel.ContratoDAO;
import daoModel.InmuebleDAO;
import daoModel.InquilinoDAO;
import utilities.TransformDates;
import utilities.Utilities;
import voModel.Contrato;
import voModel.Inmueble;
import voModel.Inquilino;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class InsertContrato05 {


    public ContratoDAO contratoDAO = new ContratoDAO();
    public Utilities utilities = new Utilities();
    public InquilinoDAO inquilinoDAO = new InquilinoDAO();
    public InmuebleDAO inmuebleDAO = new InmuebleDAO();
    public TransformDates transformDates = new TransformDates();


    public void consulta05() {
        Contrato contrato = new Contrato();
        Inquilino inquilino;

        String codContrato = utilities.introduceData("code contrato: ");

        if ( contratoDAO.findContrato(codContrato) == null){
            contrato.setCodContrato(codContrato);
            inquilino = inquilinoDAO.findInquilino(utilities.introduceData("dni inquilino: ") );

            if (inquilino!=null){
                contrato.setInquilino(inquilino);
                Inmueble inmueble = inmuebleDAO.findInmueble( utilities.introduceData("code inmueble: ") );

                if (inmueble!=null){
                    contrato.setInmueble(inmueble);

                    String today = new SimpleDateFormat("dd/MM/yyyy").format(Calendar.getInstance().getTime());
                    contrato.setFechaContrato(transformDates.StringToDate(today) );

                    Date fecha = transformDates.incrementYears(transformDates.StringToDate(today), 4);
                    contrato.setFechaVencimiento(fecha);
                    contrato.setPrecio(utilities.introduceDataDouble("price: ") );
                }else{
                    System.out.println("Inmueble inexistente");
                }
            }else{
                System.out.println("Inquilino inexistente");
            }
        }else{
            System.out.println("Contrato existente");
        }
        contratoDAO.newContrato(contrato);
    }

    public static void main(String[] args) {
        InsertContrato05 insertContrato05 = new InsertContrato05();
        insertContrato05.consulta05();

    }

}
