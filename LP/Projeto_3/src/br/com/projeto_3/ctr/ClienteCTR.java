package br.com.projeto_3.ctr;

import java.sql.ResultSet;
import br.com.projeto_3.dto.ClienteDTO;
import br.com.projeto_3.dao.ClienteDAO;
import br.com.projeto_3.dao.ConexaoDAO;
/**
 *
 * @author gbiz0
 */
public class ClienteCTR {
    ClienteDAO clienteDAO = new ClienteDAO();

    public ClienteCTR() {
    }
    
    public String inserirCliente (ClienteDTO clienteDTO){
        try {
            if (clienteDAO.inserirCliente(clienteDTO)){
                return "Cliente Cadastrado com Sucesso!";
            } else {
                return "Cliente NÃO Cadastrado!";
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return "Cliente não cadastrado";
        }
    }
    
    public ResultSet consultarCliente (ClienteDTO clienteDTO, int opcao){
        ResultSet rs = null;
        rs = clienteDAO.consultarCliente(clienteDTO, opcao);
        return rs;
    }
    
    public String alterarCliente (ClienteDTO clienteDTO){
        try {
            if (clienteDAO.alterarCliente(clienteDTO)){
                return "Cliente alterado com Sucesso!";
            } else {
                return "Cliente NÃO alterado!";
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return "Cliente não alterado";
        }
    }
    
    public String excluirCliente (ClienteDTO clienteDTO){
        try {
            if (clienteDAO.excluirCliente(clienteDTO)){
                return "Cliente Excluído com Sucesso!";
            } else {
                return "Cliente NÃO Excluído!";
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return "Cliente não excluído";
        }
    }
    public void CloseDB(){
        ConexaoDAO.CloseDB();
    }
}
