package DAO;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import model.Investidor;


/**
 *
 * @author Rafael Becsei
 */

public class InvestidorDAO {
    private Connection conn;

    public InvestidorDAO(Connection conn) {
        this.conn = conn;
    }
    
    public ResultSet consultarSenha(Investidor investidor) throws SQLException {
        String sql = "SELECT * FROM pessoa WHERE cpf = ? AND senha = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, investidor.getCpf());
        stmt.setString(2, investidor.getSenha());
        return stmt.executeQuery();
    }
    
    public ResultSet consultar(Investidor investidor) throws SQLException{
        String sql = "select * from pessoa where cpf = ? and senha = ?";
        
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, investidor.getCpf());
        statement.setString(2, investidor.getSenha());
        statement.execute();
        ResultSet resultado = statement.getResultSet();
        return resultado;
    }
    
    private int gerarNovoId() throws SQLException {
    String sql = "select max(id) from pessoa";
    PreparedStatement statement = conn.prepareStatement(sql);
    ResultSet resultado = statement.executeQuery();
    int novoId = 1; 

    if (resultado.next()) {
        novoId = resultado.getInt(1) + 1;
    }

    return novoId;
    }
    
    public void inserir(Investidor investidor) throws SQLException {
    int novoId = gerarNovoId();
    
    String sql = "insert into pessoa (id, nome, cpf, senha, \"real\", \"bitcoin\", \"ethereum\", \"ripple\") "
            + "values (?, ?, ?, ?, 0.0, 0.0, 0.0, 0.0)";

    PreparedStatement statement = conn.prepareStatement(sql);
    statement.setInt(1, novoId);
    statement.setString(2, investidor.getNome());
    statement.setString(3, investidor.getCpf());
    statement.setString(4, investidor.getSenha());
    statement.executeUpdate();
    conn.close();
    }
    
    public void atualizardeposito(Investidor investidor) throws SQLException{
        String sql = "update pessoa set \"real\" = ? where cpf = ?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setDouble(1, investidor.getCarteira().getMoedas().get(0).getSaldo());
        statement.setString(2, investidor.getCpf());
        statement.executeUpdate();
        statement.execute();
        conn.close();
        
    
    
    }
    
    

   
}
