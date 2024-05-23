package controller;

import DAO.Conexao;
import DAO.InvestidorDAO;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.Investidor;
import view.VenderEthFrame;

/**
 *
 * @author Rafael Becsei
 */

public class ControllerVenderEth {
     private VenderEthFrame view;
    private Investidor investidor;

    public ControllerVenderEth(VenderEthFrame view, Investidor investidor) {
        this.view = view;
        this.investidor = investidor;
    }
    
    public void venderBitFrame(){
        VenderEthFrame ef = new VenderEthFrame(investidor);
        ef.setVisible(true);
    }
    
    public void venderEth(){
        Conexao conexao = new Conexao();
        try{
            Connection conn = conexao.getConnection();
            InvestidorDAO dao = new InvestidorDAO(conn);
            String quantiavenderStr = view.getTxtValorEth().getText();
            double quantiaVender = Double.parseDouble(quantiavenderStr);
            double Ethereum = investidor.getCarteira().getMoedas().get(2).getSaldo();
            double cotacaoEth = investidor.getCarteira().getMoedas().get(2).getCotacao();
            double taxaEthV = investidor.getCarteira().getMoedas().get(2).getTaxaVenda();
            double Real = investidor.getCarteira().getMoedas().get(0).getSaldo();
            double ethCotacao = quantiaVender / cotacaoEth;
            double NovoEthereum = Ethereum - ethCotacao;
            if (NovoEthereum < 0){
                JOptionPane.showMessageDialog(view, "Saldo Insuficiente");
            } else{
                double NovoReal = Real + quantiaVender * (1 + taxaEthV);
                investidor.getCarteira().getMoedas().get(2).setSaldo(NovoEthereum);
                investidor.getCarteira().getMoedas().get(0).setSaldo(NovoReal);
                dao.atualizaReal(investidor);
                dao.atualizarvendaEth(investidor);
                JOptionPane.showMessageDialog(view, "Venda Realizada");
                view.getLblSaldoEthereum().setText(String.valueOf(NovoEthereum));
                double EthparaReal = NovoEthereum * cotacaoEth;
//                double BitReal = BitparaReal * (1 + taxaBitV);
                view.getLblSaldoReal().setText(String.format("%.2f",EthparaReal));
            } 
            
        } catch (SQLException e){
            JOptionPane.showMessageDialog(view, "Erro na Venda");
        }
    }
    
    public void voltarCompra(){
        view.setVisible(false);
    }
}
