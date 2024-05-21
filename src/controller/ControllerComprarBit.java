package controller;

import DAO.Conexao;
import DAO.InvestidorDAO;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.Investidor;
import view.ComprarBitFrame;
import view.LoginFrame;


/**
 *
 * @author Rafael Becsei
 */
public class ControllerComprarBit {
    private ComprarBitFrame view;
    private Investidor investidor;
    private LoginFrame lf;

//    public ControllerComprarBit(ComprarBitFrame view, Investidor investidor)
    public ControllerComprarBit(ComprarBitFrame view, Investidor investidor) {
        this.view = view;
        this.investidor = investidor;
    }
    
    public void comprarBitFrame(){
        ComprarBitFrame bf = new ComprarBitFrame(investidor);
        bf.setVisible(true);
    }
    
    public void comprarBit(){
        Conexao conexao = new Conexao();
        try{
            String quantiacomprarStr = view.getTxtValorBit().getText();
            double quantiaComprar = Double.parseDouble(quantiacomprarStr);
            double Bitcoin = investidor.getCarteira().getMoedas().get(1).getSaldo();
            double cotacaoBit = investidor.getCarteira().getMoedas().get(1).getCotacao();
            double taxaBitC = investidor.getCarteira().getMoedas().get(1).getTaxaC();
            double Real = investidor.getCarteira().getMoedas().get(0).getSaldo();
            double NovoReal = Real - quantiaComprar * (1 + taxaBitC);
            if (NovoReal < 0){
                JOptionPane.showMessageDialog(view, "Saldo Insuficiente");
            } else{
                Connection conn = conexao.getConnection();
                InvestidorDAO dao = new InvestidorDAO(conn);
                dao.atualizarcompraBit(investidor);
                dao.atualizaReal(investidor);
                double bitCotacao = quantiaComprar / cotacaoBit;
                double NovoBitcoin = Bitcoin + bitCotacao;
                investidor.getCarteira().getMoedas().get(1).setSaldo(NovoBitcoin);
                investidor.getCarteira().getMoedas().get(0).setSaldo(NovoReal);
                JOptionPane.showMessageDialog(view, "Compra Realizado");
                view.getLblSaldoBitcoin().setText(String.valueOf(NovoBitcoin));
            } 
            
        } catch (SQLException e){
            JOptionPane.showMessageDialog(view, "Erro no Depósito");
        }
    }
    
    public void voltarCompra(){
        view.setVisible(false);
    }
}
