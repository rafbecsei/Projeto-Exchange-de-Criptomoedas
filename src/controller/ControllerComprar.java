package controller;

import model.Investidor; // Importa classe Investidor do modelo
import view.ComprarFrame; // Importa classe da interface gráfica de compra

/**
 *
 * @author Rafael Becsei
 */

public class ControllerComprar {
    private ComprarFrame view; // Referência à interface gráfica de compra
    private Investidor investidor; // Referência ao investidor

    // Construtor que recebe a interface gráfica de compra
    public ControllerComprar(ComprarFrame view) {
        this.view = view;
    }
    
    // Método para exibir o saldo do investidor
    public void saldoFrame(){
        // Cria uma nova interface gráfica de compra com o investidor atual
        ComprarFrame cf = new ComprarFrame(investidor); 
        cf.setVisible(true); // Torna a nova interface gráfica visível
    }
    
    // Método para voltar à tela de compra
    public void voltarCompra(){
        view.setVisible(false); // Esconde a interface gráfica de compra
    }
}
