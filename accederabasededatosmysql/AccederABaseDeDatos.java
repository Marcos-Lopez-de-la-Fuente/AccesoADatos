package accederabasededatosmysql;

import java.sql.*;

public class AccederABaseDeDatos {

    private Connection connection;

    public AccederABaseDeDatos(String driver, String url, String user, String password) {

        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            this.setConnection(DriverManager.getConnection(url, user, password));
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {

        // ! Datos
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/violeta";
        String user = "root";
        String password = "";

        // ! Query
        // select * from alumnes
        // INSERT INTO `alumnes` (`id`, `dni_nie`, `nom`, `primer_llinatge`, `segon_llinatge`) VALUES (NULL, '123456789M', 'Marcos', 'Lopez', 'de la Fuente');
        String select = "select * from alumnes";
        String insert = "INSERT INTO `alumnes` (`id`, `dni_nie`, `nom`, `primer_llinatge`, `segon_llinatge`) VALUES (NULL, '123456789M', 'Marcos', 'Lopez', 'de la Fuente');";
        String query = select;


        /////////////////////////////////////////////////////////////////////////////////////////////////////////
        AccederABaseDeDatos aBaseDeDatos = new AccederABaseDeDatos(driver, url, user, password);

        try {

            if (query.split(" ")[0].equals("select")) {
                ResultSet resultSet = aBaseDeDatos.getConnection().createStatement().executeQuery(query);
                aBaseDeDatos.printSelect(resultSet);

            } else {
                aBaseDeDatos.getConnection().createStatement().executeUpdate(query);

            }

            aBaseDeDatos.getConnection().close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
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
