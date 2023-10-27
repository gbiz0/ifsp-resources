/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package heranca_ex02.DAO;

import heranca_ex02.DTO.FisicoDTO;

/**
 *
 * @author gbiz0
 */
public class FisicoDAO{
    public String imprimirFisico(FisicoDTO fisicodto){
        return "O CPF é: " +fisicodto.getCpf() +
                "O RG é: " +fisicodto.getRg();
    }
}
