package view;

import controller.ControllerDeposito;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import model.Investidor;

/**
 *
 * @author Rafael Becsei
 */

public class DepositoFrame extends javax.swing.JFrame {
    private Investidor investidor;
    
    public DepositoFrame(Investidor investidor) {
        initComponents();
        controller = new ControllerDeposito(this, investidor);
        lblNomePessoa.setText(investidor.getNome());
        lblContaPessoa.setText(String.valueOf(investidor.getCarteira()
                                               .getMoedas().get(0).getSaldo()));
    }

    public ControllerDeposito getController() {
        return controller;
    }

    public void setController(ControllerDeposito controller) {
        this.controller = controller;
    }

    public JButton getBtDepositar() {
        return btDepositar;
    }

    public void setBtDepositar(JButton btDepositar) {
        this.btDepositar = btDepositar;
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

    public JLabel getLblContaPessoa() {
        return lblContaPessoa;
    }

    public void setLblContaPessoa(JLabel lblContaPessoa) {
        this.lblContaPessoa = lblContaPessoa;
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

    public JLabel getLblNovoSaldo() {
        return lblNovoSaldo;
    }

    public void setLblNovoSaldo(JLabel lblNovoSaldo) {
        this.lblNovoSaldo = lblNovoSaldo;
    }

    public JLabel getLblNovoSaldoPessoa() {
        return lblNovoSaldoPessoa;
    }

    public void setLblNovoSaldoPessoa(JLabel lblNovoSaldoPessoa) {
        this.lblNovoSaldoPessoa = lblNovoSaldoPessoa;
    }

    public JLabel getLblSaldo() {
        return lblSaldo;
    }

    public void setLblSaldo(JLabel lblSaldo) {
        this.lblSaldo = lblSaldo;
    }

    public JLabel getLblSaldoPessoa() {
        return lblSaldoPessoa;
    }

    public void setLblSaldoPessoa(JLabel lblSaldoPessoa) {
        this.lblSaldoPessoa = lblSaldoPessoa;
    }

    public JLabel getLblValor() {
        return lblValor;
    }

    public void setLblValor(JLabel lblValor) {
        this.lblValor = lblValor;
    }

    public JPanel getPanelDeposito() {
        return panelDeposito;
    }

    public void setPanelDeposito(JPanel panelDeposito) {
        this.panelDeposito = panelDeposito;
    }

    public JTextField getTxtquantiaDeposito() {
        return txtquantiaDeposito;
    }

    public void setTxtquantiaDeposito(JTextField txtquantiaDeposito) {
        this.txtquantiaDeposito = txtquantiaDeposito;
    }

    
    
    
    
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblSaldo = new javax.swing.JLabel();
        btVoltar = new javax.swing.JButton();
        lblValor = new javax.swing.JLabel();
        txtquantiaDeposito = new javax.swing.JTextField();
        btDepositar = new javax.swing.JButton();
        lblSaldoPessoa = new javax.swing.JLabel();
        panelDeposito = new javax.swing.JPanel();
        lblNome = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        lblNovoSaldo = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        lblNomePessoa = new javax.swing.JLabel();
        lblContaPessoa = new javax.swing.JLabel();
        lblNovoSaldoPessoa = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblSaldo.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblSaldo.setText("                                                DEPOSITO");
        lblSaldo.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btVoltar.setText("VOLTAR");
        btVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btVoltarActionPerformed(evt);
            }
        });

        lblValor.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblValor.setText("VALOR:");

        btDepositar.setText("DEPOSITAR");
        btDepositar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDepositarActionPerformed(evt);
            }
        });

        lblSaldoPessoa.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        panelDeposito.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lblNome.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblNome.setText("INVESTIDOR:");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("SALDO:");

        lblNovoSaldo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblNovoSaldo.setText("NOVO SALDO:");

        javax.swing.GroupLayout panelDepositoLayout = new javax.swing.GroupLayout(panelDeposito);
        panelDeposito.setLayout(panelDepositoLayout);
        panelDepositoLayout.setHorizontalGroup(
            panelDepositoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDepositoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelDepositoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblNome)
                    .addComponent(jLabel1)
                    .addComponent(lblNovoSaldo))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelDepositoLayout.setVerticalGroup(
            panelDepositoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDepositoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblNome)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblNovoSaldo)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lblNomePessoa.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblNomePessoa.setText("nome");

        lblContaPessoa.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblContaPessoa.setText("saldo");

        lblNovoSaldoPessoa.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblNovoSaldoPessoa.setText("--");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblNomePessoa, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblContaPessoa, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNovoSaldoPessoa))
                .addContainerGap(312, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblNomePessoa)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblContaPessoa)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblNovoSaldoPessoa)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblSaldo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(36, 36, 36)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(panelDeposito, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(lblSaldoPessoa))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(82, 82, 82)
                                        .addComponent(lblValor)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtquantiaDeposito, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(btDepositar))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(239, 239, 239)
                                .addComponent(btVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lblSaldo, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(74, 74, 74)
                        .addComponent(lblSaldoPessoa))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(panelDeposito, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblValor)
                    .addComponent(txtquantiaDeposito, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btDepositar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btVoltar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btDepositarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDepositarActionPerformed
        controller.depositoReal();
//        lblNovoSaldoPessoa.setText(String.valueOf(investidor.getCarteira()
//                                               .getMoedas().get(0).getSaldo()));
    }//GEN-LAST:event_btDepositarActionPerformed

    private void btVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btVoltarActionPerformed
        controller.voltarDeposito();
    }//GEN-LAST:event_btVoltarActionPerformed

    private ControllerDeposito controller;
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btDepositar;
    private javax.swing.JButton btVoltar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblContaPessoa;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblNomePessoa;
    private javax.swing.JLabel lblNovoSaldo;
    private javax.swing.JLabel lblNovoSaldoPessoa;
    private javax.swing.JLabel lblSaldo;
    private javax.swing.JLabel lblSaldoPessoa;
    private javax.swing.JLabel lblValor;
    private javax.swing.JPanel panelDeposito;
    private javax.swing.JTextField txtquantiaDeposito;
    // End of variables declaration//GEN-END:variables
}
