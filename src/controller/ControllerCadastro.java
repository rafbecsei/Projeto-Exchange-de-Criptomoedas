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
        
        if (!validarCPF(cpf) || !validarSenha(senha)) {
            JOptionPane.showMessageDialog(view, "CPF deve conter 11 dígitos e a "
                                                + "senha deve conter 6 dígitos.");
            return;
        }
        
        Investidor investidor = new Investidor(nome, cpf, senha);
        Conexao conexao = new Conexao();
        
        try{
            Connection conn = conexao.getConnection();
            InvestidorDAO dao = new InvestidorDAO(conn);
            dao.inserir(investidor);
            JOptionPane.showMessageDialog(view, "Cadastrado Realizado!");
            view.setVisible(false);
        } catch (SQLException e){
            JOptionPane.showMessageDialog(view, "Falha no Cadastrado!");
        }
    }
    private boolean validarCPF(String cpf) {
        return cpf.length() == 11 && cpf.chars().allMatch(Character::isDigit);
    }
    
    private boolean validarSenha(String senha) {
        return senha.length() == 6 && senha.chars().allMatch(Character::isDigit);
    }
}
