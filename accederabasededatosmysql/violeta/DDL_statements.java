package accederabasededatosmysql.violeta;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DDL_statements {

    static String createTBLAlumnes = """
                create table alumne(
                    idAlumne int not null auto_increment,
                    dniAlumne varchar(10) not null, nameAlumne varchar(35) default null,
                    nameAlumne varchar(35) default null,
                    llinatge1Alumne varchar(35) default null,
                    llinatge2Alumne varchar(35) default null,
                    idInsti int not null,
                    primary key(idAlumne),
                    foreign key(idInsti) references institut (idInsti)
                );
            """;

    public static void main(String[] args) {
        Connection connection = new JDBC_Connection().Create_JDBC_Connectio();
        Statement statement = null;

        try {
            statement = connection.createStatement();

            // El método "execute()" devuelve "true" si es un ResultSet, si no es un
            // ResultSet devuelve "false"
            System.out.println(statement.execute(DDL_statements.createTBLAlumnes));

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
