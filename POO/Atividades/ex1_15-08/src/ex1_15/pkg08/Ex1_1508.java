/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ex1_15.pkg08;
import javax.swing.JOptionPane;

/**
 *
 * @author gbiz0
 */
public class Ex1_1508 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Cliente cliente = new Cliente();
        
        System.out.println("------------- Chamando métodos do objeto -------------\n");
        
        cliente.mostrar(JOptionPane.showInputDialog("Informe o nome: "),
                        JOptionPane.showInputDialog("Informe o rg: "));
  
        cliente.mostrarNome(JOptionPane.showInputDialog("Informe o outro nome: "));
        
        System.out.println("------------- Fim da chamada -------------\n");
    }
    
}
