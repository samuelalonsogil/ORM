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

    public Contrato contrato = new Contrato();
    public ContratoDAO contratoDAO = new ContratoDAO();
    public Utilities utilities = new Utilities();
    public Inquilino inquilino = new Inquilino();
    public InquilinoDAO inquilinoDAO = new InquilinoDAO();
    public InmuebleDAO inmuebleDAO = new InmuebleDAO();
    public TransformDates transformDates = new TransformDates();


    public void consulta05() throws ParseException {
        String numContrato = utilities.introduceData();
        if (contratoDAO.findContrato(numContrato ) == null){
            contrato.setCodContrato(numContrato);
            inquilino = inquilinoDAO.findInquilino(numContrato);
            if (inquilino!=null){
                contrato.setInquilino(inquilino);
                String codInmueble = utilities.introduceData();
                Inmueble inmueble = inmuebleDAO.findInmueble(codInmueble);
                if (inmueble!=null){
                    contrato.setInmueble(inmueble);

                    String hoy = new SimpleDateFormat("dd//MM/yyyy").format(Calendar.getInstance().getTime());
                    contrato.setFechaContrato(transformDates.StringToDate(hoy) );
                    Date fecha = transformDates.sumarAnhos(transformDates.StringToDate(hoy), 4);
                    contrato.setFechaVencimiento(fecha);
                    contrato.setPrecio(utilities.introduceDataDouble() );
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

    public static void main(String[] args) throws ParseException {
        InsertContrato05 insertContrato05 = new InsertContrato05();
        try {
            insertContrato05.consulta05();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

}
