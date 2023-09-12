/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package f_encapsulamento_ex02;

/**
 *
 * @author gbiz0
 */
public class DAO {
    public String imprimir(DTO dto){
        return "O código informado foi: " +
                dto.getCodigo() +
        "\n O telefone informado foi: " +
                dto.getTelefone();
    }
}
