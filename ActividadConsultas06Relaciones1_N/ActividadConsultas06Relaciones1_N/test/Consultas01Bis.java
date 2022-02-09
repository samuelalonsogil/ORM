package ActividadConsultas06Relaciones1_N.test;

import ActividadConsultas06Relaciones1_N.modeloDAO.*;
import ActividadConsultas06Relaciones1_N.modeloVO.*;

import java.util.Iterator;
import java.util.List;

public class Consultas01Bis {

    public static void main(String[] args) {
        //listado inmuebles
        //consultas01();

        //listado del inquilino de codigo 12345678G
        //consulta02();

        //seleccionar columnas
        //listar el nombre, apellidos y teléfono de los propietarios
        //consulta03();

        //campos calculadors
        //listar código del contrato, precio, precio*0.21, precio*1.21
        consulta04();


    }

    private static void consulta04() {
        //select cocodContrato, coprecio, coprecio*0.21, coprecio*1.21 from contratos
        Iterator iterator = ContratoDao.listarPrecios();

        while (iterator.hasNext()) {
            Object[] fila = (Object[]) iterator.next();
            System.out.println(fila[0] + "\t" + fila[1] + "\t" + fila[2]+ "\t" + fila[3]);
        }
    }

    private static void consulta03() {
        //SELECT prNombre, prApellidos, prTelefono from propietarios
        /*siempre que devolvamos columnas lo devolvemos en un iterator
         * siempre utilizamos el while*/
        Iterator iterator = PropietarioDao.listarPropietarios();

        while (iterator.hasNext()) {
            Object[] fila = (Object[]) iterator.next();
            System.out.println(fila[0] + "\t" + fila[1] + "\t" + fila[2]);
        }
    }

    private static void consulta02() {
        Inquilino inquilino = InquilinoDao.buscarInquilino("12345678G");
        System.out.println(inquilino);

        //me visualiza la lista de contratos de ese inquilino
        for (Contrato c : inquilino.getContratos()) {
            System.out.println(c);
        }
    }

    private static void consultas01() {
        List<Inmueble> inmuebles = InmuebleDao.listadoInmuebles();

        for (Inmueble in : inmuebles) {
            System.out.println(in);
            System.out.println(in.getCodInmueble() + "\t" + in.getDireccion() + "\t" +
                    in.getZona().getNombre() + "\t" + in.getPropietario().getApellidos()
                    + "\t" + in.getPropietario().getNombre());
        }
    }

    public static void consulta08(){
    }

    public static void consulta10(){

    }

    public static void consulta09(){
        List<Inmueble>inmuebles=InmuebleDao.listadoInmueblesLibresZona(IntroducirDatos.introducirDatos("Nombre de la zona a buscar: "));

        for(Inmueble inmu:inmuebles){
            System.out.println(inmu);
        }
    }
}
