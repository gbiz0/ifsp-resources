/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package b_if_ex04;

/**
 *
 * @author gbiz0
 */
public class Pessoa {
    private double peso, altura;
    private String resposta;
    
    public String calcular(double peso, double altura) {
        this.peso = peso;
        this.altura = altura;
        
        if ((this.peso <= 60) && (this.altura < 1.20)) {
          this.resposta = "A";
        } else if ((this.peso <= 60) && (this.altura >= 1.20)&& (this.altura < 1.70)) {
            this.resposta = "B";
        } else if ((this.peso <= 60) && (this.altura > 1.70)){
            this.resposta = "C";
        } else if ((this.peso > 60) && (this.peso <= 90) && (this.altura < 1.20)) {
            this.resposta = "D";
        } else if ((this.peso > 60) && (this.peso <= 90) && (this.altura >= 1.20) && (this.altura <= 1.70)) {
            this.resposta = "E";
        } else if ((this.peso > 60) && (this.peso <= 90) && (this.altura <= 1.70)) {
            this.resposta = "F";
        } else if ((this.peso > 90) && (this.altura < 1.20)) {
            this.resposta = "G";
        } else if ((this.peso > 90) && (this.altura >= 1.20) && (this.altura <= 1.70)) {
            this.resposta = "H";
        } else if ((this.peso > 90) && (this.altura > 1.70)) {
            this.resposta = "I";
        }
        return this.resposta;
    }
}
