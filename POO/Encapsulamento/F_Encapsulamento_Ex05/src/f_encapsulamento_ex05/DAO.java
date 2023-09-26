/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package f_encapsulamento_ex05;

/**
 *
 * @author gbiz0
 */
public class DAO {
    public String imprimir(DTO dto){
                        
        if (dto.getValor()<= 10) {
            return "Rochosa";
        } else if (dto.getValor() > 10 || dto.getValor() <= 40) {
            return "Firme";
        } else if (dto.getValor() > 40 || dto.getValor() <= 80) {
            return "Firme";
        } else {
           return "Quantidade de água inválida!";
        }
    }
}
