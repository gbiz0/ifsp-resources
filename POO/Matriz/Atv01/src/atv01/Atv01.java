/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package atv01;

import javax.swing.JOptionPane;

/**
 *
 * @author gbiz0
 */
public class Atv01 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        DTO dto = new DTO();
        CTR ctr = new CTR();
        int num [][] = new int [5][5];

        for (int i = 0; i<2; i++){
            for (int j = 0; j<3; j++){
                num[i][j] = Integer.parseInt(
                        JOptionPane.showInputDialog(
                                "Informe o número da linha: "+ i +" coluna: "+ j
                        )
                );
            }
        }
        dto.setN(num);
        JOptionPane.showMessageDialog(null, ctr.mostrarMatriz(dto));
    }
    
}
