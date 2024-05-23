package controller;

import DAO.Conexao;
import DAO.InvestidorDAO;
import java.sql.Connection;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import model.Investidor;
import view.DepositoFrame;
import java.sql.SQLException;




/**
 *
 * @author Rafael Becsei
 */

public class ControllerDeposito {
    private DepositoFrame view;
    private Investidor investidor;

    public ControllerDeposito(DepositoFrame view, Investidor investidor) {
        this.view = view;
        this.investidor = investidor;
    }
    
    public void depositoFrame(Investidor investidor){
        DepositoFrame df = new DepositoFrame(investidor);
        df.setVisible(true);
    }
    
    public void depositoReal(){
        Conexao conexao = new Conexao();
        try{
            Connection conn = conexao.getConnection();
            InvestidorDAO dao = new InvestidorDAO(conn);
            ResultSet res = dao.consultarSenha(investidor);
            if(res.next()){
                int idinv = res.getInt("id");
                String quantiaDepositadaStr = view.getTxtquantiaDeposito().getText();
                double quantiaDepositada = Double.parseDouble(quantiaDepositadaStr);
                double Real = investidor.getCarteira().getMoedas().get(0).getSaldo();
                double NovoReal = Real + quantiaDepositada;
                investidor.getCarteira().getMoedas().get(0).setSaldo(NovoReal);
                dao.atualizardeposito(investidor);
                dao.extrato(investidor, "+", "Deposito", quantiaDepositada, "Real", 0, 0, idinv);
                JOptionPane.showMessageDialog(view, "Depósito Realizado");
                view.getLblNovoSaldoPessoa().setText(String.valueOf(NovoReal));
            }
        } catch (SQLException e){
            JOptionPane.showMessageDialog(view, "Erro no Depósito");
        }
    }
    
    public void voltarDeposito(){
        view.setVisible(false);
    }
    
}
