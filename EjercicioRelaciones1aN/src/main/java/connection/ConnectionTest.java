package connection;

public class ConnectionTest {
    public static void main(String[] args) {

        Connection connection = new Connection();

        if(Connection.getConnection() != null) {
            System.out.println("Conexion ok");
        }else
            System.out.println("Error");
        Connection.disconnect();
    }
}
