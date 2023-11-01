/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package atv1_15.pkg08;

import javax.swing.JOptionPane;

/**
 *
 * @author gbiz0
 */
public class Notas {
    private Double n1, n2, n3;
    private Double p1, p2, p3;
    private Double result;
    
    public Double receber(Double n1, Double n2, Double n3, Double p1, Double p2, Double p3) {
        this.n1 = n1;
        this.n2 = n2;
        this.n3 = n3;        
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;        
        
        this.result = ((n1*p1)+(n2*p2)+(n3*p3))/3;
        return this.result;
    }
    
}
