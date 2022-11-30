import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;

public class DML_preparedStatement_transaction {
    public static void main(String[] args) {

        String insert = "";

        Connection connection = new JDBC_Connection().Create_JDBC_Connectio();
        PreparedStatement preparedStatement = null;

        try {
            connection.setAutoCommit(false);

            preparedStatement = connection.prepareStatement(insert);

            preparedStatement.setString(1, "dgr");
            preparedStatement.setString(2, "dgr");
            preparedStatement.setString(3, "dgr");
            System.out.println(preparedStatement.executeUpdate());

            connection.commit();

            preparedStatement.close();
        } catch (SQLException e) {

            if (connection != null) {
                try {
                    connection.rollback();
                    System.out.println("rollback");
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        }

        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
