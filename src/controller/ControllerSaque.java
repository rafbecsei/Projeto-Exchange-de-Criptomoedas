// Pacote que contém as classes de controle
package controller;

import DAO.Conexao; // Importa a classe de conexão com o banco de dados
import DAO.InvestidorDAO; // Importa a classe DAO para operações relacionadas ao investidor
import javax.swing.JOptionPane; // Importa a classe JOptionPane para exibir mensagens
import java.sql.Connection; // Importa a classe Connection para conexão com o banco de dados
import java.sql.ResultSet; // Importa a classe ResultSet para manipular resultados de consultas SQL
import model.Investidor; // Importa a classe Investidor do modelo
import view.SacarFrame; // Importa a classe da interface gráfica para saque
import java.sql.SQLException; // Importa a classe SQLException para tratamento de exceções SQL

/**
 *
 * @author Rafael Becsei
 */

public class ControllerSaque {
    // Declaração das variáveis que representam a interface gráfica para saque e o investidor
    private SacarFrame view;
    private Investidor investidor;

    // Construtor que recebe a interface gráfica para saque e o investidor
    public ControllerSaque(SacarFrame view, Investidor investidor) {
        this.view = view; // Inicializa a variável de interface gráfica para saque
        this.investidor = investidor; // Inicializa a variável do investidor
    }
    
    // Método para exibir a tela de saque
    public void sacarFrame(Investidor investidor){
        SacarFrame sf = new SacarFrame(investidor); // Cria uma nova instância da tela de saque
        sf.setVisible(true); // Exibe a tela de saque
    }
    
    // Método para realizar um saque em dinheiro real
    public void SaqueReal(){
        Conexao conexao = new Conexao(); // Instancia um objeto de conexão
        try{
            // Estabelece a conexão com o banco de dados
            Connection conn = conexao.getConnection(); 
            // Instancia um objeto DAO para operações com o investidor
            InvestidorDAO dao = new InvestidorDAO(conn); 
            // Consulta a senha do investidor
            ResultSet res = dao.consultarSenha(investidor); 
            if(res.next()){ // Se houver resultados na consulta
                int idinv = res.getInt("id"); // Obtém o ID do investidor
                // Obtém a quantia a ser sacada em forma de string
                String quantiaSacadaStr = view.getTxtQuantiaSaque().getText(); 
                // Converte a quantia sacada para double
                double quantiaSacada = Double.parseDouble(quantiaSacadaStr); 
                // Obtém o saldo atual de dinheiro real do investidor
                double Real = investidor.getCarteira().getMoedas().get(0).getSaldo(); 
                // Se a quantia sacada for maior que o saldo disponível
                if (quantiaSacada > Real){ 
                    // Exibe uma mensagem informando que o valor excede o saldo
                    JOptionPane.showMessageDialog(view, "Valor Excede Saldo"); 
                } else{ // Caso contrário
                     // Calcula o novo saldo de dinheiro real após o saque
                    double NovoReal = Real - quantiaSacada;
                    // Atualiza o saldo de dinheiro real do investidor
                    investidor.getCarteira().getMoedas().get(0).setSaldo(NovoReal); 
                    // Exibe uma mensagem informando que o saque foi realizado com sucesso
                    JOptionPane.showMessageDialog(view, "Saque Realizado"); 
                    // Atualiza a exibição do novo saldo na interface gráfica
                    view.getLblNovoSaldoPessoa().setText(String.valueOf(NovoReal)); 
                    // Atualiza os dados do investidor no banco de dados
                    dao.atualizardeposito(investidor); 
                    dao.extrato(investidor, "-", "Saque", quantiaSacada, 
                            "Real", 0, 0, idinv); // Registra o saque no extrato do investidor
                }
            }
        } catch (SQLException e){ // Tratamento de exceção para erros de SQL
            // Exibe uma mensagem de erro caso ocorra uma exceção SQL
            JOptionPane.showMessageDialog(view, "Erro no Saque"); 
        }
    }
    
    // Método para voltar da tela de saque
    public void voltarSaque(){
        view.setVisible(false); // Oculta a interface gráfica de saque
    }
}
