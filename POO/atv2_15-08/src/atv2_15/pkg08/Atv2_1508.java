/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package atv2_15.pkg08;

import javax.swing.JOptionPane;

/**
 *
 * @author gbiz0
 */
public class Atv2_1508 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Funcionario funcionario = new Funcionario();
        double salario = Double.parseDouble (JOptionPane.showInputDialog("Informe seu salário: "));
        double porcent = Double.parseDouble (JOptionPane.showInputDialog("Informe a porcentagem de aumento: "));
        
        JOptionPane.showMessageDialog(null, funcionario.salario(salario, porcent));

    }
    
}
