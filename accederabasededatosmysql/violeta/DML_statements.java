package accederabasededatosmysql.violeta;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DML_statements {

    static String insertTBLInstitut = "INSERT INTO institut (nameInsti) VALUES ('CIFP Francesc de Borja Moll')";

    public static void main(String[] args) {
        Connection connection = new JDBC_Connection().Create_JDBC_Connectio();
        Statement statement = null;

        try {
            statement = connection.createStatement();

            
            System.out.println(statement.executeUpdate(DML_statements.insertTBLInstitut));

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
