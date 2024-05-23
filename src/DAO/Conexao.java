// Classe para gerenciar conexão com banco de dados PostgreSQL
package DAO;

import java.sql.Connection; // Importa classe de conexão JDBC
import java.sql.SQLException; // Importa classe de exceção SQL
import java.sql.DriverManager; // Importa classe para gerenciar drivers JDBC

/**
 *
 * @author Rafael Becsei
 */

public class Conexao {
    // Método para obter uma conexão com o banco de dados
    public Connection getConnection() throws SQLException {
        // Estabelece conexão com o banco de dados PostgreSQL
        Connection conexao = DriverManager.getConnection(
            "jdbc:postgresql://localhost:5432/pessoas",
                "postgres", "fei");
        return conexao; 
    }
}
