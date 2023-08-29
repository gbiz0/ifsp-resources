/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package c_for_ex02;

/**
 *
 * @author gbiz0
 */
public class Intervalo {
    private int n1,n2;
    private String imprimir = "";
    public String calcular_Tabuada(int n1, int n2){
        this.n1 = n1;
        this.n2 = n2;
        
        for (int i = n1; i <= n2; i++) {
            this.imprimir = this.imprimir  + i + "\n";
        }
        return this.imprimir;
    }
}
