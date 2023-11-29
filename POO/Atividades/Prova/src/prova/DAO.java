/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prova;

/**
 *
 * @author gbiz0
 */
public class DAO {
    public int calcular (DTO dto){
        int salario = dto.getSalario();
        int horas = dto.getHoras();;
        int extra = dto.getExtra();;
        
        dto.getsalarioBruto = hora(salario * 0.125);
        dto.getvalorExtra = extra(salario * 0.25);
        
        int Valor = dto.getvalorExtra + dto.getsalarioBruto;
        
        return this.valor();   
    }
}
