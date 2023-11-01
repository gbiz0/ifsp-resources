/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ex1_15.pkg08;

import javax.swing.JOptionPane;

/**
 *
 * @author gbiz0
 */
public class Cliente {
    private String nome, rg;
    
    public void mostrar(String nome, String rg) {
        this.nome = nome;
        this.rg   = rg;
        
        JOptionPane.showMessageDialog(null, "O nome informado foi: " + this.nome +
                           "\nO rg informado foi: " + this.rg);
    }
    
    public void mostrarNome(String nome) {
        this.nome = nome;
        JOptionPane.showMessageDialog(null, "O nome informado foi: " + this.nome);
    }
}
