/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package br.com.avaliacao2_gustavo_bizo.view;
import java.awt.Dimension;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;
import br.com.avaliacao2_gustavo_bizo.dto.ApostaDTO;
import br.com.avaliacao2_gustavo_bizo.ctr.ApostaCTR;
import br.com.avaliacao2_gustavo_bizo.dto.BichoDTO;
import br.com.avaliacao2_gustavo_bizo.ctr.BichoCTR;
import br.com.avaliacao2_gustavo_bizo.dto.ClienteDTO;
import br.com.avaliacao2_gustavo_bizo.ctr.ClienteCTR;
import java.util.Date;

/**
 *
 * @author gbiz0
 */
public class ApostaVIEW extends javax.swing.JInternalFrame {
    ApostaDTO apostaDTO = new ApostaDTO();
    ApostaCTR apostaCTR = new ApostaCTR();
    BichoDTO bichoDTO = new BichoDTO();
    BichoCTR bichoCTR = new BichoCTR();
    ClienteCTR clienteCTR = new ClienteCTR();
    ClienteDTO clienteDTO = new ClienteDTO();
    
    ResultSet rs;
    DefaultTableModel modelo_jtl_consultar_cli;
    DefaultTableModel modelo_jtl_consultar_bicho;
    DefaultTableModel modelo_jtl_consultar_bicho_selecionado;
    public void setPosicao() {
        Dimension d = this.getDesktopPane().getSize();
        this.setLocation((d.width - this.getSize().width) / 2, (d.height - this.getSize().height) / 2);
    }
    
    public void gravar() {
        try {
            apostaDTO.setVal_aposta(Double.parseDouble(TotalAposta.getText()));
            clienteDTO.setId_cli(Integer.parseInt(String.valueOf(
                    jtl_consultar_cli.getValueAt(jtl_consultar_cli.getSelectedRow(), 0))));
            
            JOptionPane.showMessageDialog(null, 
                    apostaCTR.inserirAposta(apostaDTO, clienteDTO, jtl_consultar_bicho_selecionado));
        } catch (Exception e) {
            System.out.println("Erro ao gravar " + e.getMessage());
        }
    }
    
    public void preencheTabelaCliente(String nome_cli) {
        try {
            modelo_jtl_consultar_cli.setNumRows(0);
            clienteDTO.setNome_cli(nome_cli);

            rs = clienteCTR.consultarCliente(clienteDTO, 1);

            while (rs.next()) {
                modelo_jtl_consultar_cli.addRow(new Object[]{
                    rs.getString("id_cli"),
                    rs.getString("nome_cli"),});
            }
        } catch (Exception erTab) {
            System.out.println("Erro SQL: " + erTab);
        } finally {
            clienteCTR.CloseDB();
        }
    }
    
    public void preencheTabelaBicho(String nome_bicho) {
        try {
            modelo_jtl_consultar_bicho.setNumRows(0);
            bichoDTO.setNome_bicho(nome_bicho);

            rs = bichoCTR.consultarBicho(bichoDTO, 1);

            while (rs.next()) {
                modelo_jtl_consultar_bicho.addRow(new Object[]{
                    rs.getString("id_bicho"),
                    rs.getString("nome_bicho"),
                    rs.getDouble("val_aposta"),});
            }
        } catch (Exception erTab) {
            System.out.println("Erro SQL: "+erTab);
        } finally {
            bichoCTR.CloseDB();
        }
    }
    
    private void calculaTotalVenda(){
        try {
            double total = 0;
            for (int cont = 0; cont < jtl_consultar_bicho_selecionado.getRowCount(); cont++) {
                total += (Double.parseDouble(String.valueOf(
                        jtl_consultar_bicho_selecionado.getValueAt(cont, 2)))*
                        Integer.parseInt(String.valueOf(
                                jtl_consultar_bicho_selecionado.getValueAt(cont, 3))));
            }
            TotalAposta.setText(String.valueOf(total));
            
        } catch (Exception erTab) {
            System.out.println("Erro SQL: "+erTab);
        }
    }
    
    private void adicionaBichoSelecionado(int id_bicho, String nome_bicho, double val_aposta){
        try {
            modelo_jtl_consultar_bicho_selecionado.addRow(new Object[]{
                id_bicho,
                nome_bicho,
                val_aposta
            });
        } catch (Exception erTab) {
            System.out.println("Erro SQL: "+erTab);
        }
    }

    private void removeBichoSelecionado(int linha_selecionada){
        try {
            if (linha_selecionada >= 0){
                 modelo_jtl_consultar_bicho_selecionado.removeRow(linha_selecionada);
                 calculaTotalVenda();
            }
        } catch (Exception erTab) {
            System.out.println("Erro SQL: "+erTab);
        }
    }
    
