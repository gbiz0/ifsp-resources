/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package f_encapsulamento_ex09;

/**
 *
 * @author Aluno
 */
public class DAO {
     public String imprimir(DTO dto){
        String resultado = "A classificação do indivíduo é: ";
       
         if (dto.getAltura() < 120){        
             if (dto.getPeso() < 60){
                 resultado += "A";
             } else if (dto.getPeso() >= 60 && dto.getPeso() <= 90){
                 resultado += "D";
             } else {
                 resultado += "G";
             }
         } else if (dto.getAltura() >= 120 && dto.getAltura() <= 170){
             if (dto.getPeso() < 60){
                 resultado += "B";
             } else if (dto.getPeso() >= 60 && dto.getPeso() <= 90){
                 resultado += "E";
             } else {
                 resultado += "F";
             }
         } else {
            if (dto.getPeso() < 60){
                 resultado += "C";
             } else if (dto.getPeso() >= 60 && dto.getPeso() <= 90){
                 resultado += "F";
             } else {
                 resultado += "I";
             }
         }
         return resultado;
    }
}
