
package controller;

import DAO.InvestidorDAO;
import DAO.Conexao;
import java.sql.Connection;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Bitcoin;
import model.Carteira;
import model.Ethereum;
import model.Investidor;
import model.Moedas;
import model.Real;
import model.Ripple;
import view.LoginFrame;
import view.SaldoFrame;
import view.SenhaSaldoFrame;

/**
 *
 * @author Rafael Becsei
 */

public class ControllerSenhaSaldo {
    private SenhaSaldoFrame view; // Referência para a interface de senha do saldo.

    // Construtor que recebe a interface de senha do saldo como parâmetro.
    public ControllerSenhaSaldo(SenhaSaldoFrame view) {
        this.view = view; // Inicializa a referência para a interface de senha do saldo.
    }
    
    // Método para consultar a senha do investidor durante o processo de acesso ao saldo.
    public void consultaSenha(LoginFrame lf){
        // Cria um objeto Investidor com os dados de login inseridos.
        Investidor investidor = new Investidor(null, null, lf.getTxtCpf()
                                    .getText(), view.getTxtSenha().getText());
        Conexao conexao = new Conexao(); // Objeto para gerenciar a conexão com o banco de dados.
        try{
            Connection conn = conexao.getConnection(); // Estabelece a conexão com o banco de dados.
            InvestidorDAO dao = new InvestidorDAO(conn); // Objeto DAO para consultar o banco de dados.
            ResultSet res = dao.consultarSenha(investidor); // Consulta a senha no banco de dados.
            if(res.next()){ // Verifica se há correspondência para a senha fornecida.
                // Extrai os dados do investidor do resultado da consulta.
                String nome = res.getString("nome");
                String cpf = res.getString("cpf");
                String senha = res.getString("senha");
                double Real = res.getDouble("real");
                double Bitcoin = res.getDouble("bitcoin");
                double Ethereum = res.getDouble("ethereum");
                double Ripple = res.getDouble("ripple");
                double cotacaoBit = res.getDouble("cotacaoBit");
                double cotacaoEth = res.getDouble("cotacaoEth");
                double cotacaoRip = res.getDouble("cotacaoRip");
                // Cria uma lista de moedas com os dados recuperados do banco de dados.
                ArrayList<Moedas> moedas = new ArrayList<>();
                moedas.add(new Real(Real, 0));
                moedas.add(new Bitcoin(Bitcoin, cotacaoBit));
                moedas.add(new Ethereum(Ethereum, cotacaoEth));
                moedas.add(new Ripple(Ripple, cotacaoRip));
                // Cria uma carteira com as moedas do investidor.
                Carteira carteira = new Carteira(moedas);
                // Cria uma nova janela de saldo com os detalhes do investidor e suas carteiras.
                SaldoFrame sf = new SaldoFrame(new Investidor(carteira, nome, 
                                                                cpf, senha));
                sf.setVisible(true); // Exibe a janela de saldo.
                view.setVisible(false); // Esconde a janela de senha do saldo.
            } else {
                JOptionPane.showMessageDialog(view, "Senha Incorreta"); // Exibe uma mensagem de erro se a senha estiver incorreta.
            }
        } catch (SQLException e){
            JOptionPane.showMessageDialog(view, "Erro na conexão"); // Exibe uma mensagem de erro em caso de falha na conexão com o banco de dados.
        }
    }
    
    // Método para voltar à janela anterior.
    public void voltar(){
        view.setVisible(false); // Esconde a janela de senha do saldo.
    }
}

