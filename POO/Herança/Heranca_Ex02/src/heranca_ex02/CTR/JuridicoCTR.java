/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package heranca_ex02.CTR;

import heranca_ex02.DAO.ClienteDAO;
import heranca_ex02.DAO.JuridicoDAO;
import heranca_ex02.DTO.JuridicoDTO;

/**
 *
 * @author gbiz0
 */
public class JuridicoCTR extends ClienteDAO{
    JuridicoDAO juridicodao = new JuridicoDAO();
    
    public String imprimirJuridico(JuridicoDTO juridicodto){
        return juridicodao.imprimirJuridico(juridicodto);
    }
}
