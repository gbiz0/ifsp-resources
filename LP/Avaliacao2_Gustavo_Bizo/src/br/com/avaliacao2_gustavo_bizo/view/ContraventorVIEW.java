/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package br.com.avaliacao2_gustavo_bizo.view;

import br.com.avaliacao2_gustavo_bizo.ctr.ContraventorCTR;
import br.com.avaliacao2_gustavo_bizo.dto.ContraventorDTO;
import java.awt.Dimension;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author gbiz0
 */
public class ContraventorVIEW extends javax.swing.JInternalFrame {

    ContraventorDTO contraventorDTO = new ContraventorDTO();
    ContraventorCTR contraventorCTR = new ContraventorCTR();
    int gravar_alterar;
    ResultSet rs;
    DefaultTableModel modelo_jtl_consultar_contraventor;
    
    public ContraventorVIEW() {
        initComponents();
        liberaCampos(false);
        liberaBotoes(true, false, false, false, true);

        modelo_jtl_consultar_contraventor = (DefaultTableModel) jtl_consultar_contraventor.getModel();
    }
    
    public void setPosicao() {
        Dimension d = this.getDesktopPane().getSize();
        this.setLocation((d.width - this.getSize().width) / 2, (d.height - this.getSize().height) / 2);
    }
    public void liberaCampos(boolean a) {
        nome_cont.setEnabled(a);
        cpf_cont.setEnabled(a);
        login_cont.setEnabled(a);
        tipo_cont.setEnabled(a);
        senha_cont.setEnabled(a);
        checkAlterarSenha.setEnabled(a);
    }
    
    private void liberaBotoes(boolean a, boolean b, boolean c, boolean d, boolean e) {
        btnNovo.setEnabled(a);
        btnSalvar.setEnabled(b);
        btnCancelar.setEnabled(c);
        btnExcluir.setEnabled(d);
        btnSair.setEnabled(e);
    }

    private void limpaCampos() {
        nome_cont.setText("");
        cpf_cont.setText("");
        login_cont.setText("");
        senha_cont.setText("");
        checkAlterarSenha.setSelected(false);
    }
    
    public void gravar() {
        try {
            contraventorDTO.setNome_cont(nome_cont.getText());
            contraventorDTO.setCpf_cont(cpf_cont.getText());
            contraventorDTO.setLogin_cont(login_cont.getText());
            contraventorDTO.setSenha_cont(String.valueOf(senha_cont.getPassword()));
            contraventorDTO.setTipo_cont(tipo_cont.getSelectedItem().toString());
            
            JOptionPane.showMessageDialog(null, contraventorCTR.inserirContraventor(contraventorDTO));          
        } catch (Exception e) {
            System.out.println("Erro ao Gravar: " + e.getMessage());
        }
    }
    
    public void alterar() {
        try {
            contraventorDTO.setNome_cont(nome_cont.getText());
            contraventorDTO.setCpf_cont(cpf_cont.getText());
            contraventorDTO.setLogin_cont(login_cont.getText());
            contraventorDTO.setTipo_cont(tipo_cont.getSelectedItem().toString());
            
            if ((checkAlterarSenha.isSelected()) && (senha_cont.getPassword().length != 0)) {
                contraventorDTO.setSenha_cont(String.valueOf(senha_cont.getPassword()));
            } else {
                contraventorDTO.setSenha_cont(null);
            }
            JOptionPane.showMessageDialog(null, contraventorCTR.alterarContraventor(contraventorDTO));          
        } catch (Exception e) {
            System.out.println("Erro ao Alterar: " + e.getMessage());
        }
    }
    
    public void excluir() {
        if (JOptionPane.showConfirmDialog(null, "Deseja realmente excluir o Contraventor?", "Aviso", JOptionPane.YES_OPTION) == JOptionPane.YES_OPTION) {
            JOptionPane.showMessageDialog(null, contraventorCTR.excluirContraventor(contraventorDTO));
        }
    }
    
    public void preencheTabela(String nome_cont) {
        try {
            modelo_jtl_consultar_contraventor.setNumRows(0);
            contraventorDTO.setNome_cont(nome_cont);

            rs = contraventorCTR.consultarContraventor(contraventorDTO, 1);

            while (rs.next()) {
                modelo_jtl_consultar_contraventor.addRow(new Object[]{
                    rs.getString("id_cont"),
                    rs.getString("nome_cont"),
                });
            }
        } catch (Exception erTab) {
            System.out.println("Erro SQL: " + erTab);
        } finally {
            contraventorCTR.CloseDB();
        }
    }

