/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package d_while_ex02;

/**
 *
 * @author gbiz0
 */
public class Letra {
    private String letra;
    private int qtd;
    
    public void verificar (String letra){
        this.letra = letra;
        
        if (this.letra.equalsIgnoreCase("X")) {
            this.qtd++;
        }
    }
    public int mostra(){
        return this.qtd;
    }
}
