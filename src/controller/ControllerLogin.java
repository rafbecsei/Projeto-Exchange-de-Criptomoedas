// Pacote que contém as classes de controle
package controller;

import DAO.InvestidorDAO;// Importa classe de acesso a dados do investidor
import DAO.Conexao;// Importa classe para conexão com o banco de dados
import view.LoginFrame;// Importa classe da interface gráfica de login
import java.sql.Connection;// Importa classe de conexão SQL
import java.sql.ResultSet;// Importa classe para representar conjunto de resultados SQL
import javax.swing.JOptionPane;// Importa classe para exibir mensagens de diálogo
import java.sql.SQLException;// Importa classe de exceção SQL
import java.util.ArrayList;// Importa classe para trabalhar com listas
import model.Bitcoin;// Importa classe do modelo Bitcoin
import model.Carteira;// Importa classe do modelo Carteira
import model.Ethereum;// Importa classe do modelo Ethereum
import model.Investidor;// Importa classe do modelo Investidor
import model.Moedas;// Importa classe do modelo Moedas
import model.Real;// Importa classe do modelo Real
import model.Ripple;// Importa classe do modelo Ripple
import view.MenuFrame;// Importa classe da interface gráfica do menu

/**
 *
 * @author Rafael Becsei
 */

public class ControllerLogin {

    // Declaração da variável que representa a interface gráfica de login
    private LoginFrame view;

    // Construtor que recebe a interface gráfica de login
    public ControllerLogin(LoginFrame view) {
        this.view = view; // Inicializa a variável de interface gráfica
    }
    
    // Método para realizar o login do usuário
    public void loginPessoa(){

        // Cria um objeto Investidor com os dados de CPF e senha
        Investidor investidor = new Investidor(null, view.getTxtCpf().getText(),
                                                view.getTxtSenha().getText());
                                                
        // Cria uma conexão com o banco de dados
        Conexao conexao = new Conexao();
        
        // Tenta estabelecer a conexão e realizar a consulta no banco de dados
        try{
            // Obtém a conexão com o banco de dados
            Connection conn = conexao.getConnection();
            
            // Cria um objeto DAO para interagir com a tabela de investidores
            InvestidorDAO dao = new InvestidorDAO(conn);
            
            // Realiza a consulta para verificar se o usuário existe no banco de dados
            ResultSet res = dao.consultarSenha(investidor);
            
            // Se o usuário existir, exibe uma mensagem de login feito e recupera seus dados
            if(res.next()){
                JOptionPane.showMessageDialog(view, "Login Feito");
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
                
                // Cria uma lista de moedas com os saldos e cotações recuperados
                ArrayList<Moedas> moedas = new ArrayList<>();
                moedas.add(new Real(Real, 0));
                moedas.add(new Bitcoin(Bitcoin, cotacaoBit));
                moedas.add(new Ethereum(Ethereum, cotacaoEth));
                moedas.add(new Ripple(Ripple, cotacaoRip));
                
                // Cria uma carteira com as moedas do usuário
                Carteira carteira = new Carteira(moedas);
                
                // Direciona o usuário para o menu, passando as informações do investidor
                MenuFrame mf = new MenuFrame(view, new Investidor(carteira, 
                                                            nome, cpf, senha));
                mf.setVisible(true);
                view.setVisible(false);
            } else {
                JOptionPane.showMessageDialog(view, "Erro no Login");
            }
        } catch (SQLException e){
            JOptionPane.showMessageDialog(view, "Erro na conexão");
        }
    }
}
