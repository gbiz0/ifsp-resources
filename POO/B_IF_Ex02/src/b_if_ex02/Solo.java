/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package b_if_ex02;

/**
 *
 * @author gbiz0
 */
public class Solo {
    private double valor;
    private String resposta;
    
    public String calcular(double valor) {
        this.valor = valor;
        
        if (this.valor <= 10){
            this.resposta = "Rochoso!";
        } else if ((this.valor > 10) && (this.valor <= 40)) {
            this.resposta = "Firme!";
        } else if ((this.valor > 40) && (this.valor <= 80)) {
            this.resposta = "Pantanoso!";
        } else {
            this.resposta = "Quantidade de água inválida!";
        }
        return this.resposta;
    }
}
