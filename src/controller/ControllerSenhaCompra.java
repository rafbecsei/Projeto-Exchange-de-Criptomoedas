//package controller;
//
//import DAO.Conexao;
//import DAO.InvestidorDAO;
//import java.sql.Connection;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import javax.swing.JOptionPane;
//import model.Bitcoin;
//import model.Carteira;
//import model.Ethereum;
//import model.Investidor;
//import model.Moedas;
//import model.Real;
//import model.Ripple;
//import view.LoginFrame;
//import view.SaldoFrame;
//import view.SenhaCompraFrame;
//
///**
// *
// * @author Rafael Becsei
// */
//
//public class ControllerSenhaCompra {
//    private SenhaCompraFrame view;
//
//    public ControllerSenhaCompra(SenhaCompraFrame view) {
//        this.view = view;
//    }
//    
//    public void consultaSenha(LoginFrame lf){
//        Investidor investidor = new Investidor(null, null, lf.getTxtCpf().getText(),
////                view.getTxtSenha().getText());
//        Conexao conexao = new Conexao();
//        
//        try{
//            Connection conn = conexao.getConnection();
//            InvestidorDAO dao = new InvestidorDAO(conn);
//            ResultSet res = dao.consultarSenha(investidor);
//            if(res.next()){                
//                String nome = res.getString("nome");
//                String cpf = res.getString("cpf");
//                String senha = res.getString("senha");
//                double Real = res.getDouble("real");
//                double Bitcoin = res.getDouble("bitcoin");
//                double Ethereum = res.getDouble("ethereum");
//                double Ripple = res.getDouble("ripple");
//                ArrayList<Moedas> moedas = new ArrayList<Moedas>();
//                moedas.add(new Real(Real));
//                moedas.add(new Bitcoin(Bitcoin));
//                moedas.add(new Ethereum(Ethereum));
//                moedas.add(new Ripple(Ripple));
//                Carteira carteira = new Carteira(moedas);
////                ComprarFrame sf = new ComprarFrame(new Investidor(carteira, nome, 
////                                                                cpf, senha));
////                sf.setVisible(true);
//                view.setVisible(false);
//            } else {
//                JOptionPane.showMessageDialog(view, "Senha Incorreta");
//            }
//        } catch (SQLException e){
//            
//            JOptionPane.showMessageDialog(view, "Erro de conexão!");
//        }
//    }
//    
//    public void voltar(){
//        view.setVisible(false);
//    }
//}
