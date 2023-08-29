/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package b_if_ex01;

import javax.swing.JOptionPane;

/**
 *
 * @author gbiz0
 */
public class B_IF_Ex01 {

    public static void main(String[] args) {
        Media media = new Media();
        
        JOptionPane.showMessageDialog(null, "A situação do aluno: " + 
                media.calcular(
                Double.parseDouble(JOptionPane.showInputDialog("Digite a nota 1:")),
                Double.parseDouble(JOptionPane.showInputDialog("Digite a nota 2:"))
                ));
    }
}
