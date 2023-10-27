/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package heranca_ex02.DAO;

import heranca_ex02.DTO.JuridicoDTO;

/**
 *
 * @author gbiz0
 */
public class JuridicoDAO{
    public String imprimirJuridico(JuridicoDTO juridicodto){
        return "O CNPJ é: " +juridicodto.getCnpj() +
                "O RG é: " +juridicodto.getIe();
    }
}
