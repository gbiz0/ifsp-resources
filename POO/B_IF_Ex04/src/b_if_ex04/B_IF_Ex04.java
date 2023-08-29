/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package b_if_ex04;

import javax.swing.JOptionPane;

/**
 *
 * @author gbiz0
 */
public class B_IF_Ex04 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Pessoa pessoa = new Pessoa();
        
        JOptionPane.showMessageDialog(null, "Sua classificação: " + 
                pessoa.calcular(
                Double.parseDouble(JOptionPane.showInputDialog("Digite seu peso:")),
                Double.parseDouble(JOptionPane.showInputDialog("Digite sua altura:"))
                ));
    }
    
}
