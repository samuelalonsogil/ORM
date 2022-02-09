package test;

import modelDAO.ContratoDAO;
import modelDAO.EquipoDAO;
import modelDAO.FutbolistaDAO;
import modelVO.Contrato;
import modelVO.Equipo;
import modelVO.Futbolista;
import utilities.IntroduceData;

import java.time.Year;

public class Test01 {
    public static void main(String[] args) {
        int opcion;
        do {
            System.out.println("1-- Nuevo Equipo");
            System.out.println("2-- Nuevo Futbolista");
            System.out.println("3-- Nuevo Contrato");
            System.out.println("4-- Salir");
            opcion = Integer.parseInt(IntroduceData.introduceData("Elegir opcion: "));

            switch (opcion) {
                case 1:
                    nuevoEquipo();
                    break;
                case 2:
                    nuevoFutbolista();
                    break;
                case 3:
                    nuevoContrato();
                    break;
                case 4:
                    System.exit(0);
                default:
            }
        } while (opcion != 5);
    }

    private static void nuevoContrato() {
        Contrato contrato = new Contrato();
        contrato.setNumContrato(Integer.parseInt("Num contrato: "));

        Equipo equipo = EquipoDAO.buscarEquipo(IntroduceData.introduceData("Nombre Equipo: "));

        Futbolista futbolista = FutbolistaDAO.findFootballPlayer(
                Integer.parseInt(IntroduceData.introduceData("Num Ficha: ")));

        if (futbolista != null && equipo != null) {
            contrato.setFutb(futbolista);
            contrato.setEquip(equipo);
            ContratoDAO.nuevoContrato(contrato);
        } else {
            System.out.println("El futbolista o el equipo no existe, hay que darlo de alta");
        }
    }

    private static void nuevoEquipo() {
        String eqNombre = IntroduceData.introduceData("Nombre del equipo: ");
        Equipo equipo = EquipoDAO.buscarEquipo(eqNombre);

        if (equipo == null) {
            equipo = new Equipo();
            equipo.setNombre(eqNombre);
            equipo.setPrsidente(IntroduceData.introduceData("Presidente: "));
            equipo.setEstadio(IntroduceData.introduceData("Estadio: "));
            equipo.setAnhoFundacion(Year.of(Integer.parseInt(IntroduceData.introduceData("Anho fundación: "))));
            equipo.setNumSocios(Integer.parseInt(IntroduceData.introduceData("Número de socios: ")));

            EquipoDAO.newTeam(equipo);
        }
    }

    private static void nuevoFutbolista() {
       /* Futbolista futbolista = new Futbolista(Integer.parseInt(IntroducirDatos.introducirDatos("Num ficha: ")),
                IntroducirDatos.introducirDatos("Nombre futbolista: "),
                IntroducirDatos.introducirDatos("Apellidos futbolista: "),
                ConvertirFechas.convertirStringDate(IntroducirDatos.introducirDatos("FechaNacmi: ")),
                Double.parseDouble(IntroducirDatos.introducirDatos("Peso futbolista: ")),
                Integer.parseInt(IntroducirDatos.introducirDatos("Altura futbolista: ")),
                Integer.parseInt(IntroducirDatos.introducirDatos("Sueldo futbolista: ")));

        FutbolistaDao.nuevoFutbolista(futbolista);*/

    }
}
