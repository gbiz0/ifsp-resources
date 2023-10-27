/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package heranca_ex02;

import heranca_ex02.CTR.FisicoCTR;
import heranca_ex02.CTR.JuridicoCTR;
import heranca_ex02.DTO.FisicoDTO;
import heranca_ex02.DTO.JuridicoDTO;
import javax.swing.JOptionPane;

/**
 *
 * @author gbiz0
 */
public class Heranca_Ex02 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try{
        JuridicoDTO juridicodto = new JuridicoDTO();
        JuridicoCTR juridicoctr = new JuridicoCTR();
        
        juridicodto.setNome(JOptionPane.showInputDialog("Escreva o nome: "));
        juridicodto.setEndereco(JOptionPane.showInputDialog("Escreva o endereço: "));
        juridicodto.setNumero(Integer.parseInt(JOptionPane.showInputDialog("Escreva o número: ")));
        juridicodto.setCidade(JOptionPane.showInputDialog("Escreva a cidade: "));
        juridicodto.setEstado(JOptionPane.showInputDialog("Escreva a estado: "));
        juridicodto.setCnpj(JOptionPane.showInputDialog("Escreva o CNPJ: "));
        juridicodto.setIe(JOptionPane.showInputDialog("Escreva o IE: "));
        
        JOptionPane.showMessageDialog(null, juridicoctr.imprimirJuridico(juridicodto));
        
        
        FisicoDTO fisicodto = new FisicoDTO();
        FisicoCTR fisicoctr = new FisicoCTR();
        
        fisicodto.setNome(JOptionPane.showInputDialog("Escreva o nome: "));
        fisicodto.setEndereco(JOptionPane.showInputDialog("Escreva o endereço: "));
        fisicodto.setNumero(Integer.parseInt(JOptionPane.showInputDialog("Escreva o número: ")));
        fisicodto.setCidade(JOptionPane.showInputDialog("Escreva a cidade: "));
        fisicodto.setCidade(JOptionPane.showInputDialog("Escreva a cidade: "));
        fisicodto.setCpf(JOptionPane.showInputDialog("Escreva o CPF: "));
        fisicodto.setRg(JOptionPane.showInputDialog("Escreva o RG: "));
        
        JOptionPane.showMessageDialog(null, fisicoctr.imprimirFisico(fisicodto));
        }
        catch (Exception e){
            JOptionPane.showMessageDialog(null, "Erro no sistema"+ e.getMessage());
        }
    }
    
}
