/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package f_encapsulamento_ex06;

/**
 *
 * @author gbiz0
 */
public class DAO {
    public String imprimir(DTO dto){
        
    if (dto.getLadoA() == dto.getLadoB() && dto.getLadoB() == dto.getLadoC()) {
            return "Equilátero"; // Todos os lados são iguais
        } else if (dto.getLadoA() == dto.getLadoB() || dto.getLadoA() == dto.getLadoC() || dto.getLadoB() == dto.getLadoC()) {
            return "Isósceles"; // Dois lados são iguais
        } else {
            return "Escaleno"; // Todos os lados são diferentes
        }
    }
}
