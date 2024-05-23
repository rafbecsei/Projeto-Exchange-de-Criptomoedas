package controller;

import DAO.Conexao;
import DAO.InvestidorDAO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.Investidor;
import view.VenderEthFrame;

/**
 *
 * @author Rafael Becsei
 */

public class ControllerVenderEth {
    private VenderEthFrame view; // Referência para a interface de venda de Ethereum.
    private Investidor investidor; // Objeto Investidor que será utilizado na venda.

    // Construtor que recebe a interface de venda de Ethereum e o investidor como parâmetros.
    public ControllerVenderEth(VenderEthFrame view, Investidor investidor) {
        this.view = view; // Inicializa a referência para a interface de venda de Ethereum.
        this.investidor = investidor; // Inicializa o objeto Investidor.
    }
    
    // Método para abrir a janela de venda de Ethereum.
    public void venderBitFrame(){
        // Cria uma nova janela de venda de Ethereum com os detalhes do investidor.
        VenderEthFrame ef = new VenderEthFrame(investidor);
        ef.setVisible(true); // Exibe a janela de venda de Ethereum.
    }
    
    // Método para realizar a venda de Ethereum.
    public void venderEth(){
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
                String quantiavenderStr = view.getTxtValorEth().getText();
                double quantiaVender = Double.parseDouble(quantiavenderStr);
                double Ethereum = investidor.getCarteira().getMoedas().get(2)
                                                                    .getSaldo();
                double cotacaoEth = investidor.getCarteira().getMoedas().get(2)
                                                                .getCotacao();
                double taxaEthV = investidor.getCarteira().getMoedas().get(2)
                                                                .getTaxaVenda();
                double Real = investidor.getCarteira().getMoedas().get(0)
                        .getSaldo();
                double ethCotacao = quantiaVender / cotacaoEth;
                double NovoEthereum = Ethereum - ethCotacao;
                
                // Verifica se há saldo suficiente para realizar a venda.
                if (NovoEthereum < 0){
                    JOptionPane.showMessageDialog(view, "Saldo Insuficiente");
                } else {
                    // Calcula o novo saldo em Real e Ethereum após a venda.
                    double NovoReal = Real + quantiaVender * (1 + taxaEthV);
                    investidor.getCarteira().getMoedas().get(2).setSaldo(NovoEthereum);
                    investidor.getCarteira().getMoedas().get(0).setSaldo(NovoReal);
                    dao.atualizaReal(investidor); // Atualiza o saldo em Real no banco de dados.
                    dao.atualizarvendaEth(investidor); // Atualiza o saldo em Ethereum no banco de dados.
                    // Registra a transação no extrato.
                    dao.extrato(investidor, "-", "Venda Ethereum", quantiaVender, "Ethereum", taxaEthV, cotacaoEth, idinv);
                    JOptionPane.showMessageDialog(view, "Venda Realizada"); // Exibe uma mensagem de confirmação da venda.
                    // Atualiza os rótulos de saldo exibidos na interface.
                    view.getLblSaldoEthereum().setText(String.valueOf(NovoEthereum));
                    double EthparaReal = NovoEthereum * cotacaoEth;
                    view.getLblSaldoReal().setText(String.format("%.2f",EthparaReal));
                } 
            }
        } catch (SQLException e){
            JOptionPane.showMessageDialog(view, "Erro na Venda"); // Exibe uma mensagem de erro em caso de falha na venda.
        }
    }
    
    // Método para voltar à janela anterior.
    public void voltarCompra(){
        view.setVisible(false); // Esconde a janela de venda de Ethereum.
    }
}

