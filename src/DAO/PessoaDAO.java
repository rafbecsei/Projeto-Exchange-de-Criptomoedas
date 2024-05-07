package DAO;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import model.Pessoa;

/**
 *
 * @author Rafael Becsei
 */

public class PessoaDAO {
    private Connection conn;

    public PessoaDAO(Connection conn) {
        this.conn = conn;
    }
    
    public ResultSet consultar(Pessoa pessoa) throws SQLException{
        String sql = "select * from pessoa where cpf = ? and senha = ?";
        
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, pessoa.getCpf());
        statement.setString(2, pessoa.getSenha());
        statement.execute();
        ResultSet resultado = statement.getResultSet();
        return resultado;
    }
    
//    public void inserir(Pessoa pessoa) throws SQLException{
//        String sql = "insert into pessoa (id, nome, cpf, senha, "
//                + "\"real\", \"bitcoin\", \"ethereum\", \"ripple\") "
//                + "values ('" + pessoa.getNome() + "', '" + pessoa.getCpf() + "', '" + pessoa.getSenha() + "')";
//        PreparedStatement statement = conn.prepareStatement(sql);
//        statement.execute();
//        conn.close();
//    }
    
    private int gerarNovoId() throws SQLException {
    // Lógica para gerar um novo ID (por exemplo, contar o número de registros e adicionar 1)
    String sql = "select max(id) from pessoa";
    PreparedStatement statement = conn.prepareStatement(sql);
    ResultSet resultado = statement.executeQuery();
    int novoId = 1; // valor padrão caso não existam registros ainda

    if (resultado.next()) {
        novoId = resultado.getInt(1) + 1;
    }

    return novoId;
    }
    
    public void inserir(Pessoa pessoa) throws SQLException {
    // Gera um ID único para a nova pessoa
    int novoId = gerarNovoId();

    String sql = "insert into pessoa (id, nome, cpf, senha, \"real\", \"bitcoin\", \"ethereum\", \"ripple\") "
            + "values (?, ?, ?, ?, 0.0, 0.0, 0.0, 0.0)";

    PreparedStatement statement = conn.prepareStatement(sql);
    statement.setInt(1, novoId);
    statement.setString(2, pessoa.getNome());
    statement.setString(3, pessoa.getCpf());
    statement.setString(4, pessoa.getSenha());
//    statement.setDouble(5, pessoa.getReal());
//    statement.setDouble(6, pessoa.getBitcoin());
//    statement.setDouble(7, pessoa.getEthereum());
//    statement.setDouble(8, pessoa.getRipple());

    statement.executeUpdate();
    conn.close();
    }


    
//    public void remover(Aluno aluno) throws SQLException{
//        String sql = "delete from aluno where usuario = ?";
//        PreparedStatement statement = conn.prepareStatement(sql);
//        statement.setString(1,aluno.getUsuario());
//        statement.execute();
//        conn.close();
//        
//    }
    
//    public void atualizar (Pessoa pessoa) throws SQLException{
//        
//        String sql = "update aluno set senha = ? where cpf = ?";
//        PreparedStatement statement = conn.prepareStatement(sql);
//        statement.setString(1, pessoa.getSenha());
//        statement.setString(2, pessoa.getCpf());
//        statement.execute();
//        conn.close();
//    }
   
}
