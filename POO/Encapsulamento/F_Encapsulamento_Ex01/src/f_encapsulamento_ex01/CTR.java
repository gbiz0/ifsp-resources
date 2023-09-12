/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package f_encapsulamento_ex01;

/**
 *
 * @author gbiz0
 */
public class CTR {
    
    DAO dao = new DAO();
    
    public String mostrarRg(DTO dto){
        return dao.mostrarRg(dto);
    }
    
    public String mostrarNomeIdade(DTO dto){
        return dao.mostrarNomeIdade(dto);
    }
}
