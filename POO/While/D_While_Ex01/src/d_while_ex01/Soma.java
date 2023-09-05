/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package d_while_ex01;

/**
 *
 * @author gbiz0
 */
public class Soma {
    private int soma, number;
    
    public void somar (int number){
        this.number = number;
        this.soma += this.number;
    }
    
    public int mostra() {
        return this.soma;
    }
}
