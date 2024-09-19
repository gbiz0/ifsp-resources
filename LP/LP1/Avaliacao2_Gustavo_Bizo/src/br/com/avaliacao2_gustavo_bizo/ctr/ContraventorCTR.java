package br.com.avaliacao2_gustavo_bizo.ctr;

import java.sql.ResultSet;
import br.com.avaliacao2_gustavo_bizo.dto.ContraventorDTO;
import br.com.avaliacao2_gustavo_bizo.dao.ContraventorDAO;
import br.com.avaliacao2_gustavo_bizo.dao.ConexaoDAO;
/**
 *
 * @autor gbiz0
 */
public class ContraventorCTR {
    ContraventorDAO contraventorDAO = new ContraventorDAO();

    public ContraventorCTR() {
    }
    
    public String inserirContraventor (ContraventorDTO contraventorDTO){
        try {
            if (contraventorDAO.inserirContraventor(contraventorDTO)){
                return "Contraventor Cadastrado com Sucesso!";
            } else {
                return "Contraventor NÃO Cadastrado!";
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return "Contraventor não cadastrado";
        }
    }
    
    public ResultSet consultarContraventor (ContraventorDTO contraventorDTO, int opcao){
        ResultSet rs = null;
        rs = contraventorDAO.consultarContraventor(contraventorDTO, opcao);
        return rs;
    }
    
    public String alterarContraventor (ContraventorDTO contraventorDTO){
        try {
            if (contraventorDAO.alterarContraventor(contraventorDTO)){
                return "Contraventor alterado com Sucesso!";
            } else {
                return "Contraventor NÃO alterado!";
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return "Contraventor não alterado";
        }
    }
    
    public String excluirContraventor (ContraventorDTO contraventorDTO){
        try {
            if (contraventorDAO.excluirContraventor(contraventorDTO)){
                return "Contraventor Excluído com Sucesso!";
            } else {
                return "Contraventor NÃO Excluído!";
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return "Contraventor não excluído";
        }
    }
    
    public String logarContraventor (ContraventorDTO contraventorDTO){
        return contraventorDAO.logarContraventor(contraventorDTO);
    }
    
    public void CloseDB(){
        ConexaoDAO.CloseDB();
    }
}
