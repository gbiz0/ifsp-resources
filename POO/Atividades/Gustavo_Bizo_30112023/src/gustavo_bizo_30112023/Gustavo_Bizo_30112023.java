/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package gustavo_bizo_30112023;

import gustavo_bizo_30112023.Exercicio01.CTR.CasaCTR;
import gustavo_bizo_30112023.Exercicio01.DTO.CasaDTO;
import javax.swing.JOptionPane;

/**
 *
 * @author gbiz0
 */
public class Gustavo_Bizo_30112023 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try{
        CasaDTO casadto = new CasaDTO();
        CasaCTR casactr = new CasaCTR();
        
        casadto.setBanheiros(Integer.parseInt(JOptionPane.showInputDialog("Escreva a quantidade de banheiros: ")));
        casadto.setQuartos(Integer.parseInt(JOptionPane.showInputDialog("Escreva a quantidade de quartos: ")));
        JOptionPane.showMessageDialog(null, casactr.publicarDados(casadto));
        }
        catch (Exception e){
            JOptionPane.showMessageDialog(null, "Erro no sistema"+ e.getMessage());
        }
    }   
    
}
