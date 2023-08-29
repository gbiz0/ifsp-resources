/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package c_for_ex01;

import javax.swing.JOptionPane;

/**
 *
 * @author gbiz0
 */
public class C_For_Ex01 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Tabuada tabuada = new Tabuada();
        
        JOptionPane.showMessageDialog(null, "Sua tabuada: " + 
                tabuada.calcular_Tabuada(
                Integer.parseInt(JOptionPane.showInputDialog("Digite o número:"))
                ));
    }
    
}
