package view;

import DAO.Conexao;
import DAO.InvestidorDAO;
import controller.ControllerAtualizar;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import model.Investidor;

/**
 *
 * @author Rafael Becsei
 */

public class AtualizarFrame extends javax.swing.JFrame {
    private Investidor investidor;

    public AtualizarFrame(Investidor investidor, LoginFrame lf) {
        initComponents();
        controller = new ControllerAtualizar(this, investidor);
        Conexao conexao = new Conexao();
        
        try{
            Connection conn = conexao.getConnection();
            InvestidorDAO dao = new InvestidorDAO(conn);
            ResultSet res = dao.consultarSenha(investidor);
            if(res.next()){   
                double cotacaoBit = res.getDouble("cotacaoBit");
                double cotacaoEth = res.getDouble("cotacaoEth");
                double cotacaoRip = res.getDouble("cotacaoRip");
                investidor.getCarteira().getMoedas().get(1).setCotacao(cotacaoBit);
                investidor.getCarteira().getMoedas().get(2).setCotacao(cotacaoEth);
                investidor.getCarteira().getMoedas().get(3).setCotacao(cotacaoRip);
                lblBitcoinAtualizado.setText(String.valueOf(investidor.getCarteira()
                                            .getMoedas().get(1).getCotacao()));
                lblEthereumAtualizado.setText(String.valueOf(investidor.getCarteira()
                                            .getMoedas().get(2).getCotacao()));
                lblRippleAtualizado.setText(String.valueOf(investidor.getCarteira()
                                            .getMoedas().get(3).getCotacao()));
            } else {
                JOptionPane.showMessageDialog(this, "Erro!");
            }
        } catch (SQLException e){
            JOptionPane.showMessageDialog(this, "Erro de conexão!");
        }
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

    public JLabel getjLabel2() {
        return jLabel2;
    }

    public void setjLabel2(JLabel jLabel2) {
        this.jLabel2 = jLabel2;
    }

    public JLabel getjLabel3() {
        return jLabel3;
    }

    public void setjLabel3(JLabel jLabel3) {
        this.jLabel3 = jLabel3;
    }

    public JLabel getjLabel4() {
        return jLabel4;
    }

    public void setjLabel4(JLabel jLabel4) {
        this.jLabel4 = jLabel4;
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

    public JPanel getjPanel3() {
        return jPanel3;
    }

    public void setjPanel3(JPanel jPanel3) {
        this.jPanel3 = jPanel3;
    }

    public JPanel getjPanel4() {
        return jPanel4;
    }

    public void setjPanel4(JPanel jPanel4) {
        this.jPanel4 = jPanel4;
    }

    public JPanel getjPanel5() {
        return jPanel5;
    }

    public void setjPanel5(JPanel jPanel5) {
        this.jPanel5 = jPanel5;
    }

    public JPanel getjPanel6() {
        return jPanel6;
    }

    public void setjPanel6(JPanel jPanel6) {
        this.jPanel6 = jPanel6;
    }

    public JPanel getjPanel7() {
        return jPanel7;
    }

    public void setjPanel7(JPanel jPanel7) {
        this.jPanel7 = jPanel7;
    }

    public JPanel getjPanel8() {
        return jPanel8;
    }

    public void setjPanel8(JPanel jPanel8) {
        this.jPanel8 = jPanel8;
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

    public JLabel getLblBitcoinAtualizado1() {
        return lblBitcoinAtualizado1;
    }

    public void setLblBitcoinAtualizado1(JLabel lblBitcoinAtualizado1) {
        this.lblBitcoinAtualizado1 = lblBitcoinAtualizado1;
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

    public JLabel getLblEthereumAtualizado1() {
        return lblEthereumAtualizado1;
    }

    public void setLblEthereumAtualizado1(JLabel lblEthereumAtualizado1) {
        this.lblEthereumAtualizado1 = lblEthereumAtualizado1;
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

    public JLabel getLblRippleAtualizado1() {
        return lblRippleAtualizado1;
    }

    public void setLblRippleAtualizado1(JLabel lblRippleAtualizado1) {
        this.lblRippleAtualizado1 = lblRippleAtualizado1;
    }

    public JLabel getLblSaldo() {
        return lblSaldo;
    }

    public void setLblSaldo(JLabel lblSaldo) {
        this.lblSaldo = lblSaldo;
    }

    public JLabel getLblcotacaoBitAtual() {
        return lblcotacaoBitAtual;
    }

    public void setLblcotacaoBitAtual(JLabel lblcotacaoBitAtual) {
        this.lblcotacaoBitAtual = lblcotacaoBitAtual;
    }

    public JLabel getLblcotacaoEthAtual() {
        return lblcotacaoEthAtual;
    }

    public void setLblcotacaoEthAtual(JLabel lblcotacaoEthAtual) {
        this.lblcotacaoEthAtual = lblcotacaoEthAtual;
    }

    public JLabel getLblcotacaoRipAtual() {
        return lblcotacaoRipAtual;
    }

    public void setLblcotacaoRipAtual(JLabel lblcotacaoRipAtual) {
        this.lblcotacaoRipAtual = lblcotacaoRipAtual;
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
        jPanel2 = new javax.swing.JPanel();
        lblcotacaoBitAtual = new javax.swing.JLabel();
        lblcotacaoEthAtual = new javax.swing.JLabel();
        lblcotacaoRipAtual = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblSaldo.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblSaldo.setText("                                                      NOVA COTAÇÃO");
        lblSaldo.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblRipple)
                .addContainerGap())
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

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
                    .addComponent(lblBitcoinAtualizado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblEthereumAtualizado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblRippleAtualizado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblBitcoinAtualizado)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblEthereumAtualizado)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblRippleAtualizado)
                .addContainerGap())
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setText("CRIPTOMOEDAS");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(253, 253, 253)
                .addComponent(jLabel1)
                .addContainerGap(253, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
        );

        btAtualizar.setText("ATUALIZAR");
        btAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAtualizarActionPerformed(evt);
            }
        });

        btVoltar.setText("VOLTAR");
        btVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btVoltarActionPerformed(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lblcotacaoBitAtual.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblcotacaoBitAtual.setText("---");

        lblcotacaoEthAtual.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblcotacaoEthAtual.setText("---");

        lblcotacaoRipAtual.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblcotacaoRipAtual.setText("---");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblcotacaoRipAtual, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblcotacaoBitAtual, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblcotacaoEthAtual, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblcotacaoBitAtual)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblcotacaoEthAtual)
                .addGap(18, 18, 18)
                .addComponent(lblcotacaoRipAtual)
                .addContainerGap())
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel2.setText("MOEDAS");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel2)
                .addContainerGap(24, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE)
        );

        jPanel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel3.setText("COTAÇÃO ANTIGA");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addComponent(jLabel3)
                .addContainerGap(78, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel4.setText("COTAÇÃO NOVA");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addComponent(jLabel4)
                .addContainerGap(71, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblSaldo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btAtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(btVoltar))
                .addContainerGap(41, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lblSaldo, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(btAtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(21, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btVoltar)
                        .addGap(20, 20, 20))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btVoltarActionPerformed
        controller.voltarAtualiza();
    }//GEN-LAST:event_btVoltarActionPerformed

    private void btAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAtualizarActionPerformed
        controller.atualizaCotacao();
    }//GEN-LAST:event_btAtualizarActionPerformed

    private ControllerAtualizar controller;

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAtualizar;
    private javax.swing.JButton btVoltar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JLabel lblBitcoin;
    private javax.swing.JLabel lblBitcoinAtualizado;
    private javax.swing.JLabel lblBitcoinAtualizado1;
    private javax.swing.JLabel lblEthereum;
    private javax.swing.JLabel lblEthereumAtualizado;
    private javax.swing.JLabel lblEthereumAtualizado1;
    private javax.swing.JLabel lblRipple;
    private javax.swing.JLabel lblRippleAtualizado;
    private javax.swing.JLabel lblRippleAtualizado1;
    private javax.swing.JLabel lblSaldo;
    private javax.swing.JLabel lblcotacaoBitAtual;
    private javax.swing.JLabel lblcotacaoEthAtual;
    private javax.swing.JLabel lblcotacaoRipAtual;
    // End of variables declaration//GEN-END:variables
}
