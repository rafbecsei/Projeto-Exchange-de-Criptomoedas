package controller;

import DAO.Conexao; // Importa classe para conexão com banco de dados
import DAO.InvestidorDAO; // Importa classe de acesso a dados do investidor
import java.sql.Connection; // Importa classe de conexão SQL
import java.sql.ResultSet; // Importa classe para representar conjunto de resultados SQL
import java.sql.SQLException; // Importa classe de exceção SQL
import javax.swing.JOptionPane; // Importa classe para exibir mensagens de diálogo
import model.Investidor; // Importa classe Investidor do modelo
import view.ComprarBitFrame; // Importa classe da interface gráfica de compra de Bitcoin

/**
 *
 * @author Rafael Becsei
 */

public class ControllerComprarBit {
    private ComprarBitFrame view; // Referência à interface gráfica de compra de Bitcoin
    private Investidor investidor; // Referência ao investidor

    // Construtor que recebe a interface gráfica de compra de Bitcoin e o investidor
    public ControllerComprarBit(ComprarBitFrame view, Investidor investidor) {
        this.view = view;
        this.investidor = investidor;
    }
    
    // Método para exibir a tela de compra de Bitcoin
    public void comprarBitFrame(){
        // Cria uma nova interface gráfica de compra de Bitcoin com o investidor atual
        ComprarBitFrame bf = new ComprarBitFrame(investidor); 
        bf.setVisible(true); // Torna a nova interface gráfica visível
    }
    
    // Método para realizar a compra de Bitcoin
    public void comprarBit(){
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
                // Obtém a quantidade de Bitcoin a comprar
                String quantiacomprarStr = view.getTxtValorBit().getText(); 
                // Converte a quantidade para double
                double quantiaComprar = Double.parseDouble(quantiacomprarStr); 
                double Bitcoin = investidor.getCarteira().getMoedas().get(1)
                        .getSaldo(); // Obtém o saldo de Bitcoin do investidor
                double cotacaoBit = investidor.getCarteira().getMoedas().get(1)
                        .getCotacao(); // Obtém a cotação do Bitcoin
                double taxaBitC = investidor.getCarteira().getMoedas().get(1)
                        .getTaxaCompra(); // Obtém a taxa de compra do Bitcoin
                double Real = investidor.getCarteira().getMoedas().get(0)
                        .getSaldo(); // Obtém o saldo de Real do investidor
                // Calcula o novo saldo de Real após a compra
                double NovoReal = Real - quantiaComprar * (1 + taxaBitC); 
                // Se o saldo de Real após a compra for negativo, exibe mensagem de saldo insuficiente
                if (NovoReal < 0){ 
                    JOptionPane.showMessageDialog(view, "Saldo Insuficiente");
                } else{ // Caso contrário
                    // Calcula a quantidade de Bitcoin a ser adquirida
                    double bitCotacao = quantiaComprar / cotacaoBit; 
                    // Calcula o novo saldo de Bitcoin após a compra
                    double NovoBitcoin = Bitcoin + bitCotacao; 
                    investidor.getCarteira().getMoedas().get(1)
                            // Atualiza o saldo de Bitcoin do investidor
                            .setSaldo(NovoBitcoin); 
                    investidor.getCarteira().getMoedas().get(0)
                            // Atualiza o saldo de Real do investidor
                            .setSaldo(NovoReal); 
                    // Atualiza o saldo de Real no banco de dados
                    dao.atualizaReal(investidor); 
                    // Atualiza o saldo de Bitcoin no banco de dados
                    dao.atualizarcompraBit(investidor); 
                    // Registra a compra de Bitcoin no extrato do investidor
                    dao.extrato(investidor, "+", "Compra Bitcoin", quantiaComprar,
                            "Bitcoin", taxaBitC, cotacaoBit, idinv); 
                    // Exibe mensagem de compra realizada com sucesso
                    JOptionPane.showMessageDialog(view, "Compra Realizado"); 
                    // Atualiza o saldo de Bitcoin na interface gráfica
                    view.getLblSaldoBitcoin().setText(String.valueOf(NovoBitcoin)); 
                }
            }
        } catch (SQLException e){ // Se ocorrer um erro de SQL, exibe mensagem de erro na compra
            JOptionPane.showMessageDialog(view, "Erro na Compra");
        }
    }
    
    // Método para voltar à tela de compra
    public void voltarCompra(){
        view.setVisible(false); // Esconde a interface gráfica de compra de Bitcoin
    }
}
