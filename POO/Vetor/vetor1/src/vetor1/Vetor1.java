/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package vetor1;

import javax.swing.JOptionPane;

/**
 *
 * @author gbiz0
 */
public class Vetor1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        DTO dto = new DTO();
        CTR ctr = new CTR();
        int  num[] = new int[5];
         
        for(int cont=0; cont<5; cont++){
            num[cont] = Integer.parseInt(JOptionPane.showInputDialog("Informe o número para a posição: "+cont));
        }
        dto.setN(num);
        JOptionPane.showMessageDialog(null, ctr.verificarPosicao(dto));
    }
    
}
