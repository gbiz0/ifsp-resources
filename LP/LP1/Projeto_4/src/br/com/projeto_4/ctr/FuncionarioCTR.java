package br.com.projeto_4.ctr;

import java.sql.ResultSet;
import br.com.projeto_4.dto.FuncionarioDTO;
import br.com.projeto_4.dao.FuncionarioDAO;
import br.com.projeto_4.dao.ConexaoDAO;
/**
 *
 * @author gbiz0
 */
public class FuncionarioCTR {
    FuncionarioDAO funcionarioDAO = new FuncionarioDAO();

    public FuncionarioCTR() {
    }
    
    public String inserirFuncionario (FuncionarioDTO funcionarioDTO){
        try {
            if (funcionarioDAO.inserirFuncionario(funcionarioDTO)){
                return "Funcionario Cadastrado com Sucesso!";
            } else {
                return "Funcionario NÃO Cadastrado!";
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return "Funcionario não cadastrado";
        }
    }
    
    public ResultSet consultarFuncionario (FuncionarioDTO funcionarioDTO, int opcao){
        ResultSet rs = null;
        rs = funcionarioDAO.consultarFuncionario(funcionarioDTO, opcao);
        return rs;
    }
    
    public String alterarFuncionario (FuncionarioDTO funcionarioDTO){
        try {
            if (funcionarioDAO.alterarFuncionario(funcionarioDTO)){
                return "Funcionario alterado com Sucesso!";
            } else {
                return "Funcionario NÃO alterado!";
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return "Funcionario não alterado";
        }
    }
    
    public String excluirFuncionario (FuncionarioDTO funcionarioDTO){
        try {
            if (funcionarioDAO.excluirFuncionario(funcionarioDTO)){
                return "Funcionario Excluído com Sucesso!";
            } else {
                return "Funcionario NÃO Excluído!";
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return "Funcionario não excluído";
        }
    }
    
    public String logarFuncionario (FuncionarioDTO funcionarioDTO){
        return funcionarioDAO.logarFuncionario(funcionarioDTO);
    }
    
    public void CloseDB(){
        ConexaoDAO.CloseDB();
    }
}
