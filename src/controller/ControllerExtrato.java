package controller;

import DAO.Conexao; // Importa classe para conexão com banco de dados
import DAO.InvestidorDAO; // Importa classe de acesso a dados do investidor
import java.sql.Connection; // Importa classe de conexão SQL
import java.sql.ResultSet; // Importa classe para representar conjunto de resultados SQL
import java.sql.SQLException; // Importa classe de exceção SQL
import java.text.DecimalFormat; // Importa classe para formatar números decimais
import java.text.NumberFormat; // Importa classe para formatação de números
import javax.swing.JOptionPane; // Importa classe para exibir mensagens de diálogo
import model.Investidor; // Importa classe Investidor do modelo
import view.ExtratoFrame; // Importa classe da interface gráfica de extrato

/**
 *
 * @author Rafael Becsei
 */

public class ControllerExtrato {
    private ExtratoFrame view; // Referência à interface gráfica de extrato
    private Investidor investidor; // Referência ao investidor

    // Construtor que recebe o investidor e a interface gráfica de extrato
    public ControllerExtrato(Investidor investidor, ExtratoFrame view) {
        this.view = view;
    }
    
    // Método para exibir a tela de extrato
    public void extratoFrame(Investidor investidor){
        // Cria uma nova interface gráfica de extrato com o investidor atual
        ExtratoFrame ef = new ExtratoFrame(investidor); 
        ef.setVisible(true); // Torna a nova interface gráfica visível
        this.investidor = investidor; // Define o investidor atual
    }
    
    // Método para gerar o extrato financeiro
    public void extrato(Investidor investidor){
        // Limpa o campo de texto do extrato na interface gráfica
        view.getTxtExtrato().setText(""); 
        Conexao conexao = new Conexao(); // Cria uma conexão com o banco de dados
        try{
            // Obtém a conexão com o banco de dados
            Connection conn = conexao.getConnection(); 
            // Instanciação do DAO do investidor
            InvestidorDAO dao = new InvestidorDAO(conn); 
            // Consulta a senha do investidor
            ResultSet resultado = dao.consultarSenha(investidor); 
            if(resultado.next()){ // Se a consulta retornar resultados
                int idinv = resultado.getInt("id"); // Obtém o ID do investidor
                // Consulta o ID dos registros de logs do investidor
                dao.consultaridlogsInv(); 
                
                int l = dao.consultaridlogsInv(); 
                int i = 1; // Inicializa o contador de registros
                while (i <= l) { // Itera sobre todos os registros de logs
                    // Consulta o registro de log atual
                    ResultSet res = dao.consultarExtrato(investidor, i, idinv); 
                    if (res.next()) { // Se houver resultados na consulta
                        // Obtém os dados do registro de log
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
                        // Formata os valores para exibição
                        DecimalFormat decimalFormat = new DecimalFormat("#.#####");
                        NumberFormat numberFormat = NumberFormat.getInstance();
                        numberFormat.setMaximumFractionDigits(2);
                        String fReal = numberFormat.format(Real);
                        String fBitcoin = decimalFormat.format(Bitcoin);
                        String fEthereum = decimalFormat.format(Ethereum);
                        String fRipple = decimalFormat.format(Ripple);
                        // Constrói a linha de texto do extrato
                        String texto = view.getTxtExtrato().getText();
                        String linha = transacao + " " + sinal + " " 
                                + valor + " " + moeda + " / " + "Cotacao: " 
                                + cotacao + " / " + "Taxa: " + taxa + " / " 
                                + "Saldos: " + "R$ " + fReal + " / " + "BTC " 
                                + fBitcoin + " / " + "ETH " + fEthereum + " / " 
                                + "XRP " + fRipple + " / " + data;
                        // Adiciona a linha de texto ao campo de texto do extrato
                        view.getTxtExtrato().setText(texto + "\n" + linha + "\n"); 
                    }
                    i++; // Incrementa o contador de registros
                }
            }
        } catch (SQLException e){ // Se ocorrer um erro de SQL, exibe mensagem de erro
            JOptionPane.showMessageDialog(view, "Erro no Saldo");
        }
    }
    
    // Método para voltar à tela de extrato
    public void voltarExtrato(){
        view.setVisible(false); // Esconde a interface gráfica de extrato
    }
}
