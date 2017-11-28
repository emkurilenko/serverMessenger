import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectDB {
    private final String URL =  "jdbc:mysql://localhost:3306/Messenger?autoReconnect=true&useSSL=false";
    private final String USER = "root";
    private final String PASSWORD = "root";
    Connection connection;

    public Connection getConnection() {
        return connection;
    }

    public ConnectDB() {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(URL,USER,PASSWORD);
            if(!connection.isClosed())
                System.out.println("CONNECTED");
        }
        catch (Exception e){
            System.out.println("ERROR CONNECTION");
        }
    }
}
