package controller;

import model.Investidor;
import view.ComprarFrame;
import view.LoginFrame;

/**
 *
 * @author Rafael Becsei
 */

public class ControllerComprar {
    private ComprarFrame view;
    private Investidor investidor;

    public ControllerComprar(ComprarFrame view) {
        this.view = view;
    }
    
    public void saldoFrame(){
        ComprarFrame cf = new ComprarFrame(investidor);
        cf.setVisible(true);
    }
    
    public void voltarCompra(){
        view.setVisible(false);
    }
    
}
