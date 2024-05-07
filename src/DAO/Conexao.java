package DAO;
/**
 *
 * @author Rafael Becsei
 */
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;


public class Conexao {
    public Connection getConnection() throws SQLException{
        Connection conexao = DriverManager.getConnection(
        "jdbc:postgresql://localhost:5432/pessoas",
                "postgres", "fei");
        return conexao;
    }
}
