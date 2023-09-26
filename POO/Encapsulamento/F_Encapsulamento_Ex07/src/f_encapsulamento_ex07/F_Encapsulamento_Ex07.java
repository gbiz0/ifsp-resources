/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package f_encapsulamento_ex07;

import javax.swing.JOptionPane;

/**
 *
 * @author gbiz0
 */
public class F_Encapsulamento_Ex07 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            DTO dto = new DTO();
            CTR ctr = new CTR();
            
            dto.setN1(Integer.parseInt(JOptionPane.showInputDialog("Escreva primeiro número: ")));
            dto.setN2(Integer.parseInt(JOptionPane.showInputDialog("Escreva segundo número: ")));
            dto.setN3(Integer.parseInt(JOptionPane.showInputDialog("Escreva terceiro número: ")));
            dto.setN4(Integer.parseInt(JOptionPane.showInputDialog("Escreva quarto número: ")));
            
            JOptionPane.showMessageDialog(null, ctr.imprimir(dto));
        }
        catch (Exception e){
            JOptionPane.showMessageDialog(null, "Erro no sistema"+ e.getMessage());
        }
    }
    
}
