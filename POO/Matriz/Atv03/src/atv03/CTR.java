/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package atv03;

/**
 *
 * @author gbiz0
 */
public class CTR {
    DAO dao = new DAO();
    
    public void mostrarMatriz(DTO dto){
        this.dao.mostrarMatriz(dto);
    }
    public void calcular(DTO dto){
        this.dao.calcular(dto);
    }
    public void mostrar(DTO dto){
        this.dao.mostrar(dto);
    }
    
}
