package view;

import controller.ControllerSenha;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author Rafael Becsei
 */

public class SenhaFrame extends javax.swing.JFrame {
    private LoginFrame lf;
    public SenhaFrame(LoginFrame lf) {
        initComponents();
        controller = new ControllerSenha(this);
        this.lf = lf;
    }

    public JButton getBtSenha() {
        return btSenha;
    }

    public void setBtSenha(JButton btSenha) {
        this.btSenha = btSenha;
    }

    public JLabel getLblSaldo() {
        return lblSaldo;
    }

    public void setLblSaldo(JLabel lblSaldo) {
        this.lblSaldo = lblSaldo;
    }

    public JLabel getLblSenha() {
        return lblSenha;
    }

    public void setLblSenha(JLabel lblSenha) {
        this.lblSenha = lblSenha;
    }

    public JTextField getTxtSenha() {
        return txtSenha;
    }

    public void setTxtSenha(JTextField txtSenha) {
        this.txtSenha = txtSenha;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblSaldo = new javax.swing.JLabel();
        lblSenha = new javax.swing.JLabel();
        txtSenha = new javax.swing.JTextField();
        btSenha = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblSaldo.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblSaldo.setText("                           VERIFICAÇÃO");
        lblSaldo.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lblSenha.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblSenha.setText("SENHA:");

        btSenha.setText("ENTER");
        btSenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSenhaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblSaldo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addComponent(lblSenha)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(153, 153, 153)
                        .addComponent(btSenha)))
                .addContainerGap(84, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lblSaldo, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSenha)
                    .addComponent(txtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btSenha)
                .addGap(0, 10, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btSenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSenhaActionPerformed
        controller.consultaSenha(lf);
    }//GEN-LAST:event_btSenhaActionPerformed

    private ControllerSenha controller;

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btSenha;
    private javax.swing.JLabel lblSaldo;
    private javax.swing.JLabel lblSenha;
    private javax.swing.JTextField txtSenha;
    // End of variables declaration//GEN-END:variables
}
