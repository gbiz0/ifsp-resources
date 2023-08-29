/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package b_if_ex03;

import javax.swing.JOptionPane;

/**
 *
 * @author gbiz0
 */
public class B_IF_Ex03 {

    public static void main(String[] args) {
        Numero numero = new Numero();
        
        JOptionPane.showMessageDialog(null, "Números em ordem decrescente: " + 
                numero.calcular(
                Integer.parseInt(JOptionPane.showInputDialog("Digite os três próximos números em ordem crescente, número 1:")),
                Integer.parseInt(JOptionPane.showInputDialog("Número 2:")),
                Integer.parseInt(JOptionPane.showInputDialog("Número 3:")),
                Integer.parseInt(JOptionPane.showInputDialog("O último número pode ser aleatorio:"))
                ));
    }
    
}
