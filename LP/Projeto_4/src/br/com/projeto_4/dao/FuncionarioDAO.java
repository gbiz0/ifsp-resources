package br.com.projeto_4.dao;
import java.sql.*;
import br.com.projeto_4.dto.FuncionarioDTO;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/**
 *
 * @author gbiz0
 */
public class FuncionarioDAO {

    public FuncionarioDAO() {
    }
    
    private ResultSet rs = null;
    private Statement stmt = null;
    
    public boolean inserirFuncionario(FuncionarioDTO funcionarioDTO){
        try{
            ConexaoDAO.ConnectDB();
            stmt = ConexaoDAO.con.createStatement();
            String comando = "INSERT INTO funcionario (nome_fun, cpf_fun, login_fun, senha_fun, tipo_fun)"
                    + "values ("
                    + "'" + funcionarioDTO.getNome_fun().toUpperCase() + "', "
                    + "'" + funcionarioDTO.getCpf_fun() + "', "
                    + "'" + funcionarioDTO.getLogin_fun() + "', "
                    + "'" + criptografar(funcionarioDTO.getSenha_fun())  + "', "
                    + "'" + funcionarioDTO.getTipo_fun().toUpperCase() + "') ";
            stmt.execute(comando);
            ConexaoDAO.con.commit();
            stmt.close();
            return true;
        } catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        } finally {
            ConexaoDAO.CloseDB();
        }
    }
    
    public boolean alterarFuncionario(FuncionarioDTO funcionarioDTO){
        try {
            ConexaoDAO.ConnectDB();
            stmt = ConexaoDAO.con.createStatement();
            String comando = "";
            
            comando = "Update funcionario set "
                    + "nome_fun = '" + funcionarioDTO.getNome_fun() + "', "
                    + "cpf_fun = '" + funcionarioDTO.getCpf_fun() + "', "
                    + "login_fun = " + funcionarioDTO.getLogin_fun()+ ", ";
            if (funcionarioDTO.getSenha_fun() != null) {
                comando += "senha_fun ='" + criptografar(funcionarioDTO.getSenha_fun()) + "', ";
            }
            
            comando += "tipo_fun = '" + funcionarioDTO.getTipo_fun().toUpperCase() + "'" 
            + "where id_fun = " + funcionarioDTO.getId_fun();
            
            stmt.execute(comando);
            ConexaoDAO.con.commit();
            stmt.close();
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        } finally {
            ConexaoDAO.CloseDB();
        }
    }
}
