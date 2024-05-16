package controller;

import model.Investidor;
import view.AtualizarFrame;

/**
 *
 * @author Rafael Becsei
 */

public class ControllerAtualizar {
    private AtualizarFrame view;
    private Investidor investidor;

    public ControllerAtualizar(AtualizarFrame view, Investidor investidor) {
        this.view = view;
        this.investidor = investidor;
    }
    
    public void atualizaFrame(Investidor investidor){
        AtualizarFrame af = new AtualizarFrame(investidor);
        af.setVisible(true);
    }
    
    public void voltarAtualiza(){
        view.setVisible(false);
    }
}
