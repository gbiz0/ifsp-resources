/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package f_encapsulamento_ex06;

import javax.swing.JOptionPane;

/**
 *
 * @author gbiz0
 */
public class F_Encapsulamento_Ex06 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            DTO dto = new DTO();
            CTR ctr = new CTR();
            
            dto.setLadoA(Integer.parseInt(JOptionPane.showInputDialog("Escreva o lado A: ")));
            dto.setLadoB(Integer.parseInt(JOptionPane.showInputDialog("Escreva o lado B: ")));
            dto.setLadoC(Integer.parseInt(JOptionPane.showInputDialog("Escreva o lado C: ")));
            
            JOptionPane.showMessageDialog(null, ctr.imprimir(dto));
        }
        catch (Exception e){
            JOptionPane.showMessageDialog(null, "Erro no sistema"+ e.getMessage());
        }
    }
    
}
