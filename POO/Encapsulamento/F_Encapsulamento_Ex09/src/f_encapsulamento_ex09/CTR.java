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
public class CTR {
    DAO dao = new DAO();
    
    public String imprimir(DTO dto){
        return dao.imprimir(dto);
    }
}
