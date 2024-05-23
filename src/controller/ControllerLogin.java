
package controller;

import DAO.InvestidorDAO;
import DAO.Conexao;
import view.LoginFrame;
import java.sql.Connection;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Bitcoin;
import model.Carteira;
import model.Ethereum;
import model.Investidor;
import model.Moedas;
import model.Real;
import model.Ripple;
import view.MenuFrame;

/**
 *
 * @author Rafael Becsei
 */

public class ControllerLogin {
    private LoginFrame view;

    public ControllerLogin(LoginFrame view) {
        this.view = view;
    }
    
    public void loginPessoa(){
        Investidor investidor = new Investidor(null, view.getTxtCpf().getText(),
                                                view.getTxtSenha().getText());
        Conexao conexao = new Conexao();
        try{
            Connection conn = conexao.getConnection();
            InvestidorDAO dao = new InvestidorDAO(conn);
            ResultSet res = dao.consultarSenha(investidor);
            if(res.next()){
                JOptionPane.showMessageDialog(view, "Login Feito");
                String nome = res.getString("nome");
                String cpf = res.getString("cpf");
                String senha = res.getString("senha");
                double Real = res.getDouble("real");
                double Bitcoin = res.getDouble("bitcoin");
                double Ethereum = res.getDouble("ethereum");
                double Ripple = res.getDouble("ripple");
                double cotacaoBit = res.getDouble("cotacaoBit");
                double cotacaoEth = res.getDouble("cotacaoEth");
                double cotacaoRip = res.getDouble("cotacaoRip");
                ArrayList<Moedas> moedas = new ArrayList<>();
                moedas.add(new Real(Real, 0));
                moedas.add(new Bitcoin(Bitcoin, cotacaoBit));
                moedas.add(new Ethereum(Ethereum, cotacaoEth));
                moedas.add(new Ripple(Ripple, cotacaoRip));
                Carteira carteira = new Carteira(moedas);
                MenuFrame mf = new MenuFrame(view, new Investidor(carteira, nome, cpf, senha));
                mf.setVisible(true);
                view.setVisible(false);
            } else {
                JOptionPane.showMessageDialog(view, "Dados Incorretos");
            }
        } catch (SQLException e){
            JOptionPane.showMessageDialog(view, "Erro na conexão");
        }
    }
}
