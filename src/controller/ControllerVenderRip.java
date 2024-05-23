package controller;

import DAO.Conexao;
import DAO.InvestidorDAO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.Investidor;
import view.VenderRipFrame;

/**
 *
 * @author Rafael Becsei
 */

public class ControllerVenderRip {
    private VenderRipFrame view; // Referência para a interface de venda de Ripple.
    private Investidor investidor; // Objeto Investidor que será utilizado na venda.

    // Construtor que recebe a interface de venda de Ripple e o investidor como parâmetros.
    public ControllerVenderRip(VenderRipFrame view, Investidor investidor) {
        this.view = view; // Inicializa a referência para a interface de venda de Ripple.
        this.investidor = investidor; // Inicializa o objeto Investidor.
    }
    
    // Método para abrir a janela de venda de Ripple.
    public void venderRipFrame(){
        // Cria uma nova janela de venda de Ripple com os detalhes do investidor.
        VenderRipFrame rf = new VenderRipFrame(investidor);
        rf.setVisible(true); // Exibe a janela de venda de Ripple.
    }
    
    // Método para realizar a venda de Ripple.
    public void venderRip(){
        // Objeto para gerenciar a conexão com o banco de dados.
        Conexao conexao = new Conexao(); 
        try{
            // Estabelece a conexão com o banco de dados.
            Connection conn = conexao.getConnection(); 
            // Objeto DAO para consultar e atualizar o banco de dados.
            InvestidorDAO dao = new InvestidorDAO(conn); 
            // Consulta a senha no banco de dados.
            ResultSet res = dao.consultarSenha(investidor); 
            // Verifica se há correspondência para a senha fornecida.
            if(res.next()){ 
                // Extrai os dados necessários do investidor.
                int idinv = res.getInt("id");
                String quantiavenderStr = view.getTxtValorRip().getText();
                double quantiaVender = Double.parseDouble(quantiavenderStr);
                double Ripple = investidor.getCarteira().getMoedas().get(3)
                                                                    .getSaldo();
                double cotacaoRip = investidor.getCarteira().getMoedas().get(3)
                                                                .getCotacao();
                double taxaRipV = investidor.getCarteira().getMoedas().get(3)
                                                                .getTaxaVenda();
                double Real = investidor.getCarteira().getMoedas().get(0)
                                                                    .getSaldo();
                double ripCotacao = quantiaVender / cotacaoRip;
                double NovoRipple = Ripple - ripCotacao;
                
                // Verifica se há saldo suficiente para realizar a venda.
                if (NovoRipple < 0){
                    JOptionPane.showMessageDialog(view, "Saldo Insuficiente");
                } else {
                    // Calcula o novo saldo em Real e Ripple após a venda.
                    double NovoReal = Real + quantiaVender * (1 + taxaRipV);
                    investidor.getCarteira().getMoedas().get(3)
                                                            .setSaldo(NovoRipple);
                    investidor.getCarteira().getMoedas().get(0)
                                                            .setSaldo(NovoReal);
                    // Atualiza o saldo em Real no banco de dados.
                    dao.atualizaReal(investidor); 
                    // Atualiza o saldo em Ripple no banco de dados.
                    dao.atualizarvendaRip(investidor); 
                    // Registra a transação no extrato.
                    dao.extrato(investidor, "-", "Venda Ripple", quantiaVender, 
                                        "Ripple", taxaRipV, cotacaoRip, idinv);
                    // Exibe uma mensagem de confirmação da venda.
                    JOptionPane.showMessageDialog(view, "Venda Realizado"); 
                    // Atualiza os rótulos de saldo exibidos na interface.
                    view.getLblSaldoRipple().setText(String.valueOf(NovoRipple));
                    double RipparaReal = NovoRipple * cotacaoRip;
                    view.getLblSaldoReal().setText(String.format("%.2f",RipparaReal));
                } 
            }
        } catch (SQLException e){
            // Exibe uma mensagem de erro em caso de falha na venda.
            JOptionPane.showMessageDialog(view, "Erro na Venda"); 
        }
    }
    
    // Método para voltar à janela anterior.
    public void voltarCompra(){
        view.setVisible(false); // Esconde a janela de venda de Ripple.
    }
}

