package controller;

import DAO.InvestidorDAO; // Importa classe DAO para acessar dados do investidor
import DAO.Conexao; // Importa classe para conexão com banco de dados
import view.CadastroFrame; // Importa classe da interface gráfica de cadastro
import java.sql.Connection; // Importa classe de conexão SQL
import javax.swing.JOptionPane; // Importa classe para exibir mensagens de diálogo
import java.sql.SQLException; // Importa classe de exceção SQL
import model.Investidor; // Importa classe Investidor do modelo

/**
 *
 * @author Rafael Becsei
 */
public class ControllerCadastro {
    private CadastroFrame view; // Referência à interface gráfica de cadastro

    // Construtor que recebe a interface gráfica de cadastro
    public ControllerCadastro(CadastroFrame view) {
        this.view = view;
    }
    
    // Método para voltar à tela de cadastro
    public void voltarCadastro(){
        view.setVisible(false);
    }
    
    // Método para realizar o cadastro de um novo investidor
    public void cadastrarPessoa(){
        String nome = view.getTxtNome().getText();
        String cpf = view.getTxtCpf().getText();
        String senha = view.getTxtSenha().getText();
        
        // Validação do CPF e da senha
        if (!validarCPF(cpf) || !validarSenha(senha)) {
            JOptionPane.showMessageDialog(view, "CPF deve conter 11 dígitos e a "
                                                + "senha deve conter 6 dígitos");
            return;
        }
        
        // Cria um novo investidor com os dados informados
        Investidor investidor = new Investidor(nome, cpf, senha);
        Conexao conexao = new Conexao(); // Cria uma conexão com o banco de dados
        
        try{
            // Obtém a conexão com o banco de dados
            Connection conn = conexao.getConnection(); 
            // Instanciação do DAO do investidor
            InvestidorDAO dao = new InvestidorDAO(conn); 
            dao.inserir(investidor); // Insere o investidor no banco de dados
            // Exibe mensagem de cadastro realizado
            JOptionPane.showMessageDialog(view, "Cadastrado Realizado"); 
            view.setVisible(false); // Esconde a interface gráfica de cadastro
            // Se ocorrer um erro de SQL, exibe mensagem de falha no cadastro
        } catch (SQLException e){ 
            JOptionPane.showMessageDialog(view, "Falha no Cadastrado");
        }
    }
    
    // Método privado para validar o CPF
    private boolean validarCPF(String cpf) {
        return cpf.length() == 11 && cpf.chars().allMatch(Character::isDigit);
    }
    
    // Método privado para validar a senha
    private boolean validarSenha(String senha) {
        return senha.length() == 6 && senha.chars().allMatch(Character::isDigit);
    }
}
