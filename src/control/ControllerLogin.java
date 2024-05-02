package control;
import model.Usuario;
import view.LoginFrame;

/**
 *
 * @author Rafael Becsei
 */

public class ControllerLogin {
    private LoginFrame view;
    
    public ControllerLogin(LoginFrame view) {
        this.view = view;
    }
    
    public void loginUsuario(){
        Usuario usuario = new Usuario(view.getTxtCPF().getText(),
                                      view.getTxtSenha().getText());
    }
}
