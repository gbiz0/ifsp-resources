/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package f_encapsulamento_ex07;

/**
 *
 * @author gbiz0
 */
public class DAO {
    public String imprimir(DTO dto){
        if (dto.getN4() > dto.getN3()) { 
            return "A ordem é: "+dto.getN4()+" | "+dto.getN3()+" | "+dto.getN2()+" | "+dto.getN1();
            } else if (dto.getN4() > dto.getN2() && dto.getN4() < dto.getN3()) {
            return "A ordem é: "+dto.getN3()+" | "+dto.getN4()+" | "+dto.getN2()+" | "+dto.getN1();
        } else if (dto.getN4() > dto.getN1() && dto.getN4() < dto.getN2()) {
            return "A ordem é: "+dto.getN3()+" | "+dto.getN2()+" | "+dto.getN4()+" | "+dto.getN1();
        } else {
            return "A ordem é: "+dto.getN3()+" | "+dto.getN2()+" | "+dto.getN1()+" | "+dto.getN4();
        }
    }
}
