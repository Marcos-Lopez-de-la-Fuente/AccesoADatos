package accederabasededatosmysql;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.sql.Connection;
import java.sql.ResultSet;

public class ActividadDeAmpliacion {

    private Connection connection;

    public ActividadDeAmpliacion(String driver, String url, String user, String password) {
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            this.connection = DriverManager.getConnection(url, user, password);
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

        ActividadDeAmpliacion actividadDeAmpliacion = new ActividadDeAmpliacion(driver, url, user, password);

        ///////////////////////////////////////////////////////////////////////////

        String insert1 = "INSERT INTO alumnes VALUES (?, ?, ?, ?, ?);";
        String insert2 = "INSERT INTO cicle VALUES (?, ?, ?, ?);";
        String select = "SELECT * FROM alumnes;";

        try {

            PreparedStatement preparedStatement1 = actividadDeAmpliacion.connection.prepareStatement(insert1);
            PreparedStatement preparedStatement2 = actividadDeAmpliacion.connection.prepareStatement(insert2);
            PreparedStatement preparedStatement3 = actividadDeAmpliacion.connection.prepareStatement(select);

            // Necesario para que no haga un Commit por cada "executeUpdate()"
            actividadDeAmpliacion.connection.setAutoCommit(false);

            preparedStatement1.setNull(1, Types.NULL);
            preparedStatement1.setString(2, "333333333333K");
            preparedStatement1.setString(3, "Pepe");
            preparedStatement1.setString(4, "de la Fuente");
            preparedStatement1.setString(5, "Torres");
            preparedStatement1.executeUpdate();

            preparedStatement2.setString(0, "1422");
            preparedStatement2.setString(2, "FPGS");
            preparedStatement2.setString(3, "DAM");
            preparedStatement2.setString(4, "Desarrollo de Aplicaciones Multiplataforma");
            preparedStatement2.executeUpdate();

            ResultSet resultSet = preparedStatement3.executeQuery();
            if (!resultSet.next()) {
                System.out.println("empty table");

            } else {

                do {
                    System.out.println("id: " + resultSet.getInt("id") + "\t"); // Salto de línea
                    System.out.println("dni_nie: " + resultSet.getString("dni_nie") + "\t");
                    System.out.println("nom: " + resultSet.getString("nom") + "\t");
                    System.out.println("primer_llinatge: " + resultSet.getString("primer_llinatge") + "\t");
                    System.out.println("segon_llinatge: " + resultSet.getString("segon_llinatge"));
                } while (resultSet.next());
            }

            // Aquí se modificará la BBDD
            actividadDeAmpliacion.connection.commit();

        } catch (SQLException e) {
            e.printStackTrace();

            try {
                if (actividadDeAmpliacion.connection != null) {
                    System.out.println("Transacción is being rolled back");
                    actividadDeAmpliacion.connection.rollback();

                }
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }
    }

}
