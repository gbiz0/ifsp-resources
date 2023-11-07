/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package atv1;

import javax.swing.JOptionPane;

/**
 *
 * @author gbiz0
 */
public class Atv1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        DTO dto = new DTO();
        CTR ctr = new CTR();
        int  num[] = new int[20];
         
        for(int cont=0; cont<20; cont++){
            num[cont] = Integer.parseInt(JOptionPane.showInputDialog("Informe o número para a posição: "+cont));
        }
        dto.setN(num);
        JOptionPane.showMessageDialog(null, ctr.ordenar(dto));
    }
    
}
