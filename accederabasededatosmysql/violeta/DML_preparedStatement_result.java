package accederabasededatosmysql.violeta;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import java.sql.ResultSet;

import java.sql.PreparedStatement;

public class DML_preparedStatement_result {

    static String selectTBLAlumne = "";

    public static void main(String[] args) {
        Connection connection = new JDBC_Connection().Create_JDBC_Connectio();
        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = connection.prepareStatement(selectTBLAlumne);

            preparedStatement.setInt(1, 2);

            ResultSet resultSet = preparedStatement.executeQuery();

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

            preparedStatement.close();
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
