package controller;

import DAO.Conexao;
import DAO.InvestidorDAO;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.Investidor;
import view.LoginFrame;
import view.VenderBitFrame;

/**
 *
 * @author Rafael Becsei
 */

public class ControllerVenderBit {
    private VenderBitFrame view;
    private Investidor investidor;

    public ControllerVenderBit(VenderBitFrame view, Investidor investidor) {
        this.view = view;
        this.investidor = investidor;
    }
    
    public void venderBitFrame(){
        VenderBitFrame bf = new VenderBitFrame(investidor);
        bf.setVisible(true);
    }
    
    public void venderBit(){
        Conexao conexao = new Conexao();
//        try{
//            Connection conn = conexao.getConnection();
//            InvestidorDAO dao = new InvestidorDAO(conn);
//            String quantiavenderStr = view.getTxtValorBit().getText();
//            double quantiaVender = Double.parseDouble(quantiavenderStr);
//            double Bitcoin = investidor.getCarteira().getMoedas().get(1).getSaldo();
//            double cotacaoBit = investidor.getCarteira().getMoedas().get(1).getCotacao();
//            double taxaBitC = investidor.getCarteira().getMoedas().get(1).getTaxaCompra();
//            double Real = investidor.getCarteira().getMoedas().get(0).getSaldo();
//            double NovoReal = Real - quantiaVender * (1 + taxaBitC);
//            if (NovoBitcoin < 0){
//                JOptionPane.showMessageDialog(view, "Saldo Insuficiente");
//            } else{
//                
//                double bitCotacao = quantiaComprar / cotacaoBit;
//                double NovoBitcoin = Bitcoin + bitCotacao;
//                investidor.getCarteira().getMoedas().get(1).setSaldo(NovoBitcoin);
//                investidor.getCarteira().getMoedas().get(0).setSaldo(NovoReal);
//                dao.atualizaReal(investidor);
//                dao.atualizarcompraBit(investidor);
//                JOptionPane.showMessageDialog(view, "Compra Realizado");
//                view.getLblSaldoBitcoin().setText(String.valueOf(NovoBitcoin));
//            } 
//            
//        } catch (SQLException e){
//            JOptionPane.showMessageDialog(view, "Erro na Compra");
//        }
    }
    
    public void voltarCompra(){
        view.setVisible(false);
    }
    
}
