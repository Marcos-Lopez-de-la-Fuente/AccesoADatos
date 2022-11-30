package accederabasededatosmysql.violeta;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;

public class JDBC_Connection {

    public Connection Create_JDBC_Connectio() {
        Connection connection = null;

        try {
            String bbdd = "docencia";
            String host = "localhost";
            String port = "3306";
            String user = "root";
            String password = "";
            String url = "jdbc:mysql://" + host + ":" + port + "/" + bbdd;

            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Connection successful");

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return connection;

    }

    public static void main(String[] args) {
        new JDBC_Connection();

    }
}
