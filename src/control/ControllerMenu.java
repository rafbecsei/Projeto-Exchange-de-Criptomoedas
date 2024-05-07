package control;

import view.MenuFrame;



/**
 *
 * @author Rafael Becsei
 */

public class ControllerMenu {
    private MenuFrame view;
    
    public ControllerMenu(MenuFrame view) {
        this.view = view;
    }
    
    public void sairMenu(){
        view.setVisible(false);
    }
}
