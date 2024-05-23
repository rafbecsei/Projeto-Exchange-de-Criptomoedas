package view;

import controller.ControllerComprarBit;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import model.Investidor;

/**
 *
 * @author Rafael Becsei
 */

public class ComprarBitFrame extends javax.swing.JFrame {
    
    public ComprarBitFrame(Investidor investidor) {
        initComponents();
        controller = new ControllerComprarBit(this, investidor);
        lblSaldoBitcoin.setText(String.valueOf(investidor.getCarteira()
                                               .getMoedas().get(1).getSaldo()));
    }

    public JButton getBtComprarBit() {
        return btComprarBit;
    }

    public void setBtComprarBit(JButton btComprarBit) {
        this.btComprarBit = btComprarBit;
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

    public JLabel getjLabel2() {
        return jLabel2;
    }

    public void setjLabel2(JLabel jLabel2) {
        this.jLabel2 = jLabel2;
    }

    public JPanel getjPanel1() {
        return jPanel1;
    }

    public void setjPanel1(JPanel jPanel1) {
        this.jPanel1 = jPanel1;
    }

    public JPanel getjPanel2() {
        return jPanel2;
    }

    public void setjPanel2(JPanel jPanel2) {
        this.jPanel2 = jPanel2;
    }

    public JLabel getLblBitcoin() {
        return lblBitcoin;
    }

    public void setLblBitcoin(JLabel lblBitcoin) {
        this.lblBitcoin = lblBitcoin;
    }

    public JLabel getLblComprarCripto() {
        return lblComprarCripto;
    }

    public void setLblComprarCripto(JLabel lblComprarCripto) {
        this.lblComprarCripto = lblComprarCripto;
    }

    public JLabel getLblSaldoBitcoin() {
        return lblSaldoBitcoin;
    }

    public void setLblSaldoBitcoin(JLabel lblSaldoBitcoin) {
        this.lblSaldoBitcoin = lblSaldoBitcoin;
    }

    public JTextField getTxtValorBit() {
        return txtValorBit;
    }

    public void setTxtValorBit(JTextField txtValorBit) {
        this.txtValorBit = txtValorBit;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblComprarCripto = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        lblBitcoin = new javax.swing.JLabel();
        lblSaldoBitcoin = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btComprarBit = new javax.swing.JButton();
        txtValorBit = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        btVoltar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblComprarCripto.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblComprarCripto.setText("                        COMPRAR BITCOIN");
        lblComprarCripto.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lblBitcoin.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblBitcoin.setText("BITCOIN:");

        lblSaldoBitcoin.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblSaldoBitcoin.setText("bitcoin");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblBitcoin)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblSaldoBitcoin, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblBitcoin)
                    .addComponent(lblSaldoBitcoin))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setText("                                      SALDO BITCOIN");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
        );

        btComprarBit.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btComprarBit.setText("COMPRAR");
        btComprarBit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btComprarBitActionPerformed(evt);
            }
        });

        jLabel2.setText("VALOR (em R$):");

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
            .addComponent(lblComprarCripto, javax.swing.GroupLayout.DEFAULT_SIZE, 407, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btVoltar)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel2)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtValorBit, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(45, 45, 45))
            .addGroup(layout.createSequentialGroup()
                .addGap(146, 146, 146)
                .addComponent(btComprarBit, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lblComprarCripto, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtValorBit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addComponent(btComprarBit, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btVoltar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btComprarBitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btComprarBitActionPerformed
        controller.comprarBit();
    }//GEN-LAST:event_btComprarBitActionPerformed

    private void btVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btVoltarActionPerformed
        controller.voltarCompra();
    }//GEN-LAST:event_btVoltarActionPerformed

    private ControllerComprarBit controller;

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btComprarBit;
    private javax.swing.JButton btVoltar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblBitcoin;
    private javax.swing.JLabel lblComprarCripto;
    private javax.swing.JLabel lblSaldoBitcoin;
    private javax.swing.JTextField txtValorBit;
    // End of variables declaration//GEN-END:variables
}
