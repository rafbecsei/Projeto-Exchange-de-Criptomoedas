package control;

import DAO.PessoaDAO;
import DAO.Conexao;
import model.Pessoa;
import view.CadastroFrame;
import java.sql.Connection;
import javax.swing.JOptionPane;
import java.sql.SQLException;

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
        
        Pessoa pessoa = new Pessoa(nome, cpf, senha);
        Conexao conexao = new Conexao();
        
        try{
            Connection conn = conexao.getConnection();
            System.out.println("Conectado");
            PessoaDAO dao = new PessoaDAO(conn);
            dao.inserir(pessoa);
            JOptionPane.showMessageDialog(view, "Cadastrado Realizado!");
            view.setVisible(false);
        } catch (SQLException e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(view, "Falha no Cadastrado!");
        }
    }
}
