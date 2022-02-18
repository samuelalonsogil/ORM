import daoModel.VehiculoDAO;
import voModel.Vehiculo;
import java.util.List;

public class ListarVehiculosGrupos {
    public VehiculoDAO vehiculoDAO = new VehiculoDAO();

    public void listarVehiculosGrupos(){
        List<Vehiculo> vehiculos = vehiculoDAO.generateListVehiculoGroups();
        for(Vehiculo vehiculo:vehiculos){
            System.out.println(vehiculo.getMatricula() + " " + vehiculo.getGrupo());
        }
    }

    public static void main(String[] args) {
        ListarVehiculosGrupos listarVehiculosGrupos = new ListarVehiculosGrupos();
        listarVehiculosGrupos.listarVehiculosGrupos();
    }
}
