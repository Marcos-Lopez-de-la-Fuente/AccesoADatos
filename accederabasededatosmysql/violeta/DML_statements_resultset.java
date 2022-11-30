package accederabasededatosmysql.violeta;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import java.sql.ResultSet;

public class DML_statements_resultset {
    static String selectInstitut = "SELET * FROM institut;";

    public static void main(String[] args) {
        Connection connection = new JDBC_Connection().Create_JDBC_Connectio();
        Statement statement = null;

        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(selectInstitut);

            // ! Comprobar si el resultSet está vacío
            if (!resultSet.next()) {
                System.out.println("empty table");

                // ! Si el ResultSet tiene información
            } else {

                // Necesario para que empiece por la primera Row
                do {
                    System.out.println("idInsti: " + resultSet.getInt("idInsti") + "\t"); // Salto de línea
                    System.out.println("nameInsti: " + resultSet.getString("nameInsti"));
                } while (resultSet.next());

            }

            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
