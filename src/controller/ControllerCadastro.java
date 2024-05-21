package controller;

import DAO.InvestidorDAO;
import DAO.Conexao;
import view.CadastroFrame;
import java.sql.Connection;
import javax.swing.JOptionPane;
import java.sql.SQLException;
import model.Investidor;

/**
 *
 * @author Rafael Becsei
 */

public class ControllerCadastro {
    private CadastroFrame view;

    public ControllerCadastro(CadastroFrame view) {
        this.view = view;
    }
    
    public void voltarCadastro(){
        view.setVisible(false);
    }
    
    
    public void cadastrarPessoa(){
        String nome = view.getTxtNome().getText();
        String cpf = view.getTxtCpf().getText();
        String senha = view.getTxtSenha().getText();
        
        Investidor investidor = new Investidor(nome, cpf, senha);
        Conexao conexao = new Conexao();
        
        try{
            Connection conn = conexao.getConnection();
            InvestidorDAO dao = new InvestidorDAO(conn);
            dao.inserir(investidor);
            JOptionPane.showMessageDialog(view, "Cadastrado Realizado!");
            view.setVisible(false);
        } catch (SQLException e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(view, "Falha no Cadastrado!");
        }
    }
}
