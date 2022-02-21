package tests;

import utilities.Utilities;

public class MasterQuery {
    public Utilities utilities = new Utilities();
    public Query01 query01;
    public Query02 query02;
    public Query03 query03;
    public Query04 query04;
    public Query05 query05;
    public Query06 query06;
    public Query07 query07;
    public Query08 query08;
    public Query09 query09;
    public Query10 query10;
    public Query11 query11;
    public Query12 query12;

    public void chooseQuery(){
        int chooser = utilities.introduceDataInt("Escoge la opción 1 a 12");
        switch (chooser){
            case 1: query01 = new Query01();
                query01.listarVehiculosGrupos();
                break;

            case 2: query02 = new Query02();
                query02.listarVehiculosDiasYprecioTotal();
                break;

            case 3: query03 = new Query03();
                query03.listarVehiculosSinAlquilar();
                break;

            case 4: query04 = new Query04();
                query04.listAlquileresPorMatricula();
                break;

            case 5: query05 = new Query05();
                query05.newAlquiler();
                break;

            case 6: query06 = new Query06();
                query06.listAlquileresOrderedBy();
                break;

            case 7: query07 = new Query07();
                query07.listarVehiculosPuertasMaletero();
                break;

            case 8: query08 = new Query08();
                query08.listarClientesPorLetra();
                break;

            case 9: query09 = new Query09();
                query09.listCocheMasCaro();
                break;

            case 10: query10 = new Query10();
                query10.listarVehiculosMatriculaLetras();
                break;

            case 11: query11 = new Query11();
                query11.actualizarPrecioMarca();
                break;

            case 12: query12 = new Query12();
                query12.deleteVehiculos();
                break;

            default:
                System.out.println("Opción inválida");
        }
    }

    public static void main(String[] args) {
        MasterQuery masterQuery = new MasterQuery();
        masterQuery.chooseQuery();
    }
}
