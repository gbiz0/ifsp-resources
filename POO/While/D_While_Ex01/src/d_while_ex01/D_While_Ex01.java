/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package d_while_ex01;

import javax.swing.JOptionPane;

/**
 *
 * @author gbiz0
 */
public class D_While_Ex01 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int number = 1;
        Soma soma = new Soma();
        
        while (number != 0) {
            number = Integer.parseInt(
                    JOptionPane.showInputDialog("Informe um número: " ));
            soma.somar(number);
        }
        JOptionPane.showMessageDialog(null, soma.mostra());
    }
    
}
