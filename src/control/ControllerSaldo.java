package control;


import view.SaldoFrame;
import DAO.PessoaDAO;
import DAO.Conexao;
import model.Pessoa;
import java.sql.Connection;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import java.sql.SQLException;


/**
 *
 * @author Rafael Becsei
 */

public class ControllerSaldo {
    private SaldoFrame view;
    
    public ControllerSaldo(SaldoFrame view) {
        this.view = view;
    }
  
    
//    public void Saldo(){
//        Pessoa pessoa = new Pessoa(view.getTxtNome().getText(),null,viewSC.getSenhaTxt().getText());   
//        Conexao conexao = new Conexao();
//        try{
//            Connection conn = conexao.getConnection();
//            PessoaDAO dao = new PessoaDAO(conn, view);
//            ResultSet res = dao.consultarSaldo(pessoa);
//            if(res.next()){
//                String nome = res.getString("nome");
//                String cpf = res.getString("cpf");
//                double saldoReal = res.getDouble("saldoReal");
//                double saldoBitcoin = res.getDouble("saldoBitcoin");
//                double saldoEthereum = res.getDouble("saldoEthereum");
//                double saldoRipple = res.getDouble("saldoRipple");
//                JOptionPane.showMessageDialog(view, "Dados corretos!");
//                JanelaConsultarSaldo c = new JanelaConsultarSaldo(nome, cpf,
//                        saldoReal, saldoBitcoin, saldoEthereum, saldoRipple);
//                viewSC.setVisible(false);
//                c.setVisible(true);
//            } else {
//                JOptionPane.showMessageDialog(view, "Senha incorreta");
//            }
//            
//        } catch (SQLException e){
//            JOptionPane.showMessageDialog(view, "Erro de conexao!");
//        }
//    }
    
    public void voltarSaldo(){
        view.setVisible(false);
    }
}
