/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.avaliacao2_gustavo_bizo.ctr;

import java.sql.*;
import java.sql.ResultSet;
import br.com.avaliacao2_gustavo_bizo.dto.BichoDTO;
import br.com.avaliacao2_gustavo_bizo.dao.BichoDAO;
import br.com.avaliacao2_gustavo_bizo.dto.ContraventorDTO;

import br.com.avaliacao2_gustavo_bizo.dao.ConexaoDAO;

/**
 *
 * @author gbiz0
 */
public class BichoCTR {
    BichoDAO bichoDAO = new BichoDAO();

    public BichoCTR() {
    }
    
    public String inserirBicho (BichoDTO bichoDTO, ContraventorDTO contraventorDTO){
        try {
            if (bichoDAO.inserirBicho(bichoDTO, contraventorDTO)){
                return "Bicho Cadastrado com Sucesso!";
            } else {
                return "Bicho NÃO Cadastrado!";
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return "Bicho não cadastrado";
        }
    }
    
    public ResultSet consultarBicho (BichoDTO bichoDTO, int opcao){
        ResultSet rs = null;
        rs = bichoDAO.consultarBicho(bichoDTO, opcao);
        return rs;
    }
    
    public String alterarBicho (BichoDTO bichoDTO, ContraventorDTO contraventorDTO){
        try {
            if (bichoDAO.alterarBicho(bichoDTO, contraventorDTO)){
                return "Bicho alterado com Sucesso!";
            } else {
                return "Bicho NÃO alterado!";
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return "Bicho não alterado";
        }
    }
    
    public String excluirBicho (BichoDTO bichoDTO){
        try {
            if (bichoDAO.excluirBicho(bichoDTO)){
                return "Bicho Excluído com Sucesso!";
            } else {
                return "Bicho NÃO Excluído!";
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return "Bicho não excluído";
        }
    }
    public void CloseDB(){
        ConexaoDAO.CloseDB();
    }
}
