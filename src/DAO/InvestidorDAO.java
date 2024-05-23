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
    
//    public ResultSet consultar(Investidor investidor) throws SQLException{
//        String sql = "select * from pessoa where cpf = ? and senha = ?";
//        PreparedStatement statement = conn.prepareStatement(sql);
//        statement.setString(1, investidor.getCpf());
//        statement.setString(2, investidor.getSenha());
//        statement.execute();
//        ResultSet resultado = statement.getResultSet();
//        return resultado;
//    }
    
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
        
        String sqlid = "select count(*) from pessoa";
        PreparedStatement stat = conn.prepareStatement(sqlid);
        ResultSet resultado = stat.executeQuery();

        int quantidade = 0;

        if (resultado.next()) {
            quantidade = resultado.getInt(1);
        }

        if (quantidade == 0) {
            double cotacaoBit = 341567.22;
            double cotacaoEth = 15830.59;
            double cotacaoRip = 2.68;
            
            

            String sql = "insert into pessoa (id, nome, cpf, senha, \"real\", "
                   + "\"bitcoin\", \"ethereum\", \"ripple\", \"cotacaoBit\", "
                   + "\"cotacaoEth\", \"cotacaoRip\") " 
                   + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, novoId);
            statement.setString(2, investidor.getNome());
            statement.setString(3, investidor.getCpf());
            statement.setString(4, investidor.getSenha());
            statement.setDouble(5, investidor.getCarteira().getMoedas().get(0).getSaldo());
            statement.setDouble(6, investidor.getCarteira().getMoedas().get(1).getSaldo());
            statement.setDouble(7, investidor.getCarteira().getMoedas().get(2).getSaldo());
            statement.setDouble(8, investidor.getCarteira().getMoedas().get(3).getSaldo());
            statement.setDouble(9, cotacaoBit);
            statement.setDouble(10, cotacaoEth);
            statement.setDouble(11, cotacaoRip);
            statement.executeUpdate();
            
        } else {
            String sqlCot = "SELECT \"cotacaoBit\", \"cotacaoEth\", "
                                    + "\"cotacaoRip\" FROM pessoa WHERE id = 1";
            PreparedStatement statementCot = conn.prepareStatement(sqlCot);
            ResultSet resultadoCotacoes = statementCot.executeQuery();
            if(resultadoCotacoes.next()){
                double cotacaoBit = resultadoCotacoes.getDouble("cotacaoBit");
                double cotacaoEth = resultadoCotacoes.getDouble("cotacaoEth");
                double cotacaoRip = resultadoCotacoes.getDouble("cotacaoRip");
                
                String sql = "insert into pessoa (id, nome, cpf, senha, \"real\", "
                   + "\"bitcoin\", \"ethereum\", \"ripple\", \"cotacaoBit\", "
                   + "\"cotacaoEth\", \"cotacaoRip\") " 
                   + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

                PreparedStatement statement = conn.prepareStatement(sql);
                statement.setInt(1, novoId);
                statement.setString(2, investidor.getNome());
                statement.setString(3, investidor.getCpf());
                statement.setString(4, investidor.getSenha());
                statement.setDouble(5, investidor.getCarteira().getMoedas().get(0).getSaldo());
                statement.setDouble(6, investidor.getCarteira().getMoedas().get(1).getSaldo());
                statement.setDouble(7, investidor.getCarteira().getMoedas().get(2).getSaldo());
                statement.setDouble(8, investidor.getCarteira().getMoedas().get(3).getSaldo());
                statement.setDouble(9, cotacaoBit);
                statement.setDouble(10, cotacaoEth);
                statement.setDouble(11, cotacaoRip);
                statement.executeUpdate();
            }
        }
        conn.close();
    }
    
        
        
        
    public void atualizardeposito(Investidor investidor) throws SQLException{
        String sql = "update pessoa set \"real\" = ? where cpf = ?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setDouble(1, investidor.getCarteira().getMoedas().get(0).getSaldo());
        statement.setString(2, investidor.getCpf());
        statement.executeUpdate();
        conn.close();
    }
    
    public void atualizaReal(Investidor investidor) throws SQLException{
        String sql = "update pessoa set \"real\" = ? where cpf = ?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setDouble(1, investidor.getCarteira().getMoedas().get(0).getSaldo());
        statement.setString(2, investidor.getCpf());
        statement.executeUpdate();
    }
    
    public void atualizarcompraBit(Investidor investidor) throws SQLException{
        String sql = "update pessoa set \"bitcoin\" = ? where cpf = ?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setDouble(1, investidor.getCarteira().getMoedas().get(1).getSaldo());
        statement.setString(2, investidor.getCpf());
        statement.executeUpdate();
        conn.close();
    }
    
    public void atualizarcompraEth(Investidor investidor) throws SQLException{
        String sql = "update pessoa set \"ethereum\" = ? where cpf = ?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setDouble(1, investidor.getCarteira().getMoedas().get(2).getSaldo());
        statement.setString(2, investidor.getCpf());
        statement.executeUpdate();
        conn.close();
    }
    
    public void atualizarcompraRip(Investidor investidor) throws SQLException{
        String sql = "update pessoa set \"ripple\" = ? where cpf = ?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setDouble(1, investidor.getCarteira().getMoedas().get(3).getSaldo());
        statement.setString(2, investidor.getCpf());
        statement.executeUpdate();
        conn.close();
    }
    
    public void atualizarvendaBit(Investidor investidor) throws SQLException{
        String sql = "update pessoa set \"bitcoin\" = ? where cpf = ?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setDouble(1, investidor.getCarteira().getMoedas().get(1).getSaldo());
        statement.setString(2, investidor.getCpf());
        statement.executeUpdate();
        conn.close();
    }
    
    public void atualizarvendaEth(Investidor investidor) throws SQLException{
        String sql = "update pessoa set \"ethereum\" = ? where cpf = ?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setDouble(1, investidor.getCarteira().getMoedas().get(2).getSaldo());
        statement.setString(2, investidor.getCpf());
        statement.executeUpdate();
        conn.close();
    }
    
    public void atualizarvendaRip(Investidor investidor) throws SQLException{
        String sql = "update pessoa set \"ripple\" = ? where cpf = ?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setDouble(1, investidor.getCarteira().getMoedas().get(3).getSaldo());
        statement.setString(2, investidor.getCpf());
        statement.executeUpdate();
        conn.close();
    }
    
    public void atualizaCotacao(Investidor investidor) throws SQLException{
        String sql = "update pessoa set \"cotacaoBit\" = ?, \"cotacaoEth\" = ?, \"cotacaoRip\" = ?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setDouble(1, investidor.getCarteira().getMoedas().get(1).getCotacao());
        statement.setDouble(2, investidor.getCarteira().getMoedas().get(2).getCotacao());
        statement.setDouble(3, investidor.getCarteira().getMoedas().get(3).getCotacao());
        statement.executeUpdate();
        conn.close();
    }
    
    public void extrato() throws SQLException{
        
    }
}
