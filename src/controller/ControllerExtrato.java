package controller;

import model.Investidor;
import view.ExtratoFrame;

/**
 *
 * @author Rafael Becsei
 */

public class ControllerExtrato {
    private ExtratoFrame view;
    private Investidor investidor;
    
    public ControllerExtrato(ExtratoFrame view) {
        this.view = view;
    }
    
    public void extratoFrame(){
        ExtratoFrame ef = new ExtratoFrame(investidor);
        ef.setVisible(true);
    }
    
    public void voltarExtrato(){
        view.setVisible(false);
    }
}
