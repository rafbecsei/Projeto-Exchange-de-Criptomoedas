package controller;

import model.Investidor;
import view.DepositoFrame;

/**
 *
 * @author Rafael Becsei
 */

public class ControllerDeposito {
    private DepositoFrame view;

    public ControllerDeposito(DepositoFrame view) {
        this.view = view;
    }
    
    public void depositoFrame(Investidor investidor){
        DepositoFrame df = new DepositoFrame(investidor);
        df.setVisible(true);
    }
    
    public void voltarDeposito(){
        view.setVisible(false);
    }
}
