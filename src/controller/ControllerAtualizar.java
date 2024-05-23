package controller;

import DAO.Conexao; // Importa classe de conexão com banco de dados
import DAO.InvestidorDAO; // Importa classe de acesso a dados do investidor
import java.sql.Connection; // Importa classe de conexão SQL
import java.sql.ResultSet; // Importa classe para representar conjunto de resultados SQL
import java.sql.SQLException; // Importa classe de exceção SQL
import java.util.Random; // Importa classe para gerar números aleatórios
import javax.swing.JOptionPane; // Importa classe para exibir mensagens de diálogo
import model.Investidor; // Importa classe Investidor do modelo
import view.AtualizarFrame; // Importa classe da interface gráfica para atualização
import view.LoginFrame; // Importa classe da interface gráfica de login

/**
 *
 * @author Rafael Becsei
 */

public class ControllerAtualizar {
    private AtualizarFrame view; // Referência à interface gráfica de atualização
    private Investidor investidor; // Referência ao investidor logado
    private LoginFrame lf; // Referência à interface gráfica de login

    // Construtor que recebe a interface gráfica de atualização e o investidor
    public ControllerAtualizar(AtualizarFrame view, Investidor investidor) {
        this.view = view;
        this.investidor = investidor;
    }
    
    // Método para atualizar a interface gráfica com o investidor atual
    public void atualizaFrame(Investidor investidor){
        AtualizarFrame af = new AtualizarFrame(investidor, lf);
        af.setVisible(true);
    } 

    // Método para atualizar as cotações das moedas
    public void atualizaCotacao(){
        Conexao conexao = new Conexao(); // Criação de uma conexão com o banco de dados
        Random rand = new Random(); // Instanciação de um gerador de números aleatórios
        
        try{
            // Obtém a conexão com o banco de dados
            Connection conn = conexao.getConnection(); 
            // Instanciação do DAO do investidor
            InvestidorDAO dao = new InvestidorDAO(conn); 
            // Consulta a senha do investidor
            ResultSet res = dao.consultarSenha(investidor); 
            if(res.next()){ // Se a consulta retornar resultados
                // Obtém as cotações atuais das moedas
                double cotacaoBit = res.getDouble("cotacaoBit");
                double cotacaoEth = res.getDouble("cotacaoEth");
                double cotacaoRip = res.getDouble("cotacaoRip");
                // Calcula a atualização das cotações com variações aleatórias
                double atualizacaoBit = (rand.nextDouble() * 0.1 - 0.05) * cotacaoBit;
                double atualizacaoEth = (rand.nextDouble() * 0.1 - 0.05) * cotacaoEth;
                double atualizacaoRip = (rand.nextDouble() * 0.1 - 0.05) * cotacaoRip;
                // Aplica as atualizações nas cotações
                cotacaoBit += atualizacaoBit;
                cotacaoEth += atualizacaoEth;
                cotacaoRip += atualizacaoRip;
                // Arredonda as cotações para duas casas decimais
                cotacaoBit = Math.round(cotacaoBit * 100.0) / 100.0;
                cotacaoEth = Math.round(cotacaoEth * 100.0) / 100.0;
                cotacaoRip = Math.round(cotacaoRip * 100.0) / 100.0;
                // Atualiza as cotações no investidor e no banco de dados
                investidor.getCarteira().getMoedas().get(1)
                                                        .setCotacao(cotacaoBit);
                investidor.getCarteira().getMoedas().get(2)
                                                        .setCotacao(cotacaoEth);
                investidor.getCarteira().getMoedas().get(3)
                                                        .setCotacao(cotacaoRip);
                dao.atualizaCotacao(investidor); // Atualiza as cotações no banco de dados
                // Exibe mensagem de cotação atualizada e atualiza a interface gráfica
                JOptionPane.showMessageDialog(view, "Cotação Atualizada");
                view.getLblcotacaoBitAtual().setText(String.format("%.2f",  
                                                                cotacaoBit));
                view.getLblcotacaoEthAtual().setText(String.format("%.2f", 
                                                                cotacaoEth));
                view.getLblcotacaoRipAtual().setText(String.format("%.2f", 
                                                                   cotacaoRip));
            } else { // Se a consulta não retornar resultados, exibe mensagem de erro
                JOptionPane.showMessageDialog(view, "Erro");
            }
          // Se ocorrer um erro de SQL, exibe mensagem de erro de conexão
        } catch (SQLException e){ 
            JOptionPane.showMessageDialog(view, "Erro de conexão");
        }
    }
    
    // Método para voltar à tela de atualização
    public void voltarAtualiza(){
        view.setVisible(false); // Esconde a interface gráfica de atualização
    }
}
