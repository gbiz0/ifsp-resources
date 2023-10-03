/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package f_encapsulamento_ex09;

import javax.swing.JOptionPane;

/**
 *
 * @author Aluno
 */
public class F_Encapsulamento_Ex09 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            DTO dto = new DTO();
            CTR ctr = new CTR();
            
            dto.setAltura(Integer.parseInt(JOptionPane.showInputDialog("Escreva sua altura em cm: ")));
            dto.setPeso(Integer.parseInt(JOptionPane.showInputDialog("Escreva seu peso: ")));
            
            JOptionPane.showMessageDialog(null, ctr.imprimir(dto));
        }
        catch (Exception e){
            JOptionPane.showMessageDialog(null, "Erro no sistema"+ e.getMessage());
        }
    }
    
}
