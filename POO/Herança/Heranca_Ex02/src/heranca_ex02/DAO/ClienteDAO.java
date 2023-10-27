/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package heranca_ex02.DAO;

import heranca_ex02.DTO.ClienteDTO;

/**
 *
 * @author gbiz0
 */
public class ClienteDAO {
    public String imprimirCliente(ClienteDTO clientedto){
        return "O nome é: " +clientedto.getNome() +
               "O endereço é: " +clientedto.getEndereco() +
               "O número é: "+clientedto.getNumero() +
               "A cidade é: "+clientedto.getCidade() +
               "O estado é: "+clientedto.getEstado();
    } 
}
