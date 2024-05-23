package controller;

import DAO.Conexao;
import DAO.InvestidorDAO;
import javax.swing.JOptionPane;
import model.Investidor;
import view.ComprarEthFrame;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.ResultSet;

/**
 *
 * @author Rafael Becsei
 */

public class ControllerComprarEth {
    private ComprarEthFrame view;
    private Investidor investidor;

    public ControllerComprarEth(ComprarEthFrame view, Investidor investidor) {
        this.view = view;
        this.investidor = investidor;
    }
    
    public void comprarEthFrame(){
        ComprarEthFrame ef = new ComprarEthFrame(investidor);
        ef.setVisible(true);
    }
    
    public void comprarEth(){
        Conexao conexao = new Conexao();
        try{
            Connection conn = conexao.getConnection();
            InvestidorDAO dao = new InvestidorDAO(conn);
            ResultSet res = dao.consultarSenha(investidor);
            if(res.next()){
                int idinv = res.getInt("id");
                String quantiacomprarStr = view.getTxtValorBit().getText();
                double quantiaComprar = Double.parseDouble(quantiacomprarStr);
                double Ethereum = investidor.getCarteira().getMoedas().get(2).getSaldo();
                double cotacaoEth = investidor.getCarteira().getMoedas().get(2).getCotacao();
                double taxaEthC = investidor.getCarteira().getMoedas().get(2).getTaxaCompra();
                double Real = investidor.getCarteira().getMoedas().get(0).getSaldo();
                double NovoReal = Real - quantiaComprar * (1 + taxaEthC);
                if (NovoReal < 0){
                    JOptionPane.showMessageDialog(view, "Saldo Insuficiente");
                } else{
                    double ethCotacao = quantiaComprar / cotacaoEth;
                    double NovoEthereum = Ethereum + ethCotacao;
                    investidor.getCarteira().getMoedas().get(2).setSaldo(NovoEthereum);
                    investidor.getCarteira().getMoedas().get(0).setSaldo(NovoReal);
                    dao.atualizaReal(investidor);
                    dao.atualizarcompraEth(investidor);
                    dao.extrato(investidor, "+", "Compra Ethereum", quantiaComprar, 
                                        "Ethereum", taxaEthC, cotacaoEth, idinv);
                    JOptionPane.showMessageDialog(view, "Compra Realizado");
                    view.getLblSaldoEthereum().setText(String.valueOf(NovoEthereum));
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
