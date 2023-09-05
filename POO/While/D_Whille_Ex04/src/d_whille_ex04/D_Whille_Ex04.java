/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package d_whille_ex04;

import javax.swing.JOptionPane;

/**
 *
 * @author gbiz0
 */
public class D_Whille_Ex04 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int number = 1;
        Canais canais = new Canais();
        
            while (number != 0){
                number = Integer.parseInt(JOptionPane.showInputDialog("Informe o número do canal: "));
                canais.verificar(number);
            }
        
            JOptionPane.showMessageDialog(null,canais.mostra());
    }
    
}
