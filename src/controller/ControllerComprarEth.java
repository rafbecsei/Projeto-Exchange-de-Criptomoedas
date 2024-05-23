package controller;

import DAO.Conexao; // Importa classe para conexão com banco de dados
import DAO.InvestidorDAO; // Importa classe de acesso a dados do investidor
import javax.swing.JOptionPane; // Importa classe para exibir mensagens de diálogo
import model.Investidor; // Importa classe Investidor do modelo
import view.ComprarEthFrame; // Importa classe da interface gráfica de compra de Ethereum
import java.sql.SQLException; // Importa classe de exceção SQL
import java.sql.Connection; // Importa classe de conexão SQL
import java.sql.ResultSet; // Importa classe para representar conjunto de resultados SQL

/**
 *
 * @author Rafael Becsei
 */

public class ControllerComprarEth {
    private ComprarEthFrame view; // Referência à interface gráfica de compra de Ethereum
    private Investidor investidor; // Referência ao investidor

    // Construtor que recebe a interface gráfica de compra de Ethereum e o investidor
    public ControllerComprarEth(ComprarEthFrame view, Investidor investidor) {
        this.view = view;
        this.investidor = investidor;
    }
    
    // Método para exibir a tela de compra de Ethereum
    public void comprarEthFrame(){
        // Cria uma nova interface gráfica de compra de Ethereum com o investidor atual
        ComprarEthFrame ef = new ComprarEthFrame(investidor); 
        ef.setVisible(true); // Torna a nova interface gráfica visível
    }
    
    // Método para realizar a compra de Ethereum
    public void comprarEth(){
        Conexao conexao = new Conexao(); // Cria uma conexão com o banco de dados
        try{
            // Obtém a conexão com o banco de dados
            Connection conn = conexao.getConnection(); 
            // Instanciação do DAO do investidor
            InvestidorDAO dao = new InvestidorDAO(conn); 
            // Consulta a senha do investidor
            ResultSet res = dao.consultarSenha(investidor); 
            if(res.next()){ // Se a consulta retornar resultados
                int idinv = res.getInt("id"); // Obtém o ID do investidor
                // Obtém a quantidade de Ethereum a comprar
                String quantiacomprarStr = view.getTxtValorBit().getText(); 
                // Converte a quantidade para double
                double quantiaComprar = Double.parseDouble(quantiacomprarStr); 
                double Ethereum = investidor.getCarteira().getMoedas().get(2)
                        .getSaldo(); // Obtém o saldo de Ethereum do investidor
                double cotacaoEth = investidor.getCarteira().getMoedas().get(2)
                        .getCotacao(); // Obtém a cotação do Ethereum
                double taxaEthC = investidor.getCarteira().getMoedas().get(2)
                        .getTaxaCompra(); // Obtém a taxa de compra do Ethereum
                double Real = investidor.getCarteira().getMoedas().get(0)
                        .getSaldo(); // Obtém o saldo de Real do investidor
                // Calcula o novo saldo de Real após a compra
                double NovoReal = Real - quantiaComprar * (1 + taxaEthC); 
                // Se o saldo de Real após a compra for negativo, exibe mensagem de saldo insuficiente
                if (NovoReal < 0){ 
                    JOptionPane.showMessageDialog(view, "Saldo Insuficiente");
                } else{ // Caso contrário
                    // Calcula a quantidade de Ethereum a ser adquirida
                    double ethCotacao = quantiaComprar / cotacaoEth; 
                    // Calcula o novo saldo de Ethereum após a compra
                    double NovoEthereum = Ethereum + ethCotacao; 
                    investidor.getCarteira().getMoedas().get(2)
                            .setSaldo(NovoEthereum); // Atualiza o saldo de Ethereum do investidor
                    investidor.getCarteira().getMoedas().get(0)
                            .setSaldo(NovoReal); // Atualiza o saldo de Real do investidor
                    // Atualiza o saldo de Real no banco de dados
                    dao.atualizaReal(investidor); 
                    // Atualiza o saldo de Ethereum no banco de dados
                    dao.atualizarcompraEth(investidor); 
                     // Registra a compra de Ethereum no extrato do investidor
                    dao.extrato(investidor, "+", "Compra Ethereum", quantiaComprar,
                            "Ethereum", taxaEthC, cotacaoEth, idinv);
                    // Exibe mensagem de compra realizada com sucesso
                    JOptionPane.showMessageDialog(view, "Compra Realizado"); 
                    // Atualiza o saldo de Ethereum na interface gráfica
                    view.getLblSaldoEthereum().setText(String.valueOf(NovoEthereum)); 
                } 
            }
        } catch (SQLException e){ // Se ocorrer um erro de SQL, exibe mensagem de erro na compra
            JOptionPane.showMessageDialog(view, "Erro na Compra");
        }
    }
    
    // Método para voltar à tela de compra
    public void voltarCompra(){
        view.setVisible(false); // Esconde a interface gráfica de compra de Ethereum
    }
}
