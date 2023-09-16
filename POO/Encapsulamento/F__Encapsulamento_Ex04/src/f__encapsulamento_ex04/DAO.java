/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package f__encapsulamento_ex04;

/**
 *
 * @author gbiz0
 */
public class DAO {
    public String imprimir(DTO dto){
        
        dto.getMedia() = (dto.getN1() + dto.getN2()) / 2;
                
        if (dto.getIdade() >= 18) {
            return "Você pode tirar a habilitação";
        } else {
            return "Você NÃO pode tirar a habilitação";
        }
    }
}
