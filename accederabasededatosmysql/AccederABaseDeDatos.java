package accederabasededatosmysql;

import static java.util.Map.entry;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class AccederABaseDeDatos {

    private Connection connection;

    public AccederABaseDeDatos(String driver, String url, String user, String password)
            throws ClassNotFoundException, SQLException {

        Class.forName(driver);

        this.setConnection(DriverManager.getConnection(url, user, password));
    }

    public AccederABaseDeDatos() {
    }

    public static void main(String[] args) {

        // ! Datos
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/violeta";
        String user = "root";
        String password = "";

        // ! Query
        String select = "select * from alumnes";
        String insert = "INSERT INTO `alumnes` (`id`, `dni_nie`, `nom`, `primer_llinatge`, `segon_llinatge`) VALUES (NULL, '123456789M', 'Marcos', 'Lopez', 'de la Fuente');";
        String query = select;

        /////////////////////////////////////////////////////////////////////////////////////////////////////////

        AccederABaseDeDatos aBaseDeDatos = new AccederABaseDeDatos();

        try {
            aBaseDeDatos = new AccederABaseDeDatos(driver, url, user, password);

            ///////////////////////////////////////////////////////////////////////////////////

            ResultSet resultSet = (ResultSet) aBaseDeDatos.executeQuery(query);
            aBaseDeDatos.printSelect(resultSet);

            ///////////////////////////////////////////////////////////////////////////////////

            // int rows = (int) aBaseDeDatos.executeQuery(query);
            // System.out.println(rows);

            aBaseDeDatos.getConnection().close();

        } catch (ClassNotFoundException e1) {
            e1.printStackTrace();
        } catch (SQLException e1) {
            e1.printStackTrace();
        }

    }

    public Object executeQuery(String query) throws SQLException {
        String firstWord = query.split(" ")[0].toUpperCase();
        Statement statement = this.getConnection().createStatement();

        Object respObject = new Object();

        switch (firstWord) {
            case "SELECT":
                respObject = statement.executeQuery(query);
                break;

            case "INSERT":
                respObject = statement.executeUpdate(query);
                break;

            case "UPDATE":
                respObject = statement.executeUpdate(query);
                break;

            case "DELETE":
                respObject = statement.executeUpdate(query);
                break;

            default:
                System.out.println("Consulta no permitida.");
                break;
        }

        return respObject;
    }

    // ! Print a Select
    public void printSelect(ResultSet resultSet) {
        try {
            int numColumns = resultSet.getMetaData().getColumnCount();

            for (int i = 1; i <= numColumns; i++) {
                if (i == numColumns) {
                    System.out.print(resultSet.getMetaData().getColumnName(i) + "\n\n");
                } else {
                    System.out.print(resultSet.getMetaData().getColumnName(i) + " | ");
                }
            }

            while (resultSet.next()) {

                for (int i = 1; i <= numColumns; i++) {
                    if (i == numColumns) {
                        System.out.print(resultSet.getObject(i) + "\n");
                    } else {
                        System.out.print(resultSet.getObject(i) + " | ");
                    }
                }

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // ! Getters y Setters
    /**
     * @return the connection
     */
    public Connection getConnection() {
        return connection;
    }

    /**
     * @param connection the connection to set
     */
    public void setConnection(Connection connection) {
        this.connection = connection;
    }

}
