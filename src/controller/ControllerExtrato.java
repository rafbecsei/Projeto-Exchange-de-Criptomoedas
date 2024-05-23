package controller;

import DAO.Conexao;
import DAO.InvestidorDAO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import javax.swing.JOptionPane;
import model.Investidor;
import view.ExtratoFrame;

/**
 *
 * @author Rafael Becsei
 */

public class ControllerExtrato {
    private ExtratoFrame view;
    private Investidor investidor;
    
    public ControllerExtrato(Investidor investidor, ExtratoFrame view) {
        this.view = view;
        
    }
    
    public void extratoFrame(Investidor investidor){
        ExtratoFrame ef = new ExtratoFrame(investidor);
        ef.setVisible(true);
        this.investidor = investidor;
    }
    
    public void extrato(Investidor investidor){
        view.getTxtExtrato().setText("");
        Conexao conexao = new Conexao();
        try{
            Connection conn = conexao.getConnection();
            InvestidorDAO dao = new InvestidorDAO(conn);
            ResultSet resultado = dao.consultarSenha(investidor);
            if(resultado.next()){
                int idinv = resultado.getInt("id");
                dao.maxIdlog();
                int l = dao.maxIdlog();
                int i = 1;
                while (i <= l) {
                    ResultSet res = dao.consultarExtrato(investidor, i, idinv);
                    if (res.next()) {
                        String transacao = res.getString("transacao");
                        String sinal = res.getString("sinal");
                        double valor = res.getDouble("valor");
                        String moeda = res.getString("moeda");
                        double taxa = res.getDouble("taxa");
                        double cotacao = res.getDouble("cotacao");
                        double Real = res.getDouble("real");
                        double Bitcoin = res.getDouble("bitcoin");
                        double Ethereum = res.getDouble("ethereum");
                        double Ripple = res.getDouble("ripple");
                        String data = res.getString("data");
                        DecimalFormat decimalFormat = new DecimalFormat("#.#####");
                        NumberFormat numberFormat = NumberFormat.getInstance();
                        numberFormat.setMaximumFractionDigits(2);
                        String fReal = numberFormat.format(Real);
                        String fBitcoin = decimalFormat.format(Bitcoin);
                        String fEthereum = decimalFormat.format(Ethereum);
                        String fRipple = decimalFormat.format(Ripple);
                        String texto = view.getTxtExtrato().getText();
                        String linha = transacao + " " + sinal + " " 
                                + valor + " " + moeda + " / " + "Cotacao: " 
                                + cotacao + " / " + "Taxa: " + taxa + " / " 
                                + "Saldos: " + "R$ " + fReal + " / " + "BTC " 
                                + fBitcoin + " / " + "ETH " + fEthereum + " / " 
                                + "XRP " + fRipple + " / " + data;
                        view.getTxtExtrato().setText(texto + "\n" + linha + "\n");
                    }
                    i++;
                }
            }
        } catch (SQLException e){
            JOptionPane.showMessageDialog(view, "Erro no Saldo");
        }
    }
    
    public void voltarExtrato(){
        view.setVisible(false);
    }
}
