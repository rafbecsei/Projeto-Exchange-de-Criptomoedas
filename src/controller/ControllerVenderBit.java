package controller;

import DAO.Conexao;
import DAO.InvestidorDAO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.Investidor;
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
        try{
            Connection conn = conexao.getConnection();
            InvestidorDAO dao = new InvestidorDAO(conn);
            ResultSet res = dao.consultarSenha(investidor);
            if(res.next()){
                int idinv = res.getInt("id");
                String quantiavenderStr = view.getTxtValorBit().getText();
                double quantiaVender = Double.parseDouble(quantiavenderStr);
                double Bitcoin = investidor.getCarteira().getMoedas().get(1).getSaldo();
                double cotacaoBit = investidor.getCarteira().getMoedas().get(1).getCotacao();
                double taxaBitV = investidor.getCarteira().getMoedas().get(1).getTaxaVenda();
                double Real = investidor.getCarteira().getMoedas().get(0).getSaldo();
                double bitCotacao = quantiaVender / cotacaoBit;
                double NovoBitcoin = Bitcoin - bitCotacao;
                if (NovoBitcoin < 0){
                    JOptionPane.showMessageDialog(view, "Saldo Insuficiente");
                } else{
                    double NovoReal = Real + quantiaVender * (1 + taxaBitV);
                    investidor.getCarteira().getMoedas().get(1).setSaldo(NovoBitcoin);
                    investidor.getCarteira().getMoedas().get(0).setSaldo(NovoReal);
                    dao.atualizaReal(investidor);
                    dao.atualizarvendaBit(investidor);
                    dao.extrato(investidor, "-", "Venda Bitcoin", quantiaVender, 
                                        "Bitcoin", taxaBitV, cotacaoBit, idinv);
                    JOptionPane.showMessageDialog(view, "Venda Realizada");
                    view.getLblSaldoBitcoin().setText(String.valueOf(NovoBitcoin));
                    double BitparaReal = NovoBitcoin * cotacaoBit;
                    view.getLblSaldoReal().setText(String.format("%.2f",BitparaReal));
                } 
            }
        } catch (SQLException e){
            JOptionPane.showMessageDialog(view, "Erro na Venda");
        }
    }
    
    public void voltarCompra(){
        view.setVisible(false);
    }
    
}
