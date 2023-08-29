/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package b_if_ex03;

/**
 *
 * @author gbiz0
 */
public class Numero {
    private int n1, n2, n3, n4;
    private String resposta;
    
    public String calcular(int n1, int n2, int n3, int n4) {
        this.n1 = n1;
        this.n2 = n2;
        this.n3 = n3;
        this.n4 = n4;
        
        if (this.n4 > this.n3){
          this.resposta = "|" + n4 + "|" + n3 + "|" + n2 + "|" + n1 + "|";
        } else if ((this.n4 > this.n2) && (this.n4 < this.n3)) {
            this.resposta = "|" + n3 + "|" + n4 + "|" + n2 + "|" + n1 + "|";
        } else if ((this.n4 > this.n1) && (this.n4 < this.n2)) {
            this.resposta = "|" + n3 + "|" + n2 + "|" + n4 + "|" + n1 + "|";
        } else {
            this.resposta = "|" + n3 + "|" + n2 + "|" + n1 + "|" + n4 + "|";
        }
        return this.resposta;
    }
}
