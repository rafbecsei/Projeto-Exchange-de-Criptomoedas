package controller;

import DAO.Conexao;
import DAO.InvestidorDAO;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.Investidor;
import view.VenderFrame;
import view.LoginFrame;

/**
 *
 * @author Rafael Becsei
 */

public class ControllerVender {
    private VenderFrame view;
    private Investidor investidor;
    private LoginFrame lf;
    
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
