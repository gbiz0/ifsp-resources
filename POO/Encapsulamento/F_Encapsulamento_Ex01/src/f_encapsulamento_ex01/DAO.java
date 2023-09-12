/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package f_encapsulamento_ex01;

/**
 *
 * @author gbiz0
 */
public class DAO {
    
    public String mostrarRg(DTO encapsular){
        return "O nome informado foi: " + encapsular.getNome() 
                + "\n O RG informado foi: " + encapsular.getRg();
    }
    
    public String mostrarNomeIdade(DTO encapsular){
        return "O nome informado foi: " + encapsular.getNome()
                +"\n A idade informada foi: " +encapsular.getIdade();
    }
}
