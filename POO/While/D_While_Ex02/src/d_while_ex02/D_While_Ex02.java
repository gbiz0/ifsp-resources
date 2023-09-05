/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package d_while_ex02;

import javax.swing.JOptionPane;

/**
 *
 * @author gbiz0
 */
public class D_While_Ex02 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String letra = "x";
        Letra exemplo = new Letra();
        
        while (letra.equalsIgnoreCase("x")) {
            letra = JOptionPane.showInputDialog("Informe a letra: ");
            exemplo.verificar(letra); 
            
        }
        JOptionPane.showMessageDialog(null, "Quantidade: " + exemplo.mostra());
    }
    
}
