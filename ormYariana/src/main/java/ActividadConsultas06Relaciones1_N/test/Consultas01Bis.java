package ActividadConsultas06Relaciones1_N.test;

import ActividadConsultas06Relaciones1_N.conexion.Conexion;
import ActividadConsultas06Relaciones1_N.modeloDAO.ContratoDao;
import ActividadConsultas06Relaciones1_N.modeloDAO.InmuebleDao;
import ActividadConsultas06Relaciones1_N.modeloDAO.InquilinoDao;
import ActividadConsultas06Relaciones1_N.modeloDAO.PropietarioDao;
import ActividadConsultas06Relaciones1_N.modeloVO.Contrato;
import ActividadConsultas06Relaciones1_N.modeloVO.Inmueble;
import ActividadConsultas06Relaciones1_N.modeloVO.Inquilino;
import ActividadConsultas06Relaciones1_N.modeloVO.Propietario;
import Ejemplo04Relaciones1NBidireccionales.introducirDatos.IntroducirDatos;

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
        //consulta04();

        //Consulta que crea un objeto
        //listar dni y nombre de los inquilinos, creando un objeto
        //consulta05();

        //COnsultas de parámetros
        //Buscar los datos de un propietario cuyo DNI introducimos por teclado
        // SELECT * FROM propietarios where prDNI= ?
        //consulta06();

        //buscar los datos de los inquilinos con un salario entre dos valores
        //que introducimos por teclado
        //consulta07();

        //Listar dni, nombre, salario de los inquilinos creando una lista
        //consulta08();


        //Listado de los inmuebles libres de una determinada zona de la que sabemos el nombre
        //consulta09();

        //listado de los contratos mostrando el nombre del inquilino, nombre del propietario y el
        //nombre de la zona y dirección del inmueble
        //consulta10();

    }

    private static void consulta10() {

    }

    private static void consulta14() {
        Conexion conexion = new Conexion();
        String hql = "FROM Propietario p";

        List<Propietario> propietarios = PropietarioDao.
    }

    private static void consulta13() {
        /*SELECT <oCodigo, zoNombre, COUNT(inCoodiigo) FROM Zonas JOIN Inmuebles ON zoCodigo = inCodZona
        GROUP BY zoCodigo, zoNombre*/

        Iterator iterator = InmuebleDao.contarInmbueblesZonas01();

        while(iterator.hasNext()){
            Object[] fila = (Object[]) iterator.next();
            System.out.println("Codigo: " + fila[0] + "\t" + "Zona: " + fila[1] + "\t" + "numCod: " + fila[2] + "\t" );
        }
    }

    /*listar precios mayor y menor, total de contratos y precios*/
    private static void consulta12() {
        //SELECT MAX(coPrecio), MIN(coPrecio), SUM(coPrecio) FROM Contratos;
        Iterator iterator = ContratoDao.listadoPreciosMaxMin();

        while (iterator.hasNext()){
            Object[] fila = (Object[]) iterator.next();
            double max = (double) fila[0];
            double min = (double) fila[1];
            double summ = (double) fila[2];
            double media = (double) fila[3];
            long cuenta = (long) fila[4];

            System.out.println(max + "\t" + max + "\t" + min + "\t" + summ + "\t" + media + "\t" +cuenta);
        }
    }

    private static void consulta09() {
        List<Inmueble> inmuebles = InmuebleDao.listadoInmueblesLibresZona(IntroducirDatos.introducirDatos("Nombre zona: "));
        for (Inmueble inmu : inmuebles) {
            System.out.println(inmu);
        }
    }

    private static void consulta08() {
        List<Object> listainquilinos = InquilinoDao.listadoCreandoLista();

        for (int i = 0; i < listainquilinos.size(); i++) {
            Object inqui = listainquilinos.get(i);
            System.out.println(inqui);
        }
    }

    private static void consulta07() {
        List<Inquilino> inquilinos = InquilinoDao.buscarCiudadSalario(
                Double.parseDouble(IntroducirDatos.introducirDatos("Sueldo menor: ")),
                Double.parseDouble(IntroducirDatos.introducirDatos("Sueldo mayor: "))
        );

        for (Inquilino inquilino : inquilinos) {
            System.out.println(inquilino);
        }
    }

    private static void consulta06() {
        String dni = IntroducirDatos.introducirDatos("DNI propietario a buscar: ");

        Propietario propietario = PropietarioDao.buscarPropietario(dni);

        System.out.println(propietario);

    }

    private static void consulta05() {
        List<Inquilino> inquilinos = InquilinoDao.listadoInquilinosObjetos();

        System.out.println(inquilinos);
        System.out.println("=====================================");
        for (Inquilino inquilino : inquilinos) {
            System.out.println(inquilino.getDni());
        }
    }

    private static void consulta04() {
        //select cocodContrato, coprecio, coprecio*0.21, coprecio*1.21 from contratos
        Iterator iterator = ContratoDao.listarPrecios();

        while (iterator.hasNext()) {
            Object[] fila = (Object[]) iterator.next();
            System.out.println(fila[0] + "\t" + fila[1] + "\t" + fila[2] + "\t" + fila[3]);
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
}
