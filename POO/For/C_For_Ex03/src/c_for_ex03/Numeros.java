/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package c_for_ex03;

import javax.swing.JOptionPane;

/**
 *
 * @author gbiz0
 */
public class Numeros {
    private int number;
    
    public void calcular(){
        this.number = number;
        
        for (int i = 1; i <= 10; i++) {
            int receba = Integer.parseInt(JOptionPane.showInputDialog("Digite o número "+ i));
            number += receba;
        }
    }
    public void show(){
        JOptionPane.showMessageDialog(null, "Resultado: "+ this.number);
    }
}

