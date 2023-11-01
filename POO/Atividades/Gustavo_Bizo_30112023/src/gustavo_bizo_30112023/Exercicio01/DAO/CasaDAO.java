/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gustavo_bizo_30112023.Exercicio01.DAO;

import gustavo_bizo_30112023.Exercicio01.DTO.CasaDTO;

/**
 *
 * @author gbiz0
 */
public class CasaDAO {
    public String publicarDados(CasaDTO casadto){
        return "A quantidade de banheiros é: " +casadto.getBanheiros()+
               "A quantidade de quartos é: " +casadto.getQuartos();
    } 
}
