package controller;

import DAO.Conexao;
import DAO.InvestidorDAO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;
import javax.swing.JOptionPane;
import model.Investidor;
import view.AtualizarFrame;
import view.LoginFrame;


/**
 *
 * @author Rafael Becsei
 */

public class ControllerAtualizar {
    private AtualizarFrame view;
    private Investidor investidor;
    private LoginFrame lf;

    public ControllerAtualizar(AtualizarFrame view, Investidor investidor) {
        this.view = view;
        this.investidor = investidor;
    }
    
    public void atualizaFrame(Investidor investidor){
        AtualizarFrame af = new AtualizarFrame(investidor, lf);
        af.setVisible(true);
    }
    
//    
//    
//    
//    
//    
//    
//    TALVEZ MEXER EMBAIXO
//    
//    
//    
//    
//    
//  

    public void atualizaCotacao(){
        Conexao conexao = new Conexao();
        Random rand = new Random();
        
        try{
            Connection conn = conexao.getConnection();
            InvestidorDAO dao = new InvestidorDAO(conn);
            ResultSet res = dao.consultarSenha(investidor);
            if(res.next()){
                
                double cotacaoBit = res.getDouble("cotacaoBit");
                double cotacaoEth = res.getDouble("cotacaoEth");
                double cotacaoRip = res.getDouble("cotacaoRip");
                
                double atualizacaoBit = (rand.nextDouble() * 0.1 - 0.05) * cotacaoBit;
                double atualizacaoEth = (rand.nextDouble() * 0.1 - 0.05) * cotacaoEth;
                double atualizacaoRip = (rand.nextDouble() * 0.1 - 0.05) * cotacaoRip;
                
                cotacaoBit += atualizacaoBit;
                cotacaoEth += atualizacaoEth;
                cotacaoRip += atualizacaoRip;
                
                investidor.getCarteira().getMoedas().get(1).setCotacao(cotacaoBit);
                investidor.getCarteira().getMoedas().get(2).setCotacao(cotacaoEth);
                investidor.getCarteira().getMoedas().get(3).setCotacao(cotacaoRip);
                
                dao.atualizaCotacao(investidor);
                
                JOptionPane.showMessageDialog(view, "Cotação Atualizada");
                
                view.getLblcotacaoBitAtual().setText(String.valueOf(cotacaoBit));
                view.getLblcotacaoEthAtual().setText(String.valueOf(cotacaoEth));
                view.getLblcotacaoRipAtual().setText(String.valueOf(cotacaoRip));
                
                
            } else {
                JOptionPane.showMessageDialog(view, "Erro");
            }
        } catch (SQLException e){
            JOptionPane.showMessageDialog(view, "Erro de conexão");
        }
    }
    
    public void voltarAtualiza(){
        view.setVisible(false);
    }
}