    public void preencheCampos(int id_cont) {
        try {
            contraventorDTO.setId_cont(id_cont);
            rs = contraventorCTR.consultarContraventor(contraventorDTO, 2);

            if (rs.next()) {
                limpaCampos();
                nome_cont.setText(rs.getString("nome_cont"));
                cpf_cont.setText(rs.getString("cpf_cont"));
                login_cont.setText(rs.getString("login_cont"));
                tipo_cont.setSelectedItem(rs.getString("tipo_cont"));
                gravar_alterar = 2;
                liberaCampos(true);
                senha_cont.setEnabled(false);
                checkAlterarSenha.setSelected(false);
            }
        } catch (Exception erTab) {
            System.out.println("Erro SQL: " + erTab);
        } finally {
            contraventorCTR.CloseDB();
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane5 = new javax.swing.JScrollPane();
        pesquisa_nome_cont = new javax.swing.JTextPane();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btnPesquisar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        checkAlterarSenha = new javax.swing.JCheckBox();
        btnExcluir = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        tipo_cont = new javax.swing.JComboBox<>();
        btnSair = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        nome_cont = new javax.swing.JTextPane();
        senha_cont = new javax.swing.JPasswordField();
        btnSalvar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        btnNovo = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        cpf_cont = new javax.swing.JTextPane();
        jLabel7 = new javax.swing.JLabel();
        btnCancelar = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        jtl_consultar_contraventor = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        login_cont = new javax.swing.JTextPane();
        jLabel8 = new javax.swing.JLabel();

        jScrollPane5.setViewportView(pesquisa_nome_cont);

        jLabel4.setText("LOGIN:");

        jLabel5.setText("SENHA:");

        btnPesquisar.setText("OK");
        btnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Liberation Sans", 1, 24)); // NOI18N
        jLabel1.setText("Contraventor");

        checkAlterarSenha.setText("Alterar Senha");
        checkAlterarSenha.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                checkAlterarSenhaMouseClicked(evt);
            }
        });

        btnExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/avaliacao2_gustavo_bizo/view/images/excluir.png"))); // NOI18N
        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        jLabel2.setText("NOME:");

        tipo_cont.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ADMINISTRADOR", "COMUM" }));
        tipo_cont.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tipo_contActionPerformed(evt);
            }
        });

        btnSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/avaliacao2_gustavo_bizo/view/images/sair.png"))); // NOI18N
        btnSair.setText("Sair");
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });

        jScrollPane1.setViewportView(nome_cont);

        senha_cont.setText("jPasswordField1");

        btnSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/avaliacao2_gustavo_bizo/view/images/salvar.png"))); // NOI18N
        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        jLabel6.setText("TIPO:");

        btnNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/avaliacao2_gustavo_bizo/view/images/novo.png"))); // NOI18N
        btnNovo.setText("Novo");
        btnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoActionPerformed(evt);
            }
        });

        jScrollPane2.setViewportView(cpf_cont);

        jLabel7.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        jLabel7.setText("Consulta");

        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/avaliacao2_gustavo_bizo/view/images/cancelar.png"))); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        jtl_consultar_contraventor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "ID", "Nome"
            }
        ));
        jtl_consultar_contraventor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtl_consultar_contraventorMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(jtl_consultar_contraventor);

        jLabel3.setText("CPF:");

        jScrollPane3.setViewportView(login_cont);

        jLabel8.setText("NOME:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(110, 110, 110)
                                .addComponent(jLabel1))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane2))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnNovo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnSalvar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnCancelar))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(61, 61, 61)
                                .addComponent(btnExcluir)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnSair))
                            .addComponent(checkAlterarSenha)
                            .addComponent(tipo_cont, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(senha_cont))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel8)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnPesquisar))
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(173, 173, 173)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnPesquisar, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(12, 12, 12)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(9, 9, 9)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(senha_cont, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(checkAlterarSenha)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tipo_cont, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnSalvar)
                            .addComponent(btnCancelar)
                            .addComponent(btnNovo))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnExcluir)
                            .addComponent(btnSair))
                        .addGap(71, 71, 71))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarActionPerformed
        preencheTabela(pesquisa_nome_cont.getText());
    }//GEN-LAST:event_btnPesquisarActionPerformed

    private void checkAlterarSenhaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_checkAlterarSenhaMouseClicked
        if (checkAlterarSenha.isSelected()) {
            senha_cont.setEnabled(true);
        } else {
            senha_cont.setEnabled(false);
            senha_cont.setText(null);
        }
    }//GEN-LAST:event_checkAlterarSenhaMouseClicked

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        excluir();
        limpaCampos();
        liberaCampos(false);
        liberaBotoes(true, false, false, false, true);

        modelo_jtl_consultar_contraventor.setNumRows(0);
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void tipo_contActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tipo_contActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tipo_contActionPerformed

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnSairActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        if (gravar_alterar == 1) {
            gravar();
            gravar_alterar = 0;
        } else if (gravar_alterar == 2) {
            alterar();
            gravar_alterar = 0;
        } else {
            JOptionPane.showMessageDialog(null, "Erro no sistema!");
        }
        limpaCampos();
        liberaCampos(false);
        liberaBotoes(true, false, false, false, true);
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
        liberaCampos(true);
        liberaBotoes(false, true, true, false, true);
        checkAlterarSenha.setEnabled(false);
        gravar_alterar = 1;
    }//GEN-LAST:event_btnNovoActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        limpaCampos();
        liberaCampos(false);
        modelo_jtl_consultar_contraventor.setRowCount(0);
        liberaBotoes(true, false, false, false, true);
        this.gravar_alterar = 0;
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void jtl_consultar_contraventorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtl_consultar_contraventorMouseClicked
        preencheCampos(Integer.parseInt(String.valueOf(
            jtl_consultar_contraventor.getValueAt(
                jtl_consultar_contraventor.getSelectedRow(), 0))));
liberaBotoes(false, true, true, true, true);
    }//GEN-LAST:event_jtl_consultar_contraventorMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnNovo;
    private javax.swing.JButton btnPesquisar;
    private javax.swing.JButton btnSair;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JCheckBox checkAlterarSenha;
    private javax.swing.JTextPane cpf_cont;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTable jtl_consultar_contraventor;
    private javax.swing.JTextPane login_cont;
    private javax.swing.JTextPane nome_cont;
    private javax.swing.JTextPane pesquisa_nome_cont;
    private javax.swing.JPasswordField senha_cont;
    private javax.swing.JComboBox<String> tipo_cont;
    // End of variables declaration//GEN-END:variables
}
