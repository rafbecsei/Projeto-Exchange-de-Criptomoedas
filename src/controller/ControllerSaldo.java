// Pacote que contém as classes de controle
package controller;


import model.Investidor; // Importa a classe Investidor do modelo
import view.SaldoFrame; // Importa a classe da interface gráfica de saldo

/**
 *
 * @author Rafael Becsei
 */

public class ControllerSaldo {

    // Declaração das variáveis que representam a interface gráfica de saldo e o investidor
    private SaldoFrame view;
    private Investidor investidor;
    
    // Construtor que recebe a interface gráfica de saldo
    public ControllerSaldo(SaldoFrame view) {
        this.view = view; // Inicializa a variável de interface gráfica de saldo
    }
    
    // Método para exibir a tela de saldo
    public void saldoFrame(){
        SaldoFrame sf = new SaldoFrame(investidor); // Cria uma nova instância da tela de saldo
        sf.setVisible(true); // Exibe a tela de saldo
    }
    
    // Método para voltar da tela de saldo
    public void voltarSaldo(){
        view.setVisible(false); // Oculta a interface gráfica de saldo
    }
}




