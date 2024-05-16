package view;

import controller.ControllerAtualizar;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import model.Investidor;


/**
 *
 * @author Rafael Becsei
 */

public class AtualizarFrame extends javax.swing.JFrame {

    public AtualizarFrame(Investidor investidor) {
        initComponents();
        controller = new ControllerAtualizar(this, investidor);
//        lblBitcoinAtualizado.setText(String.valueOf(investidor.getCarteira()
//                                            .getMoedas().get(1).getCotacao();));
    }

    public ControllerAtualizar getController() {
        return controller;
    }

    public void setController(ControllerAtualizar controller) {
        this.controller = controller;
    }

    public JButton getBtAtualizar() {
        return btAtualizar;
    }

    public void setBtAtualizar(JButton btAtualizar) {
        this.btAtualizar = btAtualizar;
    }

    public JButton getBtVoltar() {
        return btVoltar;
    }

    public void setBtVoltar(JButton btVoltar) {
        this.btVoltar = btVoltar;
    }

    public JLabel getjLabel1() {
        return jLabel1;
    }

    public void setjLabel1(JLabel jLabel1) {
        this.jLabel1 = jLabel1;
    }

    public JPanel getjPanel1() {
        return jPanel1;
    }

    public void setjPanel1(JPanel jPanel1) {
        this.jPanel1 = jPanel1;
    }

    public JPanel getjPanel3() {
        return jPanel3;
    }

    public void setjPanel3(JPanel jPanel3) {
        this.jPanel3 = jPanel3;
    }

    public JPanel getjPanel5() {
        return jPanel5;
    }

    public void setjPanel5(JPanel jPanel5) {
        this.jPanel5 = jPanel5;
    }

    public JLabel getLblBitcoin() {
        return lblBitcoin;
    }

    public void setLblBitcoin(JLabel lblBitcoin) {
        this.lblBitcoin = lblBitcoin;
    }

    public JLabel getLblBitcoinAtualizado() {
        return lblBitcoinAtualizado;
    }

    public void setLblBitcoinAtualizado(JLabel lblBitcoinAtualizado) {
        this.lblBitcoinAtualizado = lblBitcoinAtualizado;
    }

    public JLabel getLblEthereum() {
        return lblEthereum;
    }

    public void setLblEthereum(JLabel lblEthereum) {
        this.lblEthereum = lblEthereum;
    }

    public JLabel getLblEthereumAtualizado() {
        return lblEthereumAtualizado;
    }

    public void setLblEthereumAtualizado(JLabel lblEthereumAtualizado) {
        this.lblEthereumAtualizado = lblEthereumAtualizado;
    }

    public JLabel getLblRipple() {
        return lblRipple;
    }

    public void setLblRipple(JLabel lblRipple) {
        this.lblRipple = lblRipple;
    }

    public JLabel getLblRippleAtualizado() {
        return lblRippleAtualizado;
    }

    public void setLblRippleAtualizado(JLabel lblRippleAtualizado) {
        this.lblRippleAtualizado = lblRippleAtualizado;
    }

    public JLabel getLblSaldo() {
        return lblSaldo;
    }

    public void setLblSaldo(JLabel lblSaldo) {
        this.lblSaldo = lblSaldo;
    }
    
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblSaldo = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        lblBitcoin = new javax.swing.JLabel();
        lblRipple = new javax.swing.JLabel();
        lblEthereum = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        lblBitcoinAtualizado = new javax.swing.JLabel();
        lblEthereumAtualizado = new javax.swing.JLabel();
        lblRippleAtualizado = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btAtualizar = new javax.swing.JButton();
        btVoltar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblSaldo.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblSaldo.setText("                            NOVA COTAÇÃO");

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(null));

        lblBitcoin.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblBitcoin.setText("BITCOIN:");

        lblRipple.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblRipple.setText("RIPPLE:");

        lblEthereum.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblEthereum.setText("ETHEREUM:");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblEthereum)
                    .addComponent(lblBitcoin)
                    .addComponent(lblRipple))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblBitcoin)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblEthereum)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addComponent(lblRipple)
                .addContainerGap())
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(null));

        lblBitcoinAtualizado.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblBitcoinAtualizado.setText("bitcoin");

        lblEthereumAtualizado.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblEthereumAtualizado.setText("ethereum");

        lblRippleAtualizado.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblRippleAtualizado.setText("ripple");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblBitcoinAtualizado, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblEthereumAtualizado)
                    .addComponent(lblRippleAtualizado))
                .addContainerGap(176, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblBitcoinAtualizado)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblEthereumAtualizado)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblRippleAtualizado)
                .addContainerGap())
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(null));

        jLabel1.setText("CRIPTOMOEDAS");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(133, 133, 133)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
        );

        btAtualizar.setText("ATUALIZAR");

        btVoltar.setText("VOLTAR");
        btVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btVoltarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblSaldo, javax.swing.GroupLayout.DEFAULT_SIZE, 429, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(155, 155, 155)
                        .addComponent(btAtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btVoltar)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lblSaldo, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(btAtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btVoltar)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btVoltarActionPerformed
        controller.voltarAtualiza();
    }//GEN-LAST:event_btVoltarActionPerformed

    private ControllerAtualizar controller;

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAtualizar;
    private javax.swing.JButton btVoltar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JLabel lblBitcoin;
    private javax.swing.JLabel lblBitcoinAtualizado;
    private javax.swing.JLabel lblEthereum;
    private javax.swing.JLabel lblEthereumAtualizado;
    private javax.swing.JLabel lblRipple;
    private javax.swing.JLabel lblRippleAtualizado;
    private javax.swing.JLabel lblSaldo;
    // End of variables declaration//GEN-END:variables
}
