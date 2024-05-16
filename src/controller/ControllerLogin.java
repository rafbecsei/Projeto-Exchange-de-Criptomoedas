
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
            ResultSet res = dao.consultar(investidor);
            if(res.next()){
                JOptionPane.showMessageDialog(view, "Login feito!");
                String nome = res.getString("nome");
                String cpf = res.getString("cpf");
                String senha = res.getString("senha");
                ArrayList<Moedas> moedas = new ArrayList<>();
                double saldoReal = res.getDouble("real");
                double saldoBitcoin = res.getDouble("bitcoin");
                double saldoEthereum = res.getDouble("ethereum");
                double saldoRipple = res.getDouble("ripple");
                moedas.add(new Real(saldoReal));
                moedas.add(new Bitcoin(saldoBitcoin));
                moedas.add(new Ethereum(saldoEthereum));
                moedas.add(new Ripple(saldoRipple));
                Carteira carteira = new Carteira(moedas);
                
                MenuFrame mf = new MenuFrame(view, new Investidor(carteira, nome, cpf, senha));
                mf.setVisible(true);
                view.setVisible(false);
                
            } else {
                JOptionPane.showMessageDialog(view, "Login nao foi efetuado!");
            }
        } catch (SQLException e){
            JOptionPane.showMessageDialog(view, "Erro de conexao!");
        }
    }
}
