package test;

import conexion.Conexion;
import convertirFechasDate.ConvertirFechas;
import modeloDAO.ContratoDao;
import modeloDAO.EquipoDao;
import modeloDAO.FutbolistaDao;
import modeloVO.Contrato;
import modeloVO.Equipo;
import modeloVO.Futbolista;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

public class TestFutbol {
    public static void main(String[] args) {
        int opcion;
        do {
            System.out.println("1-- Nuevo Equipo");
            System.out.println("2.- Nuevo Futbolista");
            System.out.println("3.- Nuevo Contrato");
            System.out.println(("4.- Listado Equipos y sus jugadores"));
            System.out.println("5.- Listado Jugadores y sus contratos");
            System.out.println("6.- Listado Contratos");
            System.out.println("7.- Salir");
            opcion = Integer.parseInt(IntroducirDatos.introducirDatos("Elegir opción: "));

            switch(opcion){
                case 1:
                    nuevoEquipo();
                    break;
                case 2:
                    nuevoFutbolista();
                    break;
                case 3:
                   nuevoContrato01();
                    break;
                case 4:
              //      listadoEquipos();
                    break;
                case 5:
                //    listadoJugadores();
                    break;
                case 6:
              //      listadoContratos();
                    break;
                case 7:
                    System.exit(0);

            }


        }while(opcion != 5);
}

    private static void nuevoContrato01(){
        int numContrato = Integer.parseInt(IntroducirDatos.introducirDatos("Num contrato:"));
        Contrato contrato = ContratoDao.buscarContrato(numContrato);

        if (contrato == null) {
            contrato = new Contrato();
            contrato.setNumContrato(numContrato);
            contrato.setFecContrato(ConvertirFechas.convertirStringDate(IntroducirDatos.introducirDatos("Fecha del contrato:")));
            contrato.setDuracion(Integer.parseInt(IntroducirDatos.introducirDatos("Duración: ")));
            contrato.setFichaAnual(Integer.parseInt(IntroducirDatos.introducirDatos("Ficha anual: ")));
            contrato.setClausula(Integer.parseInt(IntroducirDatos.introducirDatos("Cláusula: ")));

            String nombreEquipo = IntroducirDatos.introducirDatos("Nombre del equipo: ");
            Equipo equipo = EquipoDao.buscarEquipo(nombreEquipo);

            if (equipo == null){
                System.out.println("Equipo no existe");
            }else{
                contrato.setEqui(equipo);

                int numFicha = Integer.parseInt(IntroducirDatos.introducirDatos("Nombre del jugador: "));
                Futbolista futbolista = FutbolistaDao.buscarFutbolista(numFicha);

                if (futbolista == null){
                    System.out.println("Futbolista no existe");
                }else{
                    contrato.setFutbol(futbolista);
                    ContratoDao.nuevoContrato01(contrato);

                }
            }




        }
    }

    private static Contrato buscarContrato01(int numContrato){
        Contrato contrato = Conexion.getConexion().find(Contrato.class,numContrato);
        Conexion.desconectar();
        return contrato;
    }





    private static void nuevoFutbolista() {
        int numFicha = Integer.parseInt(IntroducirDatos.introducirDatos("Numero de ficha:"));
        Futbolista futbolista = FutbolistaDao.buscarFutbolista(numFicha);

        if(futbolista == null) {
            futbolista = new Futbolista();
            futbolista.setNumFicha(numFicha);
            futbolista.setNombre(IntroducirDatos.introducirDatos("Nombre: "));
            futbolista.setApellidos(IntroducirDatos.introducirDatos("Apellidos: "));
            futbolista.setFecNacimiento(ConvertirFechas.convertirStringDate(IntroducirDatos.introducirDatos("FechaNacimiento: ")));
            futbolista.setAltura(Integer.parseInt(IntroducirDatos.introducirDatos("Altura:")));
            futbolista.setPeso(Double.parseDouble(IntroducirDatos.introducirDatos("Peso: ")));
            futbolista.setSueldo(Integer.parseInt(IntroducirDatos.introducirDatos("Sueldo: ")));

            FutbolistaDao.nuevoFutbolista(futbolista);
        }else
            System.out.println("Futbolista ya existe");

        }


    private static void nuevoEquipo() {

        String eqNombre = IntroducirDatos.introducirDatos("Nombre del equipo: ");
        Equipo equipo = EquipoDao.buscarEquipo(eqNombre);
        if(equipo == null){
            equipo = new Equipo();
            equipo.setNombre(eqNombre);
            equipo.setPresidente(IntroducirDatos.introducirDatos("Presidente: "));
            equipo.setEstadio(IntroducirDatos.introducirDatos("Estadio: "));
            equipo.setAnhoFundacion(Integer.parseInt(IntroducirDatos.introducirDatos("Anho fundacion: ")));
            equipo.setNumSocios(Integer.parseInt(IntroducirDatos.introducirDatos("Numero de socios: ")));

            EquipoDao.nuevoEquipo(equipo);
        }

    }
    }
