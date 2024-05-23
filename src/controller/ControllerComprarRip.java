package controller;

import DAO.Conexao;
import DAO.InvestidorDAO;
import javax.swing.JOptionPane;
import model.Investidor;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import view.ComprarRipFrame;

/**
 *
 * @author Rafael Becsei
 */

public class ControllerComprarRip {
    private ComprarRipFrame view;
    private Investidor investidor;

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
            ResultSet res = dao.consultarSenha(investidor);
            if(res.next()){
                int idinv = res.getInt("id");
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
                    dao.extrato(investidor, "+", "Compra Ripple", quantiaComprar, 
                                        "Ripple", taxaRipC, cotacaoRip, idinv);
                    JOptionPane.showMessageDialog(view, "Compra Realizado");
                    view.getLblSaldoRipple().setText(String.valueOf(NovoRipple));
                } 
            }
        } catch (SQLException e){
            JOptionPane.showMessageDialog(view, "Erro na Compra");
        }
    }
    
    public void voltarCompra(){
        view.setVisible(false);
    }
}
