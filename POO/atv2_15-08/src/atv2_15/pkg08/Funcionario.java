/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package atv2_15.pkg08;

/**
 *
 * @author gbiz0
 */
public class Funcionario {
    private Double salario, porcent;
    private Double result;
    
    public Double salario(Double salario, Double porcent) {
        this.salario = salario;
        this.porcent = porcent;       
        
        this.result = salario + (salario * (porcent/100));
        return this.result;
    }
}
