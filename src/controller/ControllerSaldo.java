package controller;


import model.Investidor;
import view.SaldoFrame;



/**
 *
 * @author Rafael Becsei
 */

public class ControllerSaldo {
    private SaldoFrame view;
    private Investidor investidor;
//    Nao sei se ta certo ^
    
    public ControllerSaldo(SaldoFrame view) {
        this.view = view;
    }
    
    public void saldoFrame(){
        SaldoFrame sc = new SaldoFrame(investidor);
        sc.setVisible(true);
    }
    
    public void voltarSaldo(){
        view.setVisible(false);
    }
}



