/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package d_while_ex03;

import javax.swing.JOptionPane;

/**
 *
 * @author gbiz0
 */
public class D_While_Ex03 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String letra = "";
        Vogal vogal = new Vogal();
        
            while (!letra.equalsIgnoreCase("0")){
                letra = JOptionPane.showInputDialog("Informe a letra: ");
                vogal.verificar(letra);
            }
        
            JOptionPane.showMessageDialog(null,vogal.mostra());
    }
    
}
