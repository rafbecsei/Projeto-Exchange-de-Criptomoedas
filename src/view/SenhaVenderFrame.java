package view;

import controller.ControllerSenhaVenda;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author Rafael Becsei
 */

public class SenhaVenderFrame extends javax.swing.JFrame {
    private LoginFrame lf;
    private SenhaCompraFrame scf;
    

    public SenhaVenderFrame(LoginFrame lf) {
        initComponents();
        controller = new ControllerSenhaVenda(this);
        this.lf = lf;
    }

    public LoginFrame getLf() {
        return lf;
    }

    public void setLf(LoginFrame lf) {
        this.lf = lf;
    }

    public SenhaCompraFrame getScf() {
        return scf;
    }

    public void setScf(SenhaCompraFrame scf) {
        this.scf = scf;
    }

    public JButton getBtSenha() {
        return btSenha;
    }

    public void setBtSenha(JButton btSenha) {
        this.btSenha = btSenha;
    }

    public JButton getBtVoltar() {
        return btVoltar;
    }

    public void setBtVoltar(JButton btVoltar) {
        this.btVoltar = btVoltar;
    }

    public JLabel getLblSenha() {
        return lblSenha;
    }

    public void setLblSenha(JLabel lblSenha) {
        this.lblSenha = lblSenha;
    }

    public JLabel getLblVerificar() {
        return lblVerificar;
    }

    public void setLblVerificar(JLabel lblVerificar) {
        this.lblVerificar = lblVerificar;
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

        lblVerificar = new javax.swing.JLabel();
        btSenha = new javax.swing.JButton();
        btVoltar = new javax.swing.JButton();
        lblSenha = new javax.swing.JLabel();
        txtSenha = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblVerificar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblVerificar.setText("                            VERIFICAÇÃO");

        btSenha.setText("ENTER");
        btSenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSenhaActionPerformed(evt);
            }
        });

        btVoltar.setText("VOLTAR");
        btVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btVoltarActionPerformed(evt);
            }
        });

        lblSenha.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblSenha.setText("SENHA:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblVerificar, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(72, 72, 72)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblSenha)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(87, 87, 87)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btVoltar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btSenha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lblVerificar, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSenha)
                    .addComponent(txtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btVoltar)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btSenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSenhaActionPerformed
        controller.consultaSenha(lf);
    }//GEN-LAST:event_btSenhaActionPerformed

    private void btVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btVoltarActionPerformed
        controller.voltar();
    }//GEN-LAST:event_btVoltarActionPerformed
    
    private ControllerSenhaVenda controller;
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btSenha;
    private javax.swing.JButton btVoltar;
    private javax.swing.JLabel lblSenha;
    private javax.swing.JLabel lblVerificar;
    private javax.swing.JTextField txtSenha;
    // End of variables declaration//GEN-END:variables
}
