package view;

import controller.ControllerSaque;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import model.Investidor;

/**
 *
 * @author Rafael Becsei
 */

public class SacarFrame extends javax.swing.JFrame {
    
    public SacarFrame(Investidor investidor) {
        initComponents();
        controller = new ControllerSaque(this, investidor);
        lblNomePessoa.setText(investidor.getNome());
        lblContaValorPessoa.setText(String.valueOf(investidor.getCarteira()
                                               .getMoedas().get(0).getSaldo()));
    }

    public JButton getBtSacar() {
        return btSacar;
    }

    public void setBtSacar(JButton btSacar) {
        this.btSacar = btSacar;
    }

    public JButton getBtVoltar() {
        return btVoltar;
    }

    public void setBtVoltar(JButton btVoltar) {
        this.btVoltar = btVoltar;
    }

    public JLabel getLblContaValor() {
        return lblContaValor;
    }

    public void setLblContaValor(JLabel lblContaValor) {
        this.lblContaValor = lblContaValor;
    }

    public JLabel getLblContaValorPessoa() {
        return lblContaValorPessoa;
    }

    public void setLblContaValorPessoa(JLabel lblContaValorPessoa) {
        this.lblContaValorPessoa = lblContaValorPessoa;
    }

    public JLabel getLblNomePessoa() {
        return lblNomePessoa;
    }

    public void setLblNomePessoa(JLabel lblNomePessoa) {
        this.lblNomePessoa = lblNomePessoa;
    }

    public JLabel getLblPessoa() {
        return lblPessoa;
    }

    public void setLblPessoa(JLabel lblPessoa) {
        this.lblPessoa = lblPessoa;
    }

    public JLabel getLblSaldo() {
        return lblSaldo;
    }

    public void setLblSaldo(JLabel lblSaldo) {
        this.lblSaldo = lblSaldo;
    }

    public JLabel getLblValor() {
        return lblValor;
    }

    public void setLblValor(JLabel lblValor) {
        this.lblValor = lblValor;
    }

    public JTextField getTxtQuantiaSaque() {
        return txtquantiaSaque;
    }

    public void setTxtQuantiaSaque(JTextField txtquantiaSaque) {
        this.txtquantiaSaque = txtquantiaSaque;
    }

    public JLabel getLblNovoSaldoPessoa() {
        return lblNovoSaldoPessoa;
    }

    public void setLblNovoSaldoPessoa(JLabel lblNovoSaldoPessoa) {
        this.lblNovoSaldoPessoa = lblNovoSaldoPessoa;
    }
    
    
    

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblSaldo = new javax.swing.JLabel();
        lblValor = new javax.swing.JLabel();
        txtquantiaSaque = new javax.swing.JTextField();
        btSacar = new javax.swing.JButton();
        btVoltar = new javax.swing.JButton();
        panelSaque = new javax.swing.JPanel();
        lblPessoa = new javax.swing.JLabel();
        lblContaValor = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        lblNomePessoa = new javax.swing.JLabel();
        lblContaValorPessoa = new javax.swing.JLabel();
        lblNovoSaldoPessoa = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblSaldo.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblSaldo.setText("                                              SAQUE");
        lblSaldo.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lblValor.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblValor.setText("VALOR:");

        btSacar.setText("SACAR");
        btSacar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSacarActionPerformed(evt);
            }
        });

        btVoltar.setText("VOLTAR");
        btVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btVoltarActionPerformed(evt);
            }
        });

        panelSaque.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lblPessoa.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblPessoa.setText("INVESTIDOR:");

        lblContaValor.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblContaValor.setText("SALDO:");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("NOVO SALDO:");

        javax.swing.GroupLayout panelSaqueLayout = new javax.swing.GroupLayout(panelSaque);
        panelSaque.setLayout(panelSaqueLayout);
        panelSaqueLayout.setHorizontalGroup(
            panelSaqueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSaqueLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelSaqueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblPessoa)
                    .addComponent(lblContaValor)
                    .addComponent(jLabel1))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        panelSaqueLayout.setVerticalGroup(
            panelSaqueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSaqueLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(lblPessoa)
                .addGap(18, 18, 18)
                .addComponent(lblContaValor)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lblNomePessoa.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblNomePessoa.setText("nome");

        lblContaValorPessoa.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblContaValorPessoa.setText("saldo");

        lblNovoSaldoPessoa.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblNovoSaldoPessoa.setText("---");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblNovoSaldoPessoa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblContaValorPessoa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblNomePessoa, javax.swing.GroupLayout.DEFAULT_SIZE, 318, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(lblNomePessoa)
                .addGap(18, 18, 18)
                .addComponent(lblContaValorPessoa)
                .addGap(18, 18, 18)
                .addComponent(lblNovoSaldoPessoa)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblSaldo, javax.swing.GroupLayout.DEFAULT_SIZE, 535, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(229, 229, 229)
                        .addComponent(btVoltar))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(76, 76, 76)
                        .addComponent(lblValor)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtquantiaSaque, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43)
                        .addComponent(btSacar, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(panelSaque, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lblSaldo, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelSaque, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblValor)
                    .addComponent(txtquantiaSaque, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btSacar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btVoltar)
                .addGap(23, 23, 23))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btSacarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSacarActionPerformed
        controller.SaqueReal();
    }//GEN-LAST:event_btSacarActionPerformed

    private void btVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btVoltarActionPerformed
        controller.voltarSaque();
    }//GEN-LAST:event_btVoltarActionPerformed

    private ControllerSaque controller;

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btSacar;
    private javax.swing.JButton btVoltar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblContaValor;
    private javax.swing.JLabel lblContaValorPessoa;
    private javax.swing.JLabel lblNomePessoa;
    private javax.swing.JLabel lblNovoSaldoPessoa;
    private javax.swing.JLabel lblPessoa;
    private javax.swing.JLabel lblSaldo;
    private javax.swing.JLabel lblValor;
    private javax.swing.JPanel panelSaque;
    private javax.swing.JTextField txtquantiaSaque;
    // End of variables declaration//GEN-END:variables
}
