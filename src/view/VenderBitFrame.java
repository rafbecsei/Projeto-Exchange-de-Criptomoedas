package view;

import controller.ControllerVenderBit;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import model.Investidor;

/**
 *
 * @author Rafael Becsei
 */

public class VenderBitFrame extends javax.swing.JFrame {

    public VenderBitFrame(Investidor investidor) {
        initComponents();
        controller = new ControllerVenderBit(this, investidor);
        lblSaldoBitcoin.setText(String.valueOf(investidor.getCarteira()
                                               .getMoedas().get(1).getSaldo()));
        double Bitcoin = investidor.getCarteira().getMoedas().get(1).getSaldo();
        double cotacaoBit = investidor.getCarteira().getMoedas().get(1).getCotacao();
        double taxaBitV = investidor.getCarteira().getMoedas().get(1).getTaxaVenda();
        double BitparaReal = Bitcoin * cotacaoBit;
//        double Real = BitparaReal * (1 + taxaBitV);
        lblSaldoReal.setText(String.format("%.2f", BitparaReal));
    }

    public JButton getBtVenderBit() {
        return btVenderBit;
    }

    public void setBtVenderBit(JButton btVenderBit) {
        this.btVenderBit = btVenderBit;
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

    public JLabel getLblSaldoBitcoin() {
        return lblSaldoBitcoin;
    }

    public void setLblSaldoBitcoin(JLabel lblSaldoBitcoin) {
        this.lblSaldoBitcoin = lblSaldoBitcoin;
    }

    public JLabel getLblVenderCripto() {
        return lblVenderCripto;
    }

    public void setLblVenderCripto(JLabel lblVenderCripto) {
        this.lblVenderCripto = lblVenderCripto;
    }

    public JTextField getTxtValorBit() {
        return txtValorBit;
    }

    public void setTxtValorBit(JTextField txtValorBit) {
        this.txtValorBit = txtValorBit;
    }

    public JLabel getLblReal() {
        return lblReal;
    }

    public void setLblReal(JLabel lblReal) {
        this.lblReal = lblReal;
    }

    public JLabel getLblSaldoReal() {
        return lblSaldoReal;
    }

    public void setLblSaldoReal(JLabel lblSaldoReal) {
        this.lblSaldoReal = lblSaldoReal;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblVenderCripto = new javax.swing.JLabel();
        txtValorBit = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        btVoltar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        lblBitcoin = new javax.swing.JLabel();
        lblSaldoBitcoin = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btVenderBit = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        lblReal = new javax.swing.JLabel();
        lblSaldoReal = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblVenderCripto.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblVenderCripto.setText("                          VENDER BITCOIN");
        lblVenderCripto.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel2.setText("VALOR (em R$):");

        btVoltar.setText("VOLTAR");
        btVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btVoltarActionPerformed(evt);
            }
        });

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
                .addComponent(lblSaldoBitcoin, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblBitcoin)
                    .addComponent(lblSaldoBitcoin))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

        btVenderBit.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btVenderBit.setText("VENDER");
        btVenderBit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btVenderBitActionPerformed(evt);
            }
        });

        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel3.setText("                             SALDO BITCOIN EM REAL");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lblReal.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblReal.setText("REAL:");

        lblSaldoReal.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblSaldoReal.setText("real");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblReal)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblSaldoReal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(141, 141, 141))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblReal)
                    .addComponent(lblSaldoReal))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblVenderCripto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btVoltar)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(jLabel2)
                            .addGap(29, 29, 29)
                            .addComponent(txtValorBit, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(105, 105, 105)
                            .addComponent(btVenderBit, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(36, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lblVenderCripto, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtValorBit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addComponent(btVenderBit, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btVoltar)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btVoltarActionPerformed
        controller.voltarCompra();
    }//GEN-LAST:event_btVoltarActionPerformed

    private void btVenderBitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btVenderBitActionPerformed
        controller.venderBit();
    }//GEN-LAST:event_btVenderBitActionPerformed
    
    private ControllerVenderBit controller;
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btVenderBit;
    private javax.swing.JButton btVoltar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JLabel lblBitcoin;
    private javax.swing.JLabel lblReal;
    private javax.swing.JLabel lblSaldoBitcoin;
    private javax.swing.JLabel lblSaldoReal;
    private javax.swing.JLabel lblVenderCripto;
    private javax.swing.JTextField txtValorBit;
    // End of variables declaration//GEN-END:variables
}
