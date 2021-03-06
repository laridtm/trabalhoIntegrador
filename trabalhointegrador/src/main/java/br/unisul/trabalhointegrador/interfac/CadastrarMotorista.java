/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unisul.trabalhointegrador.interfac;

import br.unisul.trabalhointegrador.controller.Principal;
import br.unisul.trabalhointegrador.model.CaminhaoBau;
import br.unisul.trabalhointegrador.model.Carreta;
import br.unisul.trabalhointegrador.model.Motorista;
import br.unisul.trabalhointegrador.model.Van;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

/**
 *
 * @author larissadiniz
 */
public class CadastrarMotorista extends javax.swing.JFrame {

    private Principal principal;

    /**
     * Creates new form CadastrarMotorista
     */
    public CadastrarMotorista(Principal principal) {
        initComponents();
        this.principal = principal;
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblNomeMotorista = new javax.swing.JLabel();
        lblDataNasc = new javax.swing.JLabel();
        lblTipoCNH = new javax.swing.JLabel();
        lblNumCNH = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtNomeMotorista = new javax.swing.JTextField();
        txtDataNasc = new javax.swing.JTextField();
        tipoCNH = new javax.swing.JComboBox<>();
        txtNumCNH = new javax.swing.JTextField();
        txtEndMotorista = new javax.swing.JTextField();
        btnSalvar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblNomeMotorista.setText("Nome Motorista");

        lblDataNasc.setText("Data de Nascimento");

        lblTipoCNH.setText("Tipo de CNH");

        lblNumCNH.setText("Número da CNH");

        jLabel1.setText("Endereço Motorista");

        tipoCNH.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "B", "B/C" }));

        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblDataNasc)
                    .addComponent(lblNomeMotorista)
                    .addComponent(lblTipoCNH)
                    .addComponent(lblNumCNH)
                    .addComponent(jLabel1))
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtNumCNH, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtEndMotorista, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtNomeMotorista, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDataNasc)
                    .addComponent(tipoCNH, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(50, 50, 50))
            .addGroup(layout.createSequentialGroup()
                .addGap(159, 159, 159)
                .addComponent(btnSalvar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNomeMotorista)
                    .addComponent(txtNomeMotorista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDataNasc)
                    .addComponent(txtDataNasc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(tipoCNH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(lblTipoCNH)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNumCNH)
                    .addComponent(txtNumCNH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtEndMotorista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(btnSalvar)
                .addGap(18, 18, 18))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        Motorista motorista = new Motorista();
        motorista.setNome(txtNomeMotorista.getText());
        motorista.setDataNascimento(txtDataNasc.getText());

        switch (tipoCNH.getSelectedIndex()) {
            case 0:
                motorista.setTipoCNH("B");
                break;

            case 1:
                motorista.setTipoCNH("C");
                break;
        }
        motorista.setNumeroCNH(Double.parseDouble(txtNumCNH.getText()));
        motorista.setEndereco(txtEndMotorista.getText());

        principal.cadastrarMotorista(motorista);
        this.dispose();

    }//GEN-LAST:event_btnSalvarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSalvar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblDataNasc;
    private javax.swing.JLabel lblNomeMotorista;
    private javax.swing.JLabel lblNumCNH;
    private javax.swing.JLabel lblTipoCNH;
    private javax.swing.JComboBox<String> tipoCNH;
    private javax.swing.JTextField txtDataNasc;
    private javax.swing.JTextField txtEndMotorista;
    private javax.swing.JTextField txtNomeMotorista;
    private javax.swing.JTextField txtNumCNH;
    // End of variables declaration//GEN-END:variables
}
