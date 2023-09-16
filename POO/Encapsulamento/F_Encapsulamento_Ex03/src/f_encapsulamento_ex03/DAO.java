/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package f_encapsulamento_ex03;

/**
 *
 * @author gbiz0
 */
public class DAO {
    public String imprimir(DTO dto){
        if (dto.getIdade() >= 18) {
            return "Você pode tirar a habilitação";
        } else {
            return "Você NÃO pode tirar a habilitação";
        }
    }
}
