package controller;

import DAO.Conexao;
import DAO.InvestidorDAO;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.Investidor;
import view.VenderRipFrame;

/**
 *
 * @author Rafael Becsei
 */

public class ControllerVenderRip {
    private VenderRipFrame view;
    private Investidor investidor;

    public ControllerVenderRip(VenderRipFrame view, Investidor investidor) {
        this.view = view;
        this.investidor = investidor;
    }
    
    public void venderRipFrame(){
        VenderRipFrame rf = new VenderRipFrame(investidor);
        rf.setVisible(true);
    }
    
    public void venderRip(){
        Conexao conexao = new Conexao();
        try{
            Connection conn = conexao.getConnection();
            InvestidorDAO dao = new InvestidorDAO(conn);
            String quantiavenderStr = view.getTxtValorRip().getText();
            double quantiaVender = Double.parseDouble(quantiavenderStr);
            double Ripple = investidor.getCarteira().getMoedas().get(3).getSaldo();
            double cotacaoRip = investidor.getCarteira().getMoedas().get(3).getCotacao();
            double taxaRipV = investidor.getCarteira().getMoedas().get(3).getTaxaVenda();
            double Real = investidor.getCarteira().getMoedas().get(0).getSaldo();
            double ripCotacao = quantiaVender / cotacaoRip;
            double NovoRipple = Ripple - ripCotacao;
            if (NovoRipple < 0){
                JOptionPane.showMessageDialog(view, "Saldo Insuficiente");
            } else{
                double NovoReal = Real + quantiaVender * (1 + taxaRipV);
                investidor.getCarteira().getMoedas().get(3).setSaldo(NovoRipple);
                investidor.getCarteira().getMoedas().get(0).setSaldo(NovoReal);
                dao.atualizaReal(investidor);
                dao.atualizarvendaRip(investidor);
                JOptionPane.showMessageDialog(view, "Venda Realizado");
                view.getLblSaldoRipple().setText(String.valueOf(NovoRipple));
                double RipparaReal = NovoRipple * cotacaoRip;
//                double BitReal = BitparaReal * (1 + taxaBitV);
                view.getLblSaldoReal().setText(String.format("%.2f",RipparaReal));
            } 
            
        } catch (SQLException e){
            JOptionPane.showMessageDialog(view, "Erro na Venda");
        }
    }
    
    public void voltarCompra(){
        view.setVisible(false);
    }
    
}
