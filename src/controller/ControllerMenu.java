package controller;


import view.LoginFrame;
import view.MenuFrame;


/**
 *
 * @author Rafael Becsei
 */

public class ControllerMenu {
    private MenuFrame view;
    
    public ControllerMenu() {
        this.view = view;
    }
    
    public void voltarMenu(){
        LoginFrame e = new LoginFrame();
        e.setVisible(true);
        view.setVisible(false);
    }
    
}
