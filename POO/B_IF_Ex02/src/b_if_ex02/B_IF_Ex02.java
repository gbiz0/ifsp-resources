/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package b_if_ex02;

import javax.swing.JOptionPane;

/**
 *
 * @author gbiz0
 */
public class B_IF_Ex02 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       Solo solo = new Solo();
        
        JOptionPane.showMessageDialog(null, "A situação do solo: " + 
                solo.calcular(
                Double.parseDouble(JOptionPane.showInputDialog("Digite a quantidade de água:"))
                ));
    }
}