    private void liberaCampos(boolean a) {
        pesquisa_nome_cli.setEnabled(a);
        btnPesquisarCli.setEnabled(a);
        jtl_consultar_cli.setEnabled(a);
        pesquisa_nome_bicho.setEnabled(a);
        btnPesquisarBicho.setEnabled(a);
        jtl_consultar_bicho.setEnabled(a);
        btnBichoAdd.setEnabled(a);
        btnBichoRem.setEnabled(a);
        jtl_consultar_bicho_selecionado.setEnabled(a);
        TotalAposta.setText("0.00");
    }
    
    private void limpaCampos() {
        pesquisa_nome_cli.setText("");
        modelo_jtl_consultar_cli.setNumRows(0);
        pesquisa_nome_bicho.setText("");
        modelo_jtl_consultar_bicho.setNumRows(0);
        modelo_jtl_consultar_bicho_selecionado.setNumRows(0);
    }
    private void liberaBotoes(boolean a, boolean b, boolean c, boolean d) {
        btnNovo.setEnabled(a);
        btnSalvar.setEnabled(b);
        btnCancelar.setEnabled(c);
        btnSair.setEnabled(d);
    }
    private boolean verificaPreenchimento(){
    // Verifica se um cliente foi selecionado
    if(jtl_consultar_cli.getSelectedRowCount() <= 0){
        JOptionPane.showMessageDialog(null, "Deve ser selecionado um Cliente!");
        jtl_consultar_cli.requestFocus();
        return false;
    }
    // Verifica se há pelo menos um bicho adicionado
    else if (jtl_consultar_bicho_selecionado.getRowCount() <= 0){
        JOptionPane.showMessageDialog(null, "É necessário adicionar pelo menos um bicho na aposta");
        jtl_consultar_bicho_selecionado.requestFocus();
        return false;
    } 
    // Verifica se a quantidade de cada bicho foi informada
    else {
        int verifica = 0;
        for(int i = 0; i < jtl_consultar_bicho_selecionado.getRowCount(); i++){
            if(String.valueOf(jtl_consultar_bicho_selecionado.getValueAt(i, 3)).equalsIgnoreCase("null")){
                verifica++;
            }
        }
        if(verifica > 0){
            JOptionPane.showMessageDialog(null, "A quantidade de cada bicho apostado deve ser informada");
            jtl_consultar_bicho_selecionado.requestFocus();
            return false;
        } else {
            return true;
        }
    }
}

    
    public ApostaVIEW() {
        initComponents();
        liberaCampos(false);
        liberaBotoes(true, false, false, true);
        
        modelo_jtl_consultar_cli = (DefaultTableModel) jtl_consultar_cli.getModel();
        modelo_jtl_consultar_bicho = (DefaultTableModel) jtl_consultar_bicho.getModel();
        modelo_jtl_consultar_bicho_selecionado = (DefaultTableModel) jtl_consultar_bicho_selecionado.getModel();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnCancelar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        pesquisa_nome_cli = new javax.swing.JTextField();
        btnPesquisarCli = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtl_consultar_cli = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        TotalAposta = new javax.swing.JLabel();
        btnSair = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        btnNovo = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        pesquisa_nome_bicho = new javax.swing.JTextField();
        btnPesquisarBicho = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtl_consultar_bicho_selecionado = new javax.swing.JTable();
        btnBichoAdd = new javax.swing.JButton();
        btnBichoRem = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jtl_consultar_bicho = new javax.swing.JTable();

        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/avaliacao2_gustavo_bizo/view/images/cancelar.png"))); // NOI18N
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Dados"));

        jLabel1.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        jLabel1.setText("Cliente:");

        pesquisa_nome_cli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pesquisa_nome_cliActionPerformed(evt);
            }
        });

        btnPesquisarCli.setText("OK");
        btnPesquisarCli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarCliActionPerformed(evt);
            }
        });

        jtl_consultar_cli.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jtl_consultar_cli);

        jLabel2.setFont(new java.awt.Font("Liberation Sans", 0, 36)); // NOI18N
        jLabel2.setText("Total Apostas:");

        TotalAposta.setFont(new java.awt.Font("Liberation Sans", 0, 36)); // NOI18N
        TotalAposta.setText("0.00");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pesquisa_nome_cli)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnPesquisarCli))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(TotalAposta)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(pesquisa_nome_cli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPesquisarCli))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(80, 80, 80)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(TotalAposta))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        btnSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/avaliacao2_gustavo_bizo/view/images/sair.png"))); // NOI18N
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Liberation Sans", 1, 24)); // NOI18N
        jLabel3.setText("Apostas");

        btnNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/avaliacao2_gustavo_bizo/view/images/novo.png"))); // NOI18N
        btnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoActionPerformed(evt);
            }
        });

        btnSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/avaliacao2_gustavo_bizo/view/images/salvar.png"))); // NOI18N
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Bicho"));

        jLabel4.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        jLabel4.setText("Descrição:");

        pesquisa_nome_bicho.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pesquisa_nome_bichoActionPerformed(evt);
            }
        });

        btnPesquisarBicho.setText("OK");
        btnPesquisarBicho.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarBichoActionPerformed(evt);
            }
        });

        jtl_consultar_bicho_selecionado.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Nome", "Valor", "QTDE"
            }
        ));
        jtl_consultar_bicho_selecionado.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtl_consultar_bicho_selecionadoKeyReleased(evt);
            }
        });
        jScrollPane2.setViewportView(jtl_consultar_bicho_selecionado);

        btnBichoAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/avaliacao2_gustavo_bizo/view/images/prod_add.png"))); // NOI18N
        btnBichoAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBichoAddActionPerformed(evt);
            }
        });

        btnBichoRem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/avaliacao2_gustavo_bizo/view/images/prod_rem.png"))); // NOI18N
        btnBichoRem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBichoRemActionPerformed(evt);
            }
        });

        jtl_consultar_bicho.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID", "Nome", "Valor"
            }
        ));
        jScrollPane3.setViewportView(jtl_consultar_bicho);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pesquisa_nome_bicho)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnPesquisarBicho)
                        .addGap(61, 61, 61))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addContainerGap())))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnBichoAdd)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnBichoRem)
                .addGap(165, 165, 165))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane3)
                    .addContainerGap()))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(pesquisa_nome_bicho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPesquisarBicho))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBichoAdd)
                    .addComponent(btnBichoRem))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(65, 65, 65)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(201, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(32, 32, 32))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnNovo)
                .addGap(18, 18, 18)
                .addComponent(btnSalvar)
                .addGap(18, 18, 18)
                .addComponent(btnCancelar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSair)
                .addGap(426, 426, 426))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNovo)
                    .addComponent(btnSalvar)
                    .addComponent(btnCancelar)
                    .addComponent(btnSair))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.getAccessibleContext().setAccessibleName("Aposta");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        limpaCampos();
        liberaCampos(false);
        modelo_jtl_consultar_cli.setNumRows(0);
        modelo_jtl_consultar_bicho.setNumRows(0);
        liberaBotoes(true, false, false, true);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void pesquisa_nome_cliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pesquisa_nome_cliActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pesquisa_nome_cliActionPerformed

    private void btnPesquisarCliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarCliActionPerformed
        preencheTabelaCliente(pesquisa_nome_cli.getText());
    }//GEN-LAST:event_btnPesquisarCliActionPerformed

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnSairActionPerformed

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
        liberaCampos(true);
        liberaBotoes(false, true, true, true);
    }//GEN-LAST:event_btnNovoActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        if (verificaPreenchimento()) {
            gravar();
            limpaCampos();
            liberaCampos(false);
            liberaBotoes(true, false, false, true);
        }
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void pesquisa_nome_bichoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pesquisa_nome_bichoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pesquisa_nome_bichoActionPerformed

    private void btnPesquisarBichoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarBichoActionPerformed
        preencheTabelaBicho(pesquisa_nome_bicho.getText());
    }//GEN-LAST:event_btnPesquisarBichoActionPerformed

    private void jtl_consultar_bicho_selecionadoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtl_consultar_bicho_selecionadoKeyReleased
        if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER) {
            calculaTotalVenda();
        }
    }//GEN-LAST:event_jtl_consultar_bicho_selecionadoKeyReleased

    private void btnBichoAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBichoAddActionPerformed
        adicionaBichoSelecionado(
            Integer.parseInt(String.valueOf(jtl_consultar_bicho.getValueAt(
                jtl_consultar_bicho.getSelectedRow(), 0))),
    String.valueOf(jtl_consultar_bicho.getValueAt(jtl_consultar_bicho.getSelectedRow(), 1)),
    Double.parseDouble(String.valueOf(jtl_consultar_bicho.getValueAt(jtl_consultar_bicho.getSelectedRow(), 2)))
    );
    }//GEN-LAST:event_btnBichoAddActionPerformed

    private void btnBichoRemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBichoRemActionPerformed
        removeBichoSelecionado(jtl_consultar_bicho_selecionado.getSelectedRow());
    }//GEN-LAST:event_btnBichoRemActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel TotalAposta;
    private javax.swing.JButton btnBichoAdd;
    private javax.swing.JButton btnBichoRem;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnNovo;
    private javax.swing.JButton btnPesquisarBicho;
    private javax.swing.JButton btnPesquisarCli;
    private javax.swing.JButton btnSair;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jtl_consultar_bicho;
    private javax.swing.JTable jtl_consultar_bicho_selecionado;
    private javax.swing.JTable jtl_consultar_cli;
    private javax.swing.JTextField pesquisa_nome_bicho;
    private javax.swing.JTextField pesquisa_nome_cli;
    // End of variables declaration//GEN-END:variables
}
