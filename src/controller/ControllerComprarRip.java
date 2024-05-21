package controller;

import DAO.Conexao;
import DAO.InvestidorDAO;
import javax.swing.JOptionPane;
import model.Investidor;
import java.sql.Connection;
import java.sql.SQLException;
import view.ComprarRipFrame;
import view.LoginFrame;

/**
 *
 * @author Rafael Becsei
 */
public class ControllerComprarRip {
    private ComprarRipFrame view;
    private Investidor investidor;
    private LoginFrame lf;

    public ControllerComprarRip(ComprarRipFrame view, Investidor investidor) {
        this.view = view;
        this.investidor = investidor;
    }
    
    public void comprarRipFrame(){
        ComprarRipFrame rf = new ComprarRipFrame(investidor);
        rf.setVisible(true);
    }
    
     public void comprarRip(){
        Conexao conexao = new Conexao();
        try{
            Connection conn = conexao.getConnection();
            InvestidorDAO dao = new InvestidorDAO(conn);
            String quantiacomprarStr = view.getTxtValorBit().getText();
            double quantiaComprar = Double.parseDouble(quantiacomprarStr);
            double Ripple = investidor.getCarteira().getMoedas().get(3).getSaldo();
            double cotacaoRip = investidor.getCarteira().getMoedas().get(3).getCotacao();
            double taxaRipC = investidor.getCarteira().getMoedas().get(3).getTaxaCompra();
            double Real = investidor.getCarteira().getMoedas().get(0).getSaldo();
            double NovoReal = Real - quantiaComprar * (1 + taxaRipC);
            if (NovoReal < 0){
                JOptionPane.showMessageDialog(view, "Saldo Insuficiente");
            } else{
                
                double ripCotacao = quantiaComprar / cotacaoRip;
                double NovoRipple = Ripple + ripCotacao;
                investidor.getCarteira().getMoedas().get(3).setSaldo(NovoRipple);
                investidor.getCarteira().getMoedas().get(0).setSaldo(NovoReal);
                dao.atualizaReal(investidor);
                dao.atualizarcompraRip(investidor);
                JOptionPane.showMessageDialog(view, "Compra Realizado");
                view.getLblSaldoRipple().setText(String.valueOf(NovoRipple));
            } 
            
        } catch (SQLException e){
            JOptionPane.showMessageDialog(view, "Erro na Compra");
        }
    }
    
    public void voltarCompra(){
        view.setVisible(false);
    }
}
