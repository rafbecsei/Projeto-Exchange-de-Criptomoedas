// Pacote controller contendo classes responsáveis pela lógica de controle.
package controller;

import DAO.InvestidorDAO; // Importa o DAO responsável pela interação com a entidade Investidor.
import DAO.Conexao; // Importa a classe de conexão com o banco de dados.
import java.sql.Connection; // Importa a classe para gerenciar conexões com o banco de dados.
import java.sql.ResultSet; // Importa a classe para representar um conjunto de resultados de banco de dados.
import javax.swing.JOptionPane; // Importa a classe para exibição de caixas de diálogo.
import java.sql.SQLException; // Importa a classe para tratamento de exceções relacionadas a SQL.
import java.util.ArrayList; // Importa a classe para manipulação de listas.
import model.Bitcoin; // Importa a classe representando a moeda Bitcoin.
import model.Carteira; // Importa a classe representando a carteira do investidor.
import model.Ethereum; // Importa a classe representando a moeda Ethereum.
import model.Investidor; // Importa a classe representando um investidor.
import model.Moedas; // Importa a classe representando uma moeda genérica.
import model.Real; // Importa a classe representando a moeda Real.
import model.Ripple; // Importa a classe representando a moeda Ripple.
import view.ComprarFrame; // Importa a classe da interface de compra.
import view.LoginFrame; // Importa a classe da interface de login.
import view.SenhaCompraFrame; // Importa a classe da interface de senha de compra.

/**
 *
 * @author Rafael Becsei
 */

// Controlador responsável pela senha de compra do investidor.
public class ControllerSenhaCompra {
    private SenhaCompraFrame view;

    // Construtor que recebe a interface de senha de compra como parâmetro.
    public ControllerSenhaCompra(SenhaCompraFrame view) {
        this.view = view;
    }
    
    // Método para consultar a senha do investidor durante o processo de compra.
    public void consultaSenha(LoginFrame lf){
        // Cria um objeto Investidor com os dados de login inseridos.
        Investidor investidor = new Investidor(null, null, lf.getTxtCpf()
                                    .getText(), view.getTxtSenha().getText());
        Conexao conexao = new Conexao();
        
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
                // Cria uma nova janela de compra com os detalhes do investidor e suas carteiras.
                ComprarFrame cf = new ComprarFrame(new Investidor(carteira, 
                                                            nome, cpf, senha));
                cf.setVisible(true); // Exibe a janela de compra.
                view.setVisible(false); // Esconde a janela de senha de compra.
            } else {
                JOptionPane.showMessageDialog(view, "Senha Incorreta");
            }
        } catch (SQLException e){
            JOptionPane.showMessageDialog(view, "Erro na conexão");
        }
    }
    
    // Método para voltar à janela anterior.
    public void voltar(){
        view.setVisible(false);
    }
}

