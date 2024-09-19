/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Cliente;

import javax.swing.JOptionPane;

/**
 *
 * @author gbiz0
 */
public class ClienteVIEW {
    public static void main (String args []){
        try{
            ClienteDTO clienteDTO = new ClienteDTO();
            ClienteCTR clienteCTR = new ClienteCTR();
            
            clienteDTO.setNome(JOptionPane.showInputDialog("Informe o nome: "));
            clienteDTO.setRg(JOptionPane.showInputDialog("Informe o RG: "));
            clienteDTO.setIdade (Integer.parseInt(JOptionPane.showInputDialog("Informe a sua idade: ")));
            
            JOptionPane.showMessageDialog(null, clienteCTR.mostrarNomeRg(clienteDTO));
            JOptionPane.showMessageDialog(null, clienteCTR.mostrarNomeIdade(clienteDTO));
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, "Erro no sistema"+e.getMessage());
        }
    }
    
}
