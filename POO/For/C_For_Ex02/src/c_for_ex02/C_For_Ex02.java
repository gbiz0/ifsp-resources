/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package c_for_ex02;

import javax.swing.JOptionPane;

/**
 *
 * @author gbiz0
 */
public class C_For_Ex02 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Intervalo intervalo = new Intervalo();
        
        JOptionPane.showMessageDialog(null, "Sua resposta: \n" + 
                intervalo.calcular_Tabuada(
                Integer.parseInt(JOptionPane.showInputDialog("Digite o número:")),
                Integer.parseInt(JOptionPane.showInputDialog("Digite outro número:"))
                ));
        
    }
    
}
