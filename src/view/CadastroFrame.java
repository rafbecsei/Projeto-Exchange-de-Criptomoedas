package view;

import controller.ControllerCadastro;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author Rafael Becsei
 */

public class CadastroFrame extends javax.swing.JFrame {

    public CadastroFrame() {
        initComponents();
        controller = new ControllerCadastro(this);
    }

    public JButton getBtCadastrar() {
        return btCadastrar;
    }

    public void setBtCadastrar(JButton btCadastrar) {
        this.btCadastrar = btCadastrar;
    }

    public JLabel getLblCPFCadastro() {
        return lblCPFCadastro;
    }

    public void setLblCPFCadastro(JLabel lblCPFCadastro) {
        this.lblCPFCadastro = lblCPFCadastro;
    }

    public JLabel getLblCadastro() {
        return lblCadastro;
    }

    public void setLblCadastro(JLabel lblCadastro) {
        this.lblCadastro = lblCadastro;
    }

    public JLabel getLblNome() {
        return lblNome;
    }

    public void setLblNome(JLabel lblNome) {
        this.lblNome = lblNome;
    }

    public JLabel getLblSenhaCadastro() {
        return lblSenhaCadastro;
    }

    public void setLblSenhaCadastro(JLabel lblSenhaCadastro) {
        this.lblSenhaCadastro = lblSenhaCadastro;
    }

    public JTextField getTxtCpf() {
        return txtCpf;
    }

    public void setTxtCpf(JTextField txtCpf) {
        this.txtCpf = txtCpf;
    }

    public JTextField getTxtNome() {
        return txtNome;
    }

    public void setTxtNome(JTextField txtNome) {
        this.txtNome = txtNome;
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

        lblCadastro = new javax.swing.JLabel();
        lblCPFCadastro = new javax.swing.JLabel();
        lblNome = new javax.swing.JLabel();
        lblSenhaCadastro = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        txtCpf = new javax.swing.JTextField();
        txtSenha = new javax.swing.JTextField();
        btCadastrar = new javax.swing.JButton();
        btVoltarCadastro = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblCadastro.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblCadastro.setText("CADASTRO");

        lblCPFCadastro.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblCPFCadastro.setText("CPF:");

        lblNome.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblNome.setText("Nome:");

        lblSenhaCadastro.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblSenhaCadastro.setText("Senha:");

        btCadastrar.setText("ENTER");
        btCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCadastrarActionPerformed(evt);
            }
        });

        btVoltarCadastro.setText("VOLTAR");
        btVoltarCadastro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btVoltarCadastroActionPerformed(evt);
            }
        });
        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(99, 99, 99)
                        .addComponent(lblCadastro))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblSenhaCadastro)
                            .addComponent(lblNome)
                            .addComponent(lblCPFCadastro, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(btVoltarCadastro)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(22, 22, 22)))))
                .addContainerGap(83, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addComponent(lblCadastro, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNome)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCPFCadastro)
                    .addComponent(txtCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSenhaCadastro)
                    .addComponent(txtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btVoltarCadastro, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(53, 53, 53))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCadastrarActionPerformed
        controller.cadastrarPessoa();
    }//GEN-LAST:event_btCadastrarActionPerformed

    private void btVoltarCadastroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btVoltarCadastroActionPerformed
        controller.voltarCadastro();
    }//GEN-LAST:event_btVoltarCadastroActionPerformed

    private ControllerCadastro controller;
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCadastrar;
    private javax.swing.JButton btVoltarCadastro;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JLabel lblCPFCadastro;
    private javax.swing.JLabel lblCadastro;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblSenhaCadastro;
    private javax.swing.JTextField txtCpf;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtSenha;
    // End of variables declaration//GEN-END:variables
}
