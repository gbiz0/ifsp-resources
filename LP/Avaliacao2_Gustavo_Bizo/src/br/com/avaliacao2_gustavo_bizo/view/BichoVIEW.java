/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package br.com.avaliacao2_gustavo_bizo.view;

import br.com.avaliacao2_gustavo_bizo.ctr.BichoCTR;
import br.com.avaliacao2_gustavo_bizo.ctr.ContraventorCTR;
import br.com.avaliacao2_gustavo_bizo.dto.BichoDTO;
import br.com.avaliacao2_gustavo_bizo.dto.ContraventorDTO;
import java.awt.Dimension;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author gbiz0
 */
public class BichoVIEW extends javax.swing.JInternalFrame {

    /**
     * Creates new form BichoVIEW
     */
    BichoDTO bichoDTO = new BichoDTO();
    BichoCTR bichoCTR = new BichoCTR();
    ContraventorDTO contraventorDTO = new ContraventorDTO();
    ContraventorCTR contraventorCTR = new ContraventorCTR();
    int gravar_alterar;
    ResultSet rs;
    DefaultTableModel modelo_jtl_consultar_bicho;
    DefaultTableModel modelo_jtl_consultar_contraventor;

    /**
     * Creates new form ClienteVIEW
     */
    public BichoVIEW() {
        initComponents();
        liberaCampos(false);
        liberaBotoes(true, false, false, false, true);

        modelo_jtl_consultar_bicho = (DefaultTableModel) jtl_consultar_bicho.getModel();
        modelo_jtl_consultar_contraventor = (DefaultTableModel) jtl_consultar_contraventor.getModel();
    }
    
    public void setPosicao() {
        Dimension d = this.getDesktopPane().getSize();
        this.setLocation((d.width - this.getSize().width) / 2, (d.height - this.getSize().height) / 2);
    }

    private void liberaCampos(boolean a) {
        nome_bicho.setEnabled(a);
        tipo_aposta.setEnabled(a);
        val_aposta.setEnabled(a);
        banca_aposta.setEnabled(a);
    }

    private void limpaCampos() {
        val_aposta.setText("");
        banca_aposta.setText("");
    }

    private void liberaBotoes(boolean a, boolean b, boolean c, boolean d, boolean e) {
        btnNovo.setEnabled(a);
        btnSalvar.setEnabled(b);
        btnCancelar.setEnabled(c);
        btnExcluir.setEnabled(d);
        btnSair.setEnabled(e);
    }

    public void gravar() {
        try {
            bichoDTO.setNome_bicho(nome_bicho.getSelectedItem().toString());
            bichoDTO.setTipo_aposta(tipo_aposta.getSelectedItem().toString());
            bichoDTO.setVal_aposta(Double.parseDouble(val_aposta.getText()));
            bichoDTO.setBanca_aposta(banca_aposta.getText());
            contraventorDTO.setId_cont(Integer.parseInt(String.valueOf(
                    jtl_consultar_contraventor.getValueAt(
                            jtl_consultar_contraventor.getSelectedRow(), 0))));
            JOptionPane.showMessageDialog(null, bichoCTR.inserirBicho(bichoDTO, contraventorDTO));
        } catch (Exception e) {
            System.out.println("Erro ao gravar " + e.getMessage());
        }
    }

    public void preencheTabela(String nome_bicho) {
        try {
            modelo_jtl_consultar_bicho.setNumRows(0);
            bichoDTO.setNome_bicho(nome_bicho);

            rs = bichoCTR.consultarBicho(bichoDTO, 1);

            while (rs.next()) {
                modelo_jtl_consultar_bicho.addRow(new Object[]{
                    rs.getString("id_bicho"),
                    rs.getString("nome_bicho"),  
                    rs.getString("tipo_aposta"),  
                });
            }
        } catch (Exception erTab) {
            System.out.println("Erro SQL: " + erTab);
        } finally {
            bichoCTR.CloseDB();
        }
    }

    public void preencheCampos(int id_bicho) {
        try {
            bichoDTO.setId_bicho(id_bicho);
            rs = bichoCTR.consultarBicho(bichoDTO, 2);

            if (rs.next()) {
                limpaCampos();
                nome_bicho.setSelectedItem(rs.getString("nome_bicho"));
                tipo_aposta.setSelectedItem(rs.getString("tipo_aposta"));
                val_aposta.setText(rs.getString("val_aposta"));
                banca_aposta.setText(rs.getString("banca_aposta"));

                modelo_jtl_consultar_contraventor.setNumRows(0);
                modelo_jtl_consultar_contraventor.addRow(new Object[]{rs.getInt("id_cont"), rs.getString("nome_cont"),});
                jtl_consultar_contraventor.setRowSelectionInterval(0, 0);
            }
            gravar_alterar = 2;
            liberaCampos(true);
        } catch (Exception erTab) {
            System.out.println("Erro SQL: " + erTab);
        }
    }

