package control;

import model.Pessoa;
import view.MenuFrame;
import view.SaldoFrame;

/**
 *
 * @author Rafael Becsei
 */

public class ControllerMenu {
    private MenuFrame view;
    
    public ControllerMenu(MenuFrame view, Pessoa pessoa) {
        this.view = view;
    }
    
    public void sairMenu(){
        view.setVisible(false);
    }
    
}
