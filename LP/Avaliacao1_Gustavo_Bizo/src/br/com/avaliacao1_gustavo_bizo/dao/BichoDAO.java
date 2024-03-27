/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.avaliacao1_gustavo_bizo.dao;

import java.sql.*;
import br.com.avaliacao1_gustavo_bizo.dto.BichoDTO;

/**
 *
 * @author gbiz0
 */
public class BichoDAO {
    public BichoDAO() {
    }

    private ResultSet rs = null;
    private Statement stmt = null;
    private PreparedStatement pstmt = null;

    public boolean inserirBicho(BichoDTO bichoDTO) {
        try {
            ConexaoDAO.ConnectDB();
            
            pstmt = ConexaoDAO.con.prepareStatement("INSERT INTO bicho (nome_cli, numero_cli, bairro_cli, cidade_cli, estado_cli, cpf_cli, telefone_cli, nome_bicho, tipo_aposta, valor_aposta)"
                    + "values (?,?,?,?,?,?,?,?,?,?);");
            pstmt.setString(1, bichoDTO.getNome_cli());
            pstmt.setInt(2, bichoDTO.getNumero_cli());
            pstmt.setString(3, bichoDTO.getBairro_cli());
            pstmt.setString(4, bichoDTO.getCidade_cli());
            pstmt.setString(5, bichoDTO.getEstado_cli());
            pstmt.setString(6, bichoDTO.getCpf_cli());
            pstmt.setString(7, bichoDTO.getTelefone_cli());
            pstmt.setString(8, bichoDTO.getNome_bicho());
            pstmt.setString(9, bichoDTO.getTipo_aposta());
            pstmt.setFloat(10, bichoDTO.getValor_aposta());
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
    
    public ResultSet consultarBicho(BichoDTO bichoDTO, int opcao){
        try {
            ConexaoDAO.ConnectDB();
            stmt =  ConexaoDAO.con.createStatement();
            String comando = "";
            
            switch (opcao){
                case 1: 
                    comando = "Select b.* "+
                              "from bicho b "+
                              "where nome_cli ilike '"+bichoDTO.getNome_cli()+"%' order by b.nome_cli";
                break;
                case 2: 
                    comando = "Select b.* "+
                              "from bicho b "+
                              "where b.id_cli = "+bichoDTO.getId_cli();
                break;
                case 3: 
                    comando = "Select b.id_cli, b.nome_cli"+
                              "from bicho b ";
                break;
            }
            rs = stmt.executeQuery(comando.toUpperCase());
            return rs;
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return rs;
        }
    }
    
    public boolean alterarBicho (BichoDTO bichoDTO){
        try {
            ConexaoDAO.ConnectDB();
            
            pstmt = ConexaoDAO.con.prepareStatement(
                     "UPDATE bicho SET "
                    + "nome_cli = ?, "
                    + "numero_cli = ?, "
                    + "bairro_cli = ?, "
                    + "cidade_cli = ?, "
                    + "estado_cli = ?, "
                    + "cpf_cli = ?, "
                    + "telefone_cli = ?,"
                    + "nome_bicho = ?,"
                    + "tipo_aposta = ?,"
                    + "valor_aposta = ?"
                    + "WHERE id_cli = ?;");
            pstmt.setString(1, bichoDTO.getNome_cli());
            pstmt.setInt(2, bichoDTO.getNumero_cli());
            pstmt.setString(3, bichoDTO.getBairro_cli());
            pstmt.setString(4, bichoDTO.getCidade_cli());
            pstmt.setString(5, bichoDTO.getEstado_cli());
            pstmt.setString(6, bichoDTO.getCpf_cli());
            pstmt.setString(7, bichoDTO.getTelefone_cli());
            pstmt.setString(8, bichoDTO.getNome_bicho());
            pstmt.setString(9, bichoDTO.getTipo_aposta());
            pstmt.setFloat(10,bichoDTO.getValor_aposta());
            pstmt.setInt(11, bichoDTO.getId_cli());
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
    public boolean excluirBicho (BichoDTO bichoDTO){
        try {
            ConexaoDAO.ConnectDB();
            
            pstmt = ConexaoDAO.con.prepareStatement("DELETE FROM bicho where id_cli = ?");
            pstmt.setInt(1, bichoDTO.getId_cli());            
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
}