    public void alterar() {
        try {
            if (bichoDTO.getNome_bicho() == null) {
                bichoDTO.setNome_bicho(nome_bicho.getSelectedItem().toString());
            } else {
                nome_bicho.setSelectedItem(bichoDTO.getNome_bicho());
            }
            if (bichoDTO.getTipo_aposta() == null) {
                bichoDTO.setTipo_aposta(tipo_aposta.getSelectedItem().toString());
            } else {
                tipo_aposta.setSelectedItem(bichoDTO.getTipo_aposta());
            }
            bichoDTO.setVal_aposta(Double.parseDouble(val_aposta.getText()));
            bichoDTO.setBanca_aposta(banca_aposta.getText());
            contraventorDTO.setId_cont(Integer.parseInt(String.valueOf(
                    jtl_consultar_contraventor.getValueAt(
                            jtl_consultar_contraventor.getSelectedRow(), 0))));
            JOptionPane.showMessageDialog(null, bichoCTR.alterarBicho(bichoDTO, contraventorDTO));

        } catch (Exception erTab) {
            System.out.println("Erro ao alterar: " + erTab);
        }
    }

    public void excluir() {
        if (JOptionPane.showConfirmDialog(null, "Deseja excluir o bicho?", "Aviso!",
                JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            JOptionPane.showMessageDialog(null, bichoCTR.excluirBicho(bichoDTO));
        };
    }
    
    public void preencheTabelaContraventor(String nome_cont) {
        try {
            modelo_jtl_consultar_contraventor.setNumRows(0);
            contraventorDTO.setNome_cont(nome_cont);

            rs = contraventorCTR.consultarContraventor(contraventorDTO, 1);

            while (rs.next()) {
                modelo_jtl_consultar_contraventor.addRow(new Object[]{
                    rs.getString("id_cont"),
                    rs.getString("nome_cont"),});
            }
        } catch (Exception erTab) {
            System.out.println("Erro SQL: " + erTab);
        } finally {
            bichoCTR.CloseDB();
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

        jLabel8 = new javax.swing.JLabel();
        tipo_aposta = new javax.swing.JComboBox<>();
        jLabel15 = new javax.swing.JLabel();
        nome_bicho = new javax.swing.JComboBox<>();
        jScrollPane9 = new javax.swing.JScrollPane();
        pesquisa_nome_contraventor = new javax.swing.JTextPane();
        jLabel14 = new javax.swing.JLabel();
        btnSearch = new javax.swing.JButton();
        btnNovo = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnSair = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        pesquisa_nome_bicho = new javax.swing.JTextField();
        btnPesquisarContraventor = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtl_consultar_bicho = new javax.swing.JTable();
        jScrollPane6 = new javax.swing.JScrollPane();
        jtl_consultar_contraventor = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        banca_aposta = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        val_aposta = new javax.swing.JTextField();

        jLabel8.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        jLabel8.setText("Tipo:");

        tipo_aposta.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Aposta Simples", "Cercados", "Duques", "Ternos", "Passe" }));
        tipo_aposta.setToolTipText("");
        tipo_aposta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tipo_apostaActionPerformed(evt);
            }
        });

        jLabel15.setText("CONTRAVENTOR:");

