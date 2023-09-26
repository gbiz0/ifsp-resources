/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package f_encapsulamento_ex08;

/**
 *
 * @author gbiz0
 */
public class DAO {
    public String imprimir(DTO dto){
        
        if (dto.getA() <= dto.getB() && dto.getB() <= dto.getC()) {
            return "Números em ordem crescente: " + dto.getA() + " | " + dto.getB() + " | " + dto.getC();
        } else if (dto.getA() <= dto.getC() && dto.getC() <= dto.getB()) {
            return "Números em ordem crescente: " + dto.getA() + " | " + dto.getC() + " | " + dto.getB();
        } else if (dto.getB() <= dto.getA() && dto.getA() <= dto.getC()) {
            return "Números em ordem crescente: " + dto.getB() + " | " + dto.getA() + " | " + dto.getC();
        } else if (dto.getB() <= dto.getC() && dto.getC() <= dto.getA()) {
            return "Números em ordem crescente: " + dto.getB() + " | " + dto.getC() + " | " + dto.getA();
        } else if (dto.getC() <= dto.getA() && dto.getA() <= dto.getB()) {
            return "Números em ordem crescente: " + dto.getC() + " | " + dto.getA() + " | " + dto.getB();
        } else {
            return "Números em ordem crescente: " + dto.getC() + " | " + dto.getB() + " | " + dto.getA();
        }
    }
}
