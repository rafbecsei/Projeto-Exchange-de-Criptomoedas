package view;

import control.ControllerSaldo;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Rafael Becsei
 */

public class SaldoFrame extends javax.swing.JFrame {

    private ControllerSaldo controller;
    
    public SaldoFrame(String nome, double real, 
            double bitcoin, double ethereum, double ripple) {
        initComponents();
        controller = new ControllerSaldo(this); 
        lblNomePessoa.setText(nome);
        lblRealPessoa.setText(String.valueOf(real));
        lblBitcoinPessoa.setText(String.valueOf(bitcoin));
        lblEthereumPessoa.setText(String.valueOf(ethereum));
        lblRipplePessoa.setText(String.valueOf(ripple));
    }

    public JButton getBtVoltar() {
        return btVoltar;
    }

    public void setBtVoltar(JButton btVoltar) {
        this.btVoltar = btVoltar;
    }

    public JPanel getjPanel1() {
        return jPanel1;
    }

    public void setjPanel1(JPanel jPanel1) {
        this.jPanel1 = jPanel1;
    }

    public JLabel getLblBitcoin() {
        return lblBitcoin;
    }

    public void setLblBitcoin(JLabel lblBitcoin) {
        this.lblBitcoin = lblBitcoin;
    }

    public JLabel getLblBitcoinPessoa() {
        return lblBitcoinPessoa;
    }

    public void setLblBitcoinPessoa(JLabel lblBitcoinPessoa) {
        this.lblBitcoinPessoa = lblBitcoinPessoa;
    }

    public JLabel getLblEthereum() {
        return lblEthereum;
    }

    public void setLblEthereum(JLabel lblEthereum) {
        this.lblEthereum = lblEthereum;
    }

    public JLabel getLblEthereumPessoa() {
        return lblEthereumPessoa;
    }

    public void setLblEthereumPessoa(JLabel lblEthereumPessoa) {
        this.lblEthereumPessoa = lblEthereumPessoa;
    }

    public JLabel getLblSaldo() {
        return lblSaldo;
    }

    public void setLblSaldo(JLabel lblSaldo) {
        this.lblSaldo = lblSaldo;
    }

    public JLabel getLblNome() {
        return lblNome;
    }

    public void setLblNome(JLabel lblNome) {
        this.lblNome = lblNome;
    }

    public JLabel getLblNomePessoa() {
        return lblNomePessoa;
    }

    public void setLblNomePessoa(JLabel lblNomePessoa) {
        this.lblNomePessoa = lblNomePessoa;
    }

    public JLabel getLblReal() {
        return lblReal;
    }

    public void setLblReal(JLabel lblReal) {
        this.lblReal = lblReal;
    }

    public JLabel getLblRealPessoa() {
        return lblRealPessoa;
    }

    public void setLblRealPessoa(JLabel lblRealPessoa) {
        this.lblRealPessoa = lblRealPessoa;
    }

    public JLabel getLblRipple() {
        return lblRipple;
    }

    public void setLblRipple(JLabel lblRipple) {
        this.lblRipple = lblRipple;
    }

    public JLabel getLblRipplePessoa() {
        return lblRipplePessoa;
    }

    public void setLblRipplePessoa(JLabel lblRipplePessoa) {
        this.lblRipplePessoa = lblRipplePessoa;
    }

    
    

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblSaldo = new javax.swing.JLabel();
        lblNome = new javax.swing.JLabel();
        lblNomePessoa = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        lblBitcoinPessoa = new javax.swing.JLabel();
        lblRipplePessoa = new javax.swing.JLabel();
        lblEthereumPessoa = new javax.swing.JLabel();
        lblReal = new javax.swing.JLabel();
        lblBitcoin = new javax.swing.JLabel();
        lblEthereum = new javax.swing.JLabel();
        lblRipple = new javax.swing.JLabel();
        lblRealPessoa = new javax.swing.JLabel();
        btVoltar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblSaldo.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblSaldo.setText("                                                 SALDO");

        lblNome.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblNome.setText("INVESTIDOR:");
        lblNome.setBorder(javax.swing.BorderFactory.createCompoundBorder());

        lblNomePessoa.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblNomePessoa.setText("nome");

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(null));

        lblBitcoinPessoa.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblBitcoinPessoa.setText("bitcoin");

        lblRipplePessoa.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblRipplePessoa.setText("ripple");

        lblEthereumPessoa.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblEthereumPessoa.setText("ethereum");

        lblReal.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblReal.setText("REAL:");

        lblBitcoin.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblBitcoin.setText("BITCOIN:");

        lblEthereum.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblEthereum.setText("ETHEREUM:");

        lblRipple.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblRipple.setText("RIPPLE:");

        lblRealPessoa.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblRealPessoa.setText("real");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblEthereum)
                        .addGap(18, 18, 18)
                        .addComponent(lblEthereumPessoa))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblReal)
                                    .addComponent(lblBitcoin)))
                            .addComponent(lblRipple, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblBitcoinPessoa)
                            .addComponent(lblRealPessoa, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblRipplePessoa))))
                .addGap(0, 202, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblRealPessoa)
                    .addComponent(lblReal))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblBitcoin)
                    .addComponent(lblBitcoinPessoa))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEthereum)
                    .addComponent(lblEthereumPessoa))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblRipple)
                    .addComponent(lblRipplePessoa))
                .addContainerGap(32, Short.MAX_VALUE))
        );

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
            .addComponent(lblSaldo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblNome)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblNomePessoa))
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(241, 241, 241)
                        .addComponent(btVoltar)))
                .addContainerGap(71, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lblSaldo, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNome)
                    .addComponent(lblNomePessoa))
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btVoltar, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                .addGap(7, 7, 7))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btVoltarActionPerformed
        controller.voltarSaldo();
    }//GEN-LAST:event_btVoltarActionPerformed

//    private ControllerSaldo controller;

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btVoltar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblBitcoin;
    private javax.swing.JLabel lblBitcoinPessoa;
    private javax.swing.JLabel lblEthereum;
    private javax.swing.JLabel lblEthereumPessoa;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblNomePessoa;
    private javax.swing.JLabel lblReal;
    private javax.swing.JLabel lblRealPessoa;
    private javax.swing.JLabel lblRipple;
    private javax.swing.JLabel lblRipplePessoa;
    private javax.swing.JLabel lblSaldo;
    // End of variables declaration//GEN-END:variables
}
