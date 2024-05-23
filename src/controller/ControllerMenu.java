// Pacote que contém as classes de controle
package controller;


import view.MenuFrame; // Importa classe da interface gráfica do menu

/**
 *
 * @author Rafael Becsei
 */

public class ControllerMenu {

    // Declaração da variável que representa a interface gráfica do menu
    private MenuFrame view;
    
    // Construtor que recebe a interface gráfica do menu
    public ControllerMenu(MenuFrame view) {
        this.view = view; // Inicializa a variável de interface gráfica
    }
    
    // Método para fechar a tela do menu
    public void voltar(){
        view.setVisible(false); // Oculta a interface gráfica do menu
    }
    
}
