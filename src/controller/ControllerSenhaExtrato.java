package controller;

import DAO.Conexao;
import DAO.InvestidorDAO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Bitcoin;
import model.Carteira;
import model.Ethereum;
import model.Investidor;
import model.Moedas;
import model.Real;
import model.Ripple;
import view.ExtratoFrame;
import view.LoginFrame;
import view.SenhaExtratoFrame;

/**
 *
 * @author Rafael Becsei
 */
public class ControllerSenhaExtrato {
    private SenhaExtratoFrame view;

    public ControllerSenhaExtrato(SenhaExtratoFrame view) {
        this.view = view;
    }
    
    public void consultaSenha(LoginFrame lf){
        Investidor investidor = new Investidor(null, null, lf.getTxtCpf().getText(),
                view.getTxtSenha().getText());
        Conexao conexao = new Conexao();
        
        try{
            Connection conn = conexao.getConnection();
            InvestidorDAO dao = new InvestidorDAO(conn);
            ResultSet res = dao.consultarSenha(investidor);
            if(res.next()){                
                String nome = res.getString("nome");
                String cpf = res.getString("cpf");
                String senha = res.getString("senha");
                double Real = res.getDouble("real");
                double Bitcoin = res.getDouble("bitcoin");
                double Ethereum = res.getDouble("ethereum");
                double Ripple = res.getDouble("ripple");
                ArrayList<Moedas> moedas = new ArrayList<Moedas>();
                double cotacaoBit = res.getDouble("cotacaoBit");
                double cotacaoEth = res.getDouble("cotacaoEth");
                double cotacaoRip = res.getDouble("cotacaoRip");
                moedas.add(new Real(Real, 0));
                moedas.add(new Bitcoin(Bitcoin, cotacaoBit));
                moedas.add(new Ethereum(Ethereum, cotacaoEth));
                moedas.add(new Ripple(Ripple, cotacaoRip));
                Carteira carteira = new Carteira(moedas);
                ExtratoFrame ef = new ExtratoFrame(new Investidor(carteira, nome, 
                                                                cpf, senha));
                ef.setVisible(true);
                view.setVisible(false);
            } else {
                JOptionPane.showMessageDialog(view, "Senha Incorreta");
            }
        } catch (SQLException e){
            
            JOptionPane.showMessageDialog(view, "Erro de conexão!");
        }
    }
    
    public void voltar(){
        view.setVisible(false);
    }
}
