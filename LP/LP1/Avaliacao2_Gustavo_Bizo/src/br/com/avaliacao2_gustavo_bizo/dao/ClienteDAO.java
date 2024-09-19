/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.avaliacao2_gustavo_bizo.dao;

import java.sql.*;
import br.com.avaliacao2_gustavo_bizo.dto.ClienteDTO;

/**
 *
 * @author gbiz0
 */
public class ClienteDAO {

    public ClienteDAO() {
    }

    private ResultSet rs = null;
    private Statement stmt = null;
    private PreparedStatement pstmt = null;

    public boolean inserirCliente(ClienteDTO clienteDTO) {
        try {
            ConexaoDAO.ConnectDB();
            stmt = ConexaoDAO.con.createStatement();
             String comando = "Insert into cliente (nome_cli, logradouro_cli, numero_cli, " 
                    + "bairro_cli, cidade_cli, estado_cli, cep_cli, cpf_cli, rg_cli) values( "
                    + "'" + clienteDTO.getNome_cli() + "', "
                    + "'" + clienteDTO.getLogradouro_cli() + "', "
                    + clienteDTO.getNumero_cli() + ", "
                    + "'" + clienteDTO.getBairro_cli() + "', "
                    + "'" + clienteDTO.getCidade_cli() + "', "
                    + "'" + clienteDTO.getEstado_cli() + "', "
                    + "'" + clienteDTO.getCep_cli() + "', "
                    + "'" + clienteDTO.getCpf_cli() + "', "
                    + "'" + clienteDTO.getRg_cli() + "') ";
            stmt.execute(comando);
            ConexaoDAO.con.commit();
            stmt.close();
            return true;
        } catch (Exception e) {
            System.out.println("Problema ao abrir base de dados! " + e.getMessage());
            return false;
        }
        finally{
            ConexaoDAO.CloseDB();
        }
    }
    
    public ResultSet consultarCliente(ClienteDTO clienteDTO, int opcao){
        try {
            ConexaoDAO.ConnectDB();
            stmt =  ConexaoDAO.con.createStatement();
            String comando = "";
            
            switch (opcao){
                case 1: 
                    comando = "Select c.* "+
                              "from cliente c "+
                              "where nome_cli ilike '"+clienteDTO.getNome_cli()+"%' order by c.nome_cli";
                break;
                case 2: 
                    comando = "Select c.* "+
                              "from cliente c "+
                              "where c.id_cli = "+clienteDTO.getId_cli();
                break;
                case 3: 
                    comando = "Select c.id_cli, c.nome_cli"+
                              "from cliente c ";
                break;
            }
            rs = stmt.executeQuery(comando.toUpperCase());
            return rs;
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return rs;
        }
    }
    
    public boolean alterarCliente (ClienteDTO clienteDTO){
        try {
            ConexaoDAO.ConnectDB();
            
            pstmt = ConexaoDAO.con.prepareStatement(
                     "UPDATE cliente SET "
                    + "nome_cli = ?, "
                    + "logradouro_cli = ?, "
                    + "numero_cli = ?, "
                    + "bairro_cli = ?, "
                    + "cidade_cli = ?, "
                    + "estado_cli = ?, "
                    + "cep_cli = ?, "
                    + "cpf_cli = ?, "
                    + "rg_cli = ?"
                    + "WHERE id_cli = ?;");
            pstmt.setString(1, clienteDTO.getNome_cli());
            pstmt.setString(2, clienteDTO.getLogradouro_cli());
            pstmt.setInt(3, clienteDTO.getNumero_cli());
            pstmt.setString(4, clienteDTO.getBairro_cli());
            pstmt.setString(5, clienteDTO.getCidade_cli());
            pstmt.setString(6, clienteDTO.getEstado_cli());
            pstmt.setString(7, clienteDTO.getCep_cli()); 
            pstmt.setString(8, clienteDTO.getCpf_cli());
            pstmt.setString(9, clienteDTO.getRg_cli());
            pstmt.setInt(10, clienteDTO.getId_cli());
            pstmt.execute();
            ConexaoDAO.con.commit();
            pstmt.close();
            return true;
        } catch (Exception e) {
            System.out.println("Problema ao abrir base de dados! " + e.getMessage());
            return false;
        }
        finally{
            ConexaoDAO.CloseDB();
        }
    }
    public boolean excluirCliente (ClienteDTO clienteDTO){
        try {
            ConexaoDAO.ConnectDB();
            
            pstmt = ConexaoDAO.con.prepareStatement("DELETE FROM cliente where id_cli = ?");
            pstmt.setInt(1, clienteDTO.getId_cli());            
            pstmt.execute();
            ConexaoDAO.con.commit();
            pstmt.close();
            return true;
        } catch (Exception e) {
            System.out.println("Problema ao abrir base de dados! " + e.getMessage());
            return false;
        }
        finally{
            ConexaoDAO.CloseDB();
        }
    }
    
    
}//close class
