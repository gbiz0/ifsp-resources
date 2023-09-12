/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package f_encapsulamento_ex02;

import javax.swing.JOptionPane;

/**
 *
 * @author gbiz0
 */
public class F_Encapsulamento_Ex02 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            DTO dto = new DTO();
            CTR ctr = new CTR();
            
            dto.setTelefone(JOptionPane.showInputDialog("Informe seu telefone: "));
            dto.setCodigo(Integer.parseInt(JOptionPane.showInputDialog("Informe seu código: ")));
            
            JOptionPane.showMessageDialog(null, ctr.imprimir(dto));
        }
        catch (Exception e){
            JOptionPane.showMessageDialog(null, "Erro no sistema"+ e.getMessage());
        }
    }
    
}
