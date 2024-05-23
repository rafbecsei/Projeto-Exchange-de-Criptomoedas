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
    private VenderBitFrame view; // Referência para a interface de venda de Bitcoin.
    private Investidor investidor; // Objeto Investidor que será utilizado na venda.

    // Construtor que recebe a interface de venda de Bitcoin e o investidor como parâmetros.
    public ControllerVenderBit(VenderBitFrame view, Investidor investidor) {
        this.view = view; // Inicializa a referência para a interface de venda de Bitcoin.
        this.investidor = investidor; // Inicializa o objeto Investidor.
    }
    
    // Método para abrir a janela de venda de Bitcoin.
    public void venderBitFrame(){
        // Cria uma nova janela de venda de Bitcoin com os detalhes do investidor.
        VenderBitFrame bf = new VenderBitFrame(investidor);
        bf.setVisible(true); // Exibe a janela de venda de Bitcoin.
    }
    
    // Método para realizar a venda de Bitcoin.
    public void venderBit(){
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
                String quantiavenderStr = view.getTxtValorBit().getText();
                double quantiaVender = Double.parseDouble(quantiavenderStr);
                double Bitcoin = investidor.getCarteira().getMoedas().get(1)
                                                                    .getSaldo();
                double cotacaoBit = investidor.getCarteira().getMoedas().get(1)
                                                                .getCotacao();
                double taxaBitV = investidor.getCarteira().getMoedas().get(1)
                                                                .getTaxaVenda();
                double Real = investidor.getCarteira().getMoedas().get(0)
                                                                    .getSaldo();
                double bitCotacao = quantiaVender / cotacaoBit;
                double NovoBitcoin = Bitcoin - bitCotacao;
                
                // Verifica se há saldo suficiente para realizar a venda.
                if (NovoBitcoin < 0){
                    JOptionPane.showMessageDialog(view, "Saldo Insuficiente");
                } else {
                    // Calcula o novo saldo em Real e Bitcoin após a venda.
                    double NovoReal = Real + quantiaVender * (1 + taxaBitV);
                    investidor.getCarteira().getMoedas().get(1)
                                                        .setSaldo(NovoBitcoin);
                    investidor.getCarteira().getMoedas().get(0)
                                                            .setSaldo(NovoReal);
                    // Atualiza o saldo em Real no banco de dados.
                    dao.atualizaReal(investidor); 
                    // Atualiza o saldo em Bitcoin no banco de dados.
                    dao.atualizarvendaBit(investidor); 
                    // Registra a transação no extrato.
                    dao.extrato(investidor, "-", "Venda Bitcoin", quantiaVender,
                            "Bitcoin", taxaBitV, cotacaoBit, idinv);
                    // Exibe uma mensagem de confirmação da venda.
                    JOptionPane.showMessageDialog(view, "Venda Realizada"); 
                    // Atualiza os rótulos de saldo exibidos na interface.
                    view.getLblSaldoBitcoin().setText(String.valueOf(NovoBitcoin));
                    double BitparaReal = NovoBitcoin * cotacaoBit;
                    view.getLblSaldoReal().setText(String.format("%.2f",BitparaReal));
                } 
            }
        } catch (SQLException e){
            // Exibe uma mensagem de erro em caso de falha na venda.
            JOptionPane.showMessageDialog(view, "Erro na Venda"); 
        }
    }
    
    // Método para voltar à janela anterior.
    public void voltarCompra(){
        view.setVisible(false); // Esconde a janela de venda de Bitcoin.
    }
}

