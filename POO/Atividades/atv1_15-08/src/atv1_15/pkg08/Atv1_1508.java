/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package atv1_15.pkg08;

import javax.swing.JOptionPane;

/**
 *
 * @author gbiz0
 */
public class Atv1_1508 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Notas notas = new Notas();
            double n1 = Double.parseDouble (JOptionPane.showInputDialog("Informe a nota 1: "));
            double n2 = Double.parseDouble (JOptionPane.showInputDialog("Informe a nota 2: "));
            double n3 = Double.parseDouble (JOptionPane.showInputDialog("Informe a nota 3: "));
            double p1 = Double.parseDouble (JOptionPane.showInputDialog("Informe o peso da nota 1: "));
            double p2 = Double.parseDouble (JOptionPane.showInputDialog("Informe o peso da nota 2: "));
            double p3 = Double.parseDouble (JOptionPane.showInputDialog("Informe o peso da nota 3: "));
            
            JOptionPane.showMessageDialog(null, notas.receber(n1, n2, n3, p1, p2, p3));
        
    }
    
}
