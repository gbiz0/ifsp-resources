/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package f_encapsulamento_ex01;

import javax.swing.JOptionPane;

/**
 *
 * @author gbiz0
 */
public class F_Encapsulamento_Ex01 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            DTO dto = new DTO();
            CTR ctr = new CTR();
            
            dto.setNome(JOptionPane.showInputDialog("Informe seu Nome: "));
            dto.setRg(JOptionPane.showInputDialog("Informe seu RG: "));
            dto.setIdade(Integer.parseInt(JOptionPane.showInputDialog("Informe sua Idade: ")));
            
            JOptionPane.showMessageDialog(null, ctr.mostrarRg(dto));
            JOptionPane.showMessageDialog(null, ctr.mostrarNomeIdade(dto));
        }
        catch (Exception e){
            JOptionPane.showMessageDialog(null, "Erro no sistema"+ e.getMessage());
        }
    }
    
}
