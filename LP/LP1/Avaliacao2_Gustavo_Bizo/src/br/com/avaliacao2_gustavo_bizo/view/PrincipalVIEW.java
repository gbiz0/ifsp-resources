/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/MDIApplication.java to edit this template
 */
package br.com.avaliacao2_gustavo_bizo.view;
import javax.swing.JOptionPane;
import br.com.avaliacao2_gustavo_bizo.dto.ContraventorDTO;
import java.awt.Image;
import java.awt.Graphics;
import javax.swing.ImageIcon;
/**
 *
 * @author gbiz0
 */
public class PrincipalVIEW extends javax.swing.JFrame {

    /**
     * Creates new form MenuVIEW
     */
    public PrincipalVIEW(ContraventorDTO contraventorDTO) {
        initComponents();
        this.setLocationRelativeTo(null);
        if (contraventorDTO.getTipo_cont().equalsIgnoreCase("COMUM")) {;
            itemMenuContra.setVisible(false);
        }
        
        setExtendedState(MAXIMIZED_BOTH);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    private void sair() {
        Object[] options = {"Sair", "Cancelar"};
        if (JOptionPane.showOptionDialog(null, "Deseja Sair do Sistema", "Informação",
                JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]) == 0) {
            System.exit(0);
        }
    }
    
    private void abreBichoView(){
        BichoVIEW bichoVIEW = new BichoVIEW();
        this.desktopPane.add(bichoVIEW);
        bichoVIEW.setVisible(true);
        bichoVIEW.setPosicao();
    }
    private void abreClienteView(){
        ClienteVIEW clienteVIEW = new ClienteVIEW();
        this.desktopPane.add(clienteVIEW);
        clienteVIEW.setVisible(true);
        clienteVIEW.setPosicao();
    }
    private void abreContraventorView(){
        ContraventorVIEW contraventorVIEW = new ContraventorVIEW();
        this.desktopPane.add(contraventorVIEW);
        contraventorVIEW.setVisible(true);
        contraventorVIEW.setPosicao();
    }
    private void abreApostaView(){
        ApostaVIEW apostaVIEW = new ApostaVIEW();
        this.desktopPane.add(apostaVIEW);
        apostaVIEW.setVisible(true);
        apostaVIEW.setPosicao();
    }
    
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ImageIcon imageIcon = new ImageIcon(getClass().getResource("images/tela_inicial.png"));
        Image image = imageIcon.getImage();
        desktopPane = new javax.swing.JDesktopPane(){
            public void paintComponent(Graphics graphics){
                graphics.drawImage(image, 0, 0, getWidth(), getHeight(), this);
            }
        };
        menuBar = new javax.swing.JMenuBar();
        MenuBicho = new javax.swing.JMenu();
        itemMenuContra = new javax.swing.JMenuItem();
        itemMenuBicho = new javax.swing.JMenuItem();
        itemMenuCli = new javax.swing.JMenuItem();
        itemMenuApos = new javax.swing.JMenuItem();
        menuSair = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        MenuBicho.setMnemonic('f');
        MenuBicho.setText("Início");

        itemMenuContra.setMnemonic('x');
        itemMenuContra.setText("Contraventor");
        itemMenuContra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemMenuContraActionPerformed(evt);
            }
        });
        MenuBicho.add(itemMenuContra);

        itemMenuBicho.setText("Bicho");
        itemMenuBicho.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemMenuBichoActionPerformed(evt);
            }
        });
        MenuBicho.add(itemMenuBicho);

        itemMenuCli.setText("Cliente");
        itemMenuCli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemMenuCliActionPerformed(evt);
            }
        });
        MenuBicho.add(itemMenuCli);

        itemMenuApos.setText("Aposta");
        itemMenuApos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemMenuAposActionPerformed(evt);
            }
        });
        MenuBicho.add(itemMenuApos);

        menuBar.add(MenuBicho);

        menuSair.setMnemonic('h');
        menuSair.setText("Sair");
        menuSair.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuSairMouseClicked(evt);
            }
        });
        menuBar.add(menuSair);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktopPane, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktopPane, javax.swing.GroupLayout.DEFAULT_SIZE, 279, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void itemMenuContraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemMenuContraActionPerformed
        abreContraventorView();
    }//GEN-LAST:event_itemMenuContraActionPerformed

    private void menuSairMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuSairMouseClicked
        sair();
    }//GEN-LAST:event_menuSairMouseClicked

    private void itemMenuBichoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemMenuBichoActionPerformed
        abreBichoView();
    }//GEN-LAST:event_itemMenuBichoActionPerformed

    private void itemMenuCliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemMenuCliActionPerformed
        abreClienteView();
    }//GEN-LAST:event_itemMenuCliActionPerformed

    private void itemMenuAposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemMenuAposActionPerformed
        abreApostaView();
    }//GEN-LAST:event_itemMenuAposActionPerformed

    /**
     * @param args the command line arguments
     */


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu MenuBicho;
    private javax.swing.JDesktopPane desktopPane;
    private javax.swing.JMenuItem itemMenuApos;
    private javax.swing.JMenuItem itemMenuBicho;
    private javax.swing.JMenuItem itemMenuCli;
    private javax.swing.JMenuItem itemMenuContra;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenu menuSair;
    // End of variables declaration//GEN-END:variables

}