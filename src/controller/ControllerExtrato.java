package controller;

import view.ExtratoFrame;

/**
 *
 * @author Rafael Becsei
 */

public class ControllerExtrato {
    private ExtratoFrame view;
    
    public ControllerExtrato(ExtratoFrame view) {
        this.view = view;
    }
    
    public void extratoFrame(){
        ExtratoFrame ef = new ExtratoFrame();
        ef.setVisible(true);
    }
    
    public void voltarExtrato(){
        view.setVisible(false);
    }
}
