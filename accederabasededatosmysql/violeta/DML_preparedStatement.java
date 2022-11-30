package accederabasededatosmysql.violeta;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;

public class DML_preparedStatement {

    static String insertTBLAlumne = "";

    public static void main(String[] args) {
        Connection connection = new JDBC_Connection().Create_JDBC_Connectio();
        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = connection.prepareStatement(insertTBLAlumne);

            preparedStatement.setString(1, "44444444-C");
            preparedStatement.setString(2, "Ruth");
            preparedStatement.setInt(3, 3);

            System.out.println(preparedStatement.executeUpdate());

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
