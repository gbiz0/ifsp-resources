/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.avaliacao2_gustavo_bizo.dao;

import java.sql.*;
import br.com.avaliacao2_gustavo_bizo.dto.BichoDTO;
import br.com.avaliacao2_gustavo_bizo.dto.ContraventorDTO;

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

    public boolean inserirBicho(BichoDTO bichoDTO, ContraventorDTO contraventorDTO) {
        try {
            ConexaoDAO.ConnectDB();
            
            stmt = ConexaoDAO.con.createStatement();
        
            String comando = "INSERT INTO bicho (nome_bicho, tipo_aposta, val_aposta, banca_aposta, id_cont)"
                    + "values ("
                    +"'" + bichoDTO.getNome_bicho() + "', "
                    +"'" + bichoDTO.getTipo_aposta() + "', "
                    + bichoDTO.getVal_aposta()+ ", "
                    +"'" + bichoDTO.getBanca_aposta() + "', "
                    + contraventorDTO.getId_cont() +");";
            stmt.execute(comando.toUpperCase());
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
    
    // Função para alterar os dados de um bicho
    public boolean alterarBicho(BichoDTO bichoDTO, ContraventorDTO contraventorDTO) {
        try {
            ConexaoDAO.ConnectDB();

            stmt = ConexaoDAO.con.createStatement();

            String comando = "UPDATE bicho SET "
                    + "nome_bicho = '" + bichoDTO.getNome_bicho() + "', "
                    + "tipo_aposta = '" + bichoDTO.getTipo_aposta() + "', "
                    + "val_aposta = " + bichoDTO.getVal_aposta() + ", "
                    + "banca_aposta = '" + bichoDTO.getBanca_aposta() + "', "
                    + "id_cont = " + contraventorDTO.getId_cont() + " "
                    + "WHERE id_bicho = " + bichoDTO.getId_bicho();

            stmt.execute(comando.toUpperCase());
            ConexaoDAO.con.commit();
            stmt.close();

            return true;
        } catch (Exception e) {
            System.out.println("Problema ao abrir base de dados! " + e.getMessage());
            return false;
        } finally {
            ConexaoDAO.CloseDB();
        }
    }

    // Função para excluir um bicho
    public boolean excluirBicho(BichoDTO bichoDTO) {
        try {
            ConexaoDAO.ConnectDB();

            stmt = ConexaoDAO.con.createStatement();

            String comando = "DELETE FROM bicho WHERE id_bicho = " + bichoDTO.getId_bicho();

            stmt.execute(comando.toUpperCase());
            ConexaoDAO.con.commit();
            stmt.close();

            return true;
        } catch (Exception e) {
            System.out.println("Problema ao abrir base de dados! " + e.getMessage());
            return false;
        } finally {
            ConexaoDAO.CloseDB();
        }
    }

    // Função para consultar os dados de um bicho
    public ResultSet consultarBicho(BichoDTO bichoDTO, int opcao) {
        try {
            ConexaoDAO.ConnectDB();

            stmt = ConexaoDAO.con.createStatement();

            String comando = "";

            switch (opcao) {
                case 1:
                    comando = "SELECT b.* "
                            + "FROM bicho b "
                            + "WHERE b.nome_bicho ILIKE '" + bichoDTO.getNome_bicho() + "%' "
                            + "ORDER BY b.nome_bicho";
                    break;
                case 2:
                    comando = "SELECT b.*, c.tipo_cont, c.id_cont "
                            + "FROM bicho b, contraventor c "
                            + "WHERE b.id_cont = c.id_cont AND "
                            + "b.id_bicho = " + bichoDTO.getId_bicho();
                    break;
            }

            rs = stmt.executeQuery(comando.toUpperCase());
            return rs;

        } catch (Exception e) {
            System.out.println("Problema ao abrir base de dados! " + e.getMessage());
            return rs;
        }
    }
}
