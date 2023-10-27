/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package heranca_ex02.CTR;

import heranca_ex02.DAO.ClienteDAO;
import heranca_ex02.DAO.FisicoDAO;
import heranca_ex02.DTO.FisicoDTO;

/**
 *
 * @author gbiz0
 */
public class FisicoCTR extends ClienteDAO{
    FisicoDAO fisicodao = new FisicoDAO();
    
    public String imprimirFisico(FisicoDTO fisicodto){
        return fisicodao.imprimirFisico(fisicodto);
    }
}
