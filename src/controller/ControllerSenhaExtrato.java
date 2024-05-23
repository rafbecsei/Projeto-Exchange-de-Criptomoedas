package controller;

import DAO.Conexao;
import DAO.InvestidorDAO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Bitcoin;
import model.Carteira;
import model.Ethereum;
import model.Investidor;
import model.Moedas;
import model.Real;
import model.Ripple;
import view.ExtratoFrame;
import view.LoginFrame;
import view.SenhaExtratoFrame;

/**
 *
 * @author Rafael Becsei
 */

public class ControllerSenhaExtrato {
    private SenhaExtratoFrame view; // Referência para a interface de senha do extrato.

    // Construtor que recebe a interface de senha do extrato como parâmetro.
    public ControllerSenhaExtrato(SenhaExtratoFrame view) {
        this.view = view;
    }
    
    // Método para consultar a senha do investidor durante o processo de acesso ao extrato.
    public void consultaSenha(LoginFrame lf){
        // Cria um objeto Investidor com os dados de login inseridos.
        Investidor investidor = new Investidor(null, null, lf.getTxtCpf()
                                      .getText(), view.getTxtSenha().getText());
        Conexao conexao = new Conexao(); // Objeto para gerenciar a conexão com o banco de dados.
        
        try{
            // Estabelece a conexão com o banco de dados.
            Connection conn = conexao.getConnection(); 
            // Objeto DAO para consultar o banco de dados.
            InvestidorDAO dao = new InvestidorDAO(conn); 
            // Consulta a senha no banco de dados.
            ResultSet res = dao.consultarSenha(investidor); 
            // Verifica se há correspondência para a senha fornecida.
            if(res.next()){                
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
                // Cria uma nova janela de extrato com os detalhes do investidor e suas carteiras.
                ExtratoFrame ef = new ExtratoFrame(new Investidor(carteira, nome, 
                                                                cpf, senha));
                ef.setVisible(true); // Exibe a janela de extrato.
                view.setVisible(false); // Esconde a janela de senha do extrato.
            } else {
                // Exibe uma mensagem de erro se a senha estiver incorreta.
                JOptionPane.showMessageDialog(view, "Senha Incorreta"); 
            }
        } catch (SQLException e){
            // Exibe uma mensagem de erro em caso de falha na conexão com o banco de dados.
            JOptionPane.showMessageDialog(view, "Erro na conexão"); 
        }
    }
    
    // Método para voltar à janela anterior.
    public void voltar(){
        view.setVisible(false); // Esconde a janela de senha do extrato.
    }
}

