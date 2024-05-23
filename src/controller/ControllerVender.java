package controller;

import model.Investidor;
import view.VenderFrame;

/**
 *
 * @author Rafael Becsei
 */

public class ControllerVender {
    private VenderFrame view; // Referência para a interface de venda.
    private Investidor investidor; // Objeto Investidor que será utilizado na venda.

    // Construtor que recebe a interface de venda como parâmetro.
    public ControllerVender(VenderFrame view) {
        this.view = view; // Inicializa a referência para a interface de venda.
    }
    
    // Método para abrir a janela de venda.
    public void saldoFrame(){
        // Cria uma nova janela de venda com os detalhes do investidor.
        VenderFrame vf = new VenderFrame(investidor);
        vf.setVisible(true); // Exibe a janela de venda.
    }
    
    // Método para voltar à janela anterior.
    public void voltarCompra(){
        view.setVisible(false); // Esconde a janela de venda atual.
    }
}

