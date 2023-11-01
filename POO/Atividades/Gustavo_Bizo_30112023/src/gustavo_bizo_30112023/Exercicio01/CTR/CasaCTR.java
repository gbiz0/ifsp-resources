/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gustavo_bizo_30112023.Exercicio01.CTR;

import gustavo_bizo_30112023.Exercicio01.DAO.CasaDAO;
import gustavo_bizo_30112023.Exercicio01.DTO.CasaDTO;

/**
 *
 * @author gbiz0
 */
public class CasaCTR {
    CasaDAO casadao = new CasaDAO();
    
    public String publicarDados(CasaDTO casadto){
        return casadao.publicarDados(casadto);
    }
}
