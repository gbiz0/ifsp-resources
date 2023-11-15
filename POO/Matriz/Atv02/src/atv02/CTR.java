/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package atv02;

/**
 *
 * @author gbiz0
 */
public class CTR {
    DAO dao = new DAO();
    
    public String mostrarMatriz(DTO dto){
        return dao.mostrarMatriz(dto);
    }
}
