package controller;

import DAO.Conexao; // Importa classe para conexão com banco de dados
import DAO.InvestidorDAO; // Importa classe de acesso a dados do investidor
import javax.swing.JOptionPane; // Importa classe para exibir mensagens de diálogo
import model.Investidor; // Importa classe Investidor do modelo
import java.sql.Connection; // Importa classe de conexão SQL
import java.sql.ResultSet; // Importa classe para representar conjunto de resultados SQL
import java.sql.SQLException; // Importa classe de exceção SQL
import view.ComprarRipFrame; // Importa classe da interface gráfica de compra de Ripple

/**
 *
 * @author Rafael Becsei
 */

public class ControllerComprarRip {
    private ComprarRipFrame view; // Referência à interface gráfica de compra de Ripple
    private Investidor investidor; // Referência ao investidor

    // Construtor que recebe a interface gráfica de compra de Ripple e o investidor
    public ControllerComprarRip(ComprarRipFrame view, Investidor investidor) {
        this.view = view;
        this.investidor = investidor;
    }
    
    // Método para exibir a tela de compra de Ripple
    public void comprarRipFrame(){
        // Cria uma nova interface gráfica de compra de Ripple com o investidor atual
        ComprarRipFrame rf = new ComprarRipFrame(investidor); 
        rf.setVisible(true); // Torna a nova interface gráfica visível
    }
    
    // Método para realizar a compra de Ripple
    public void comprarRip(){
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
                // Obtém a quantidade de Ripple a comprar
                String quantiacomprarStr = view.getTxtValorBit().getText(); 
                // Converte a quantidade para double
                double quantiaComprar = Double.parseDouble(quantiacomprarStr); 
                double Ripple = investidor.getCarteira().getMoedas().get(3)
                        .getSaldo(); // Obtém o saldo de Ripple do investidor
                double cotacaoRip = investidor.getCarteira().getMoedas().get(3)
                        .getCotacao(); // Obtém a cotação do Ripple
                double taxaRipC = investidor.getCarteira().getMoedas().get(3)
                        .getTaxaCompra(); // Obtém a taxa de compra do Ripple
                double Real = investidor.getCarteira().getMoedas().get(0)
                        .getSaldo(); // Obtém o saldo de Real do investidor
                 // Calcula o novo saldo de Real após a compra
                double NovoReal = Real - quantiaComprar * (1 + taxaRipC);
                // Se o saldo de Real após a compra for negativo, exibe mensagem de saldo insuficiente
                if (NovoReal < 0){ 
                    JOptionPane.showMessageDialog(view, "Saldo Insuficiente");
                } else{ // Caso contrário
                    // Calcula a quantidade de Ripple a ser adquirida
                    double ripCotacao = quantiaComprar / cotacaoRip; 
                    // Calcula o novo saldo de Ripple após a compra
                    double NovoRipple = Ripple + ripCotacao; 
                    investidor.getCarteira().getMoedas().get(3)
                            .setSaldo(NovoRipple); // Atualiza o saldo de Ripple do investidor
                    investidor.getCarteira().getMoedas().get(0)
                            .setSaldo(NovoReal); // Atualiza o saldo de Real do investidor
                    // Atualiza o saldo de Real no banco de dados
                    dao.atualizaReal(investidor); 
                    // Atualiza o saldo de Ripple no banco de dados
                    dao.atualizarcompraRip(investidor); 
                    // Registra a compra de Ripple no extrato do investidor
                    dao.extrato(investidor, "+", "Compra Ripple", quantiaComprar,
                            "Ripple", taxaRipC, cotacaoRip, idinv); 
                    // Exibe mensagem de compra realizada com sucesso
                    JOptionPane.showMessageDialog(view, "Compra Realizado"); 
                    // Atualiza o saldo de Ripple na interface gráfica
                    view.getLblSaldoRipple().setText(String.valueOf(NovoRipple)); 
                } 
            }
        } catch (SQLException e){ // Se ocorrer um erro de SQL, exibe mensagem de erro na compra
            JOptionPane.showMessageDialog(view, "Erro na Compra");
        }
    }
    
    // Método para voltar à tela de compra
    public void voltarCompra(){
        view.setVisible(false); // Esconde a interface gráfica de compra de Ripple
    }
}
