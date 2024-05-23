package controller;

import DAO.Conexao; // Importa classe para conexão com banco de dados
import DAO.InvestidorDAO; // Importa classe de acesso a dados do investidor
import java.sql.Connection; // Importa classe de conexão SQL
import java.sql.ResultSet; // Importa classe para representar conjunto de resultados SQL
import javax.swing.JOptionPane; // Importa classe para exibir mensagens de diálogo
import model.Investidor; // Importa classe Investidor do modelo
import view.DepositoFrame; // Importa classe da interface gráfica de depósito
import java.sql.SQLException; // Importa classe de exceção SQL

/**
 *
 * @author Rafael Becsei
 */

public class ControllerDeposito {
    private DepositoFrame view; // Referência à interface gráfica de depósito
    private Investidor investidor; // Referência ao investidor

    // Construtor que recebe a interface gráfica de depósito e o investidor
    public ControllerDeposito(DepositoFrame view, Investidor investidor) {
        this.view = view;
        this.investidor = investidor;
    }
    
    // Método para exibir a tela de depósito
    public void depositoFrame(Investidor investidor){
        // Cria uma nova interface gráfica de depósito com o investidor atual
        DepositoFrame df = new DepositoFrame(investidor); 
        // Torna a nova interface gráfica visível
        df.setVisible(true); 
    }
    
    // Método para realizar o depósito de dinheiro
    public void depositoReal(){
        // Cria uma conexão com o banco de dados
        Conexao conexao = new Conexao(); 
        try{
            // Obtém a conexão com o banco de dados
            Connection conn = conexao.getConnection(); 
            // Instanciação do DAO do investidor
            InvestidorDAO dao = new InvestidorDAO(conn); 
            // Consulta a senha do investidor
            ResultSet res = dao.consultarSenha(investidor); 
            if(res.next()){ // Se a consulta retornar resultados
                int idinv = res.getInt("id"); // Obtém o ID do investidor
                String quantiaDepositadaStr = view.getTxtquantiaDeposito()
                        .getText(); // Obtém a quantidade depositada
                // Converte a quantidade para double
                double quantiaDepositada = Double.parseDouble(quantiaDepositadaStr); 
                double Real = investidor.getCarteira().getMoedas().get(0)
                        .getSaldo(); // Obtém o saldo de Real do investidor
                // Calcula o novo saldo de Real após o depósito
                double NovoReal = Real + quantiaDepositada; 
                 // Atualiza o saldo de Real do investidor
                investidor.getCarteira().getMoedas().get(0).setSaldo(NovoReal);
                // Atualiza o saldo de Real no banco de dados
                dao.atualizardeposito(investidor); 
                dao.extrato(investidor, "+", "Deposito", quantiaDepositada, 
                        "Real", 0, 0, idinv); // Registra o depósito no extrato do investidor
                // Exibe mensagem de depósito realizado com sucesso
                JOptionPane.showMessageDialog(view, "Depósito Realizado"); 
                // Atualiza o saldo de Real na interface gráfica
                view.getLblNovoSaldoPessoa().setText(String.valueOf(NovoReal)); 
            }
        } catch (SQLException e){ // Se ocorrer um erro de SQL, exibe mensagem de erro no depósito
            JOptionPane.showMessageDialog(view, "Erro no Depósito");
        }
    }
    
    // Método para voltar à tela de depósito
    public void voltarDeposito(){
        view.setVisible(false); // Esconde a interface gráfica de depósito
    }
}
