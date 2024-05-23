package controller;

import model.Investidor;
import view.VenderFrame;

/**
 *
 * @author Rafael Becsei
 */

public class ControllerVender {
    private VenderFrame view;
    private Investidor investidor;
    
    public ControllerVender(VenderFrame view) {
        this.view = view;
    }
    
    public void saldoFrame(){
        VenderFrame vf = new VenderFrame(investidor);
        vf.setVisible(true);
    }
    
    public void voltarCompra(){
        view.setVisible(false);
    }
}
