package controller;

import DAO.Conexao;
import DAO.InvestidorDAO;
import javax.swing.JOptionPane;
import java.sql.Connection;
import model.Investidor;
import view.SacarFrame;
import java.sql.SQLException;

/**
 *
 * @author Rafael Becsei
 */

public class ControllerSaque {
    private SacarFrame view;
    private Investidor investidor;

    public ControllerSaque(SacarFrame view, Investidor investidor) {
        this.view = view;
        this.investidor = investidor;
    }
    
    public void sacarFrame(Investidor investidor){
        SacarFrame sf = new SacarFrame(investidor);
        sf.setVisible(true);
    }
    
    public void SaqueReal(){
        String quantiaSacadaStr = view.getTxtQuantiaSaque().getText();
        double quantiaSacada = Double.parseDouble(quantiaSacadaStr);
        double Real = investidor.getCarteira().getMoedas().get(0).getSaldo();
        if (quantiaSacada > Real){
            JOptionPane.showMessageDialog(view, "Valor Excede Saldo");
        } else{
            double NovoReal = Real - quantiaSacada;
            investidor.getCarteira().getMoedas().get(0).setSaldo(NovoReal);
            JOptionPane.showMessageDialog(view, "Saque Realizado");
        }
        Conexao conexao = new Conexao();
        try{
            Connection conn = conexao.getConnection();
            InvestidorDAO dao = new InvestidorDAO(conn);
            dao.atualizardeposito(investidor);
        } catch (SQLException e){
            JOptionPane.showMessageDialog(view, "Erro no Saque");
        }
    }
    
    public void voltarSaque(){
        view.setVisible(false);
    }
}
