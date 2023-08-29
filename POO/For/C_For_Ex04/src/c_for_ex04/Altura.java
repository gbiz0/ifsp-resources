/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package c_for_ex04;

import javax.swing.JOptionPane;

/**
 *
 * @author gbiz0
 */
public class Altura {
    private double number, media;
    private int maior;
    
    public void calcular(){
        this.number = number;
        
        for (int i = 1; i <= 10; i++) {
            double receba = Double.parseDouble(JOptionPane.showInputDialog("Digite a altura da pessoa "+ i));
            
            if(receba >= 2){
                maior++;
            }
            
            number += receba;
        }
    }
    
    public double media() {
        return this.number/10;
    }
    
    public void show(){
        JOptionPane.showMessageDialog(null, "Resultado da média: "+ this.media);
        JOptionPane.showMessageDialog(null, "Pessoas acima de 2 metros: "+ this.maior);
    }
}

