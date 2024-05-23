package view;

import controller.ControllerMenu;
import model.Investidor;

/**
 *
 * @author Rafael Becsei
 */

public class MenuFrame extends javax.swing.JFrame {
    private MenuFrame view;
    private LoginFrame lf;
    private Investidor investidor;

    public MenuFrame(LoginFrame lf, Investidor investidor) {
        initComponents();
        controller = new ControllerMenu(this);
        this.lf = lf;
        this.investidor = investidor;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblLogin = new javax.swing.JLabel();
        btConsultaSaldo = new javax.swing.JButton();
        btConsultaExtrato = new javax.swing.JButton();
        btDeposito = new javax.swing.JButton();
        btSaque = new javax.swing.JButton();
        btCompra = new javax.swing.JButton();
        btVenda = new javax.swing.JButton();
        btAtualiza = new javax.swing.JButton();
        btSair = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblLogin.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblLogin.setText("                                     MENU                                  ");
        lblLogin.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btConsultaSaldo.setText("CONSULTAR SALDO");
        btConsultaSaldo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btConsultaSaldoActionPerformed(evt);
            }
        });

        btConsultaExtrato.setText("CONSULTAR EXTRATO");
        btConsultaExtrato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btConsultaExtratoActionPerformed(evt);
            }
        });

        btDeposito.setText("DEPOSITAR");
        btDeposito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDepositoActionPerformed(evt);
            }
        });

        btSaque.setText("SACAR");
        btSaque.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSaqueActionPerformed(evt);
            }
        });

        btCompra.setText("COMPRAR CRIPTOMOEDA");
        btCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCompraActionPerformed(evt);
            }
        });

        btVenda.setText("VENDER CRIPTOMOEDA");
        btVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btVendaActionPerformed(evt);
            }
        });

        btAtualiza.setText("ATUALIZAR COTAÇÃO");
        btAtualiza.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAtualizaActionPerformed(evt);
            }
        });

        btSair.setText("VOLTAR");
        btSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSairActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblLogin, javax.swing.GroupLayout.DEFAULT_SIZE, 430, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btConsultaSaldo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btConsultaExtrato, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btDeposito, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btSaque, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btCompra, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
                    .addComponent(btVenda, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btAtualiza, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(152, 152, 152)
                .addComponent(btSair, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lblLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addComponent(btConsultaSaldo, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btConsultaExtrato, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btDeposito, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btSaque, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addComponent(btCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btAtualiza, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btSair, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btConsultaSaldoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btConsultaSaldoActionPerformed
        SenhaSaldoFrame sf = new SenhaSaldoFrame(lf);
        sf.setVisible(true);
    }//GEN-LAST:event_btConsultaSaldoActionPerformed

    private void btConsultaExtratoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btConsultaExtratoActionPerformed
        SenhaExtratoFrame ef = new SenhaExtratoFrame(lf);
        ef.setVisible(true);
    }//GEN-LAST:event_btConsultaExtratoActionPerformed

    private void btDepositoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDepositoActionPerformed
        DepositoFrame df = new DepositoFrame(investidor);
        df.setVisible(true);
    }//GEN-LAST:event_btDepositoActionPerformed

    private void btSaqueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSaqueActionPerformed
        SacarFrame sf = new SacarFrame(investidor);
        sf.setVisible(true);
    }//GEN-LAST:event_btSaqueActionPerformed

    private void btCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCompraActionPerformed
        SenhaCompraFrame cf = new SenhaCompraFrame(lf);
        cf.setVisible(true);
        
    }//GEN-LAST:event_btCompraActionPerformed

    private void btVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btVendaActionPerformed
        SenhaVenderFrame vf = new SenhaVenderFrame(lf);
        vf.setVisible(true);
    }//GEN-LAST:event_btVendaActionPerformed

    private void btAtualizaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAtualizaActionPerformed
        AtualizarFrame af = new AtualizarFrame(investidor, lf);
        af.setVisible(true);
    }//GEN-LAST:event_btAtualizaActionPerformed

    private void btSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSairActionPerformed
        LoginFrame lf = new LoginFrame();
        lf.setVisible(true);
        controller.voltar();
    }//GEN-LAST:event_btSairActionPerformed

    private ControllerMenu controller;

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAtualiza;
    private javax.swing.JButton btCompra;
    private javax.swing.JButton btConsultaExtrato;
    private javax.swing.JButton btConsultaSaldo;
    private javax.swing.JButton btDeposito;
    private javax.swing.JButton btSair;
    private javax.swing.JButton btSaque;
    private javax.swing.JButton btVenda;
    private javax.swing.JLabel lblLogin;
    // End of variables declaration//GEN-END:variables
}