        nome_bicho.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "01 - Avestruz", "02 - Águia", "03 - Burro", "04 - Borboleta", "05 - Cachorro", "06 - Cabra", "07 - Carneiro", "08 - Camelo", "09 - Cobra", "10 - Coelho", "11  - Cavalo", "12 - Elefante", "13 - Galo", "14 - Gato", "15 - Jacaré", "16 - Leão", "17 - Macaco", "18 - Porco", "19 - Pavão", "20 - Peru    ", "21 - Touro", "22 - Tigre", "23 - Urso", "24 - Veado", "25 - Vaca" }));
        nome_bicho.setToolTipText("");
        nome_bicho.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nome_bichoActionPerformed(evt);
            }
        });

        jScrollPane9.setViewportView(pesquisa_nome_contraventor);

        jLabel14.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        jLabel14.setText("Bicho:");

        btnSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/avaliacao2_gustavo_bizo/view/images/pesquisar.png"))); // NOI18N
        btnSearch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSearchMouseClicked(evt);
            }
        });
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        btnNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/avaliacao2_gustavo_bizo/view/images/novo.png"))); // NOI18N
        btnNovo.setText("Novo");
        btnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoActionPerformed(evt);
            }
        });

        btnSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/avaliacao2_gustavo_bizo/view/images/salvar.png"))); // NOI18N
        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/avaliacao2_gustavo_bizo/view/images/cancelar.png"))); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/avaliacao2_gustavo_bizo/view/images/excluir.png"))); // NOI18N
        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        btnSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/avaliacao2_gustavo_bizo/view/images/sair.png"))); // NOI18N
        btnSair.setText("Sair");
        btnSair.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSairMouseClicked(evt);
            }
        });
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        jLabel11.setText("Bicho");

        jLabel12.setFont(new java.awt.Font("Liberation Sans", 1, 14)); // NOI18N
        jLabel12.setText("Nome:");

        btnPesquisarContraventor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/avaliacao2_gustavo_bizo/view/images/pesquisar.png"))); // NOI18N
        btnPesquisarContraventor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnPesquisarContraventorMouseClicked(evt);
            }
        });
        btnPesquisarContraventor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarContraventorActionPerformed(evt);
            }
        });

        jtl_consultar_bicho.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID", "Bicho", "Tipo"
            }
        ));
        jtl_consultar_bicho.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtl_consultar_bichoMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jtl_consultar_bicho);

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
        jScrollPane6.setViewportView(jtl_consultar_contraventor);

        jLabel1.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        jLabel1.setText("Cadastro de Bicho");

        jLabel13.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        jLabel13.setText("Banca:");

        jLabel16.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        jLabel16.setText("Valor:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 12, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel15)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnPesquisarContraventor))
                            .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 489, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tipo_aposta, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel16)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(val_aposta))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel14)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(nome_bicho, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel13)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(banca_aposta, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pesquisa_nome_bicho, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSearch))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 469, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(357, 357, 357))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(124, 124, 124)
                        .addComponent(jLabel1)
                        .addGap(447, 447, 447)
                        .addComponent(jLabel11))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(351, 351, 351)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnNovo)
                                .addGap(39, 39, 39)
                                .addComponent(btnSalvar)
                                .addGap(39, 39, 39)
                                .addComponent(btnCancelar))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(57, 57, 57)
                                .addComponent(btnExcluir)
                                .addGap(39, 39, 39)
                                .addComponent(btnSair)
                                .addGap(69, 69, 69)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(pesquisa_nome_bicho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSearch))
                        .addGap(16, 16, 16)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(nome_bicho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(tipo_aposta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16)
                            .addComponent(val_aposta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(banca_aposta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnPesquisarContraventor, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNovo)
                    .addComponent(btnSalvar)
                    .addComponent(btnCancelar))
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnExcluir)
                    .addComponent(btnSair))
                .addGap(249, 249, 249))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tipo_apostaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tipo_apostaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tipo_apostaActionPerformed

    private void nome_bichoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nome_bichoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nome_bichoActionPerformed

    private void btnSearchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSearchMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSearchMouseClicked

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        preencheTabela(pesquisa_nome_bicho.getText());
    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
        liberaCampos(true);
        liberaBotoes(false, true, true, false, true);
        gravar_alterar = 1;
    }//GEN-LAST:event_btnNovoActionPerformed

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

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        limpaCampos();
        liberaCampos(false);
        modelo_jtl_consultar_bicho.setRowCount(0);
        liberaBotoes(true, false, false, false, true);
        this.gravar_alterar = 0;
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        excluir();
        limpaCampos();
        liberaCampos(false);
        liberaBotoes(true, false, false, false, true);

        modelo_jtl_consultar_bicho.setNumRows(0);
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnSairMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSairMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSairMouseClicked

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnSairActionPerformed

    private void btnPesquisarContraventorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarContraventorActionPerformed
        preencheTabelaContraventor(pesquisa_nome_contraventor.getText());
    }//GEN-LAST:event_btnPesquisarContraventorActionPerformed

    private void jtl_consultar_bichoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtl_consultar_bichoMouseClicked
        preencheCampos(Integer.parseInt(String.valueOf(
            jtl_consultar_bicho.getValueAt(
                jtl_consultar_bicho.getSelectedRow(), 0))));
liberaBotoes(false, true, true, true, true);
    }//GEN-LAST:event_jtl_consultar_bichoMouseClicked

    private void btnPesquisarContraventorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPesquisarContraventorMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnPesquisarContraventorMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField banca_aposta;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnNovo;
    private javax.swing.JButton btnPesquisarContraventor;
    private javax.swing.JButton btnSair;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JButton btnSearch;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTable jtl_consultar_bicho;
    private javax.swing.JTable jtl_consultar_contraventor;
    private javax.swing.JComboBox<String> nome_bicho;
    private javax.swing.JTextField pesquisa_nome_bicho;
    private javax.swing.JTextPane pesquisa_nome_contraventor;
    private javax.swing.JComboBox<String> tipo_aposta;
    private javax.swing.JTextField val_aposta;
    // End of variables declaration//GEN-END:variables
}
