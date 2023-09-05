/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package d_while_ex03;

/**
 *
 * @author gbiz0
 */
public class Vogal {
    private String letra, resp;
    private int a, e, i, o, u, qnt;
    
    public void verificar (String letra){
        this.letra = letra;
        
        if (this.letra.equalsIgnoreCase("A")) {
            this.a++;
        }else if(this.letra.equalsIgnoreCase("E")) {
            this.e++;
        }else if(this.letra.equalsIgnoreCase("I")) {
            this.i++;
        }else if(this.letra.equalsIgnoreCase("O")) {
            this.o++;
        }else if(this.letra.equalsIgnoreCase("U")) {
            this.u++;
        }else {
            this.qnt++;
        }  
    }
    public String mostra(){
        this.resp = "\nA: "+this.a +
                    "\nE: "+this.e + 
                    "\nI: "+this.i +
                    "\nO: "+this.o +
                    "\nU: "+this.u +
                    "\nConsoantes: "+this.qnt;  
        
        return this.resp;
    }
}
