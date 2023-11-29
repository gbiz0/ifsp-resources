/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package atv03;

import javax.swing.JOptionPane;

/**
 *
 * @author gbiz0
 */
public class Atv03 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        DTO dto = new DTO();
        CTR ctr = new CTR();
        
        ctr.mostrarMatriz(dto);
        ctr.calcular(dto);
        ctr.mostrar(dto);
        
        //JOptionPane.showMessageDialog(null, ctr.mostrarMatriz(dto));
    }
    
}
