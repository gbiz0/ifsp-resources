package br.com.avaliacao2_gustavo_bizo.dao;

import java.sql.*;
import br.com.avaliacao2_gustavo_bizo.dto.ContraventorDTO;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author gbiz0
 */
public class ContraventorDAO {

    public ContraventorDAO() {
    }
    
    private ResultSet rs = null;
    private Statement stmt = null;
    private static MessageDigest md = null;
    
    static {
        try {
            md = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException ex) {
            ex.printStackTrace();
        }
    }
    
    private static char[] hexCodes (byte[] text){
        char [] hexOutput = new char[text.length * 3];
        String hexString;
        
        for (int i = 0; i < text.length; i++) {
            hexString = "00" + Integer.toHexString(text[i]);
            hexString.toUpperCase().getChars(hexString.length() - 3, hexString.length(), hexOutput, i * 3);
        }
        return hexOutput;
    }
    
    public static String criptografar (String pwd){
        if(md != null){
            return new String(hexCodes(md.digest(pwd.getBytes())));
        }
        return null;
    }
    
    public boolean inserirContraventor(ContraventorDTO contraventorDTO){
        try{
            ConexaoDAO.ConnectDB();
            stmt = ConexaoDAO.con.createStatement();
            String comando = "INSERT INTO contraventor (nome_cont, cpf_cont, login_cont, senha_cont, tipo_cont)"
                    + "VALUES ("
                    + "'" + contraventorDTO.getNome_cont().toUpperCase() + "', "
                    + "'" + contraventorDTO.getCpf_cont() + "', "
                    + "'" + contraventorDTO.getLogin_cont() + "', "
                    + "'" + criptografar(contraventorDTO.getSenha_cont())  + "', "
                    + "'" + contraventorDTO.getTipo_cont().toUpperCase() + "') ";
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
    
    public boolean alterarContraventor(ContraventorDTO contraventorDTO){
        try {
            ConexaoDAO.ConnectDB();
            stmt = ConexaoDAO.con.createStatement();
            String comando = "";
            
            comando = "UPDATE contraventor SET "
                    + "nome_cont = '" + contraventorDTO.getNome_cont() + "', "
                    + "cpf_cont = '" + contraventorDTO.getCpf_cont() + "', "
                    + "login_cont = '" + contraventorDTO.getLogin_cont() + "', ";
            if (contraventorDTO.getSenha_cont() != null) {
                comando += "senha_cont ='" + criptografar(contraventorDTO.getSenha_cont()) + "', ";
            }
            
            comando += "tipo_cont = '" + contraventorDTO.getTipo_cont().toUpperCase() + "'" 
            + " WHERE id_cont = " + contraventorDTO.getId_cont();
            
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
    
    public boolean excluirContraventor(ContraventorDTO contraventorDTO){
        try {
            ConexaoDAO.ConnectDB();
            stmt = ConexaoDAO.con.createStatement();
            String comando = "DELETE FROM contraventor WHERE id_cont = "+ contraventorDTO.getId_cont();
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
    
    public ResultSet consultarContraventor(ContraventorDTO contraventorDTO, int opcao){
        try {
            ConexaoDAO.ConnectDB();
            stmt = ConexaoDAO.con.createStatement();
            String comando = "";
            switch (opcao) {
                case 1:
                    comando = "SELECT * FROM contraventor " +
                              "WHERE nome_cont ILIKE '" + contraventorDTO.getNome_cont() + "%' " +
                              "ORDER BY nome_cont";
                    break;
                case 2: 
                    comando = "SELECT * FROM contraventor " +
                              "WHERE id_cont = " + contraventorDTO.getId_cont();
                    break;
            }
            rs = stmt.executeQuery(comando.toUpperCase());
            return rs;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return rs;
        }
    }
    
    public String logarContraventor(ContraventorDTO contraventorDTO){
        try {
            ConexaoDAO.ConnectDB();
            stmt = ConexaoDAO.con.createStatement();
            String comando = "SELECT tipo_cont FROM contraventor " +
                             "WHERE login_cont = '" + contraventorDTO.getLogin_cont() + "' " +
                             "AND senha_cont = '" + criptografar(contraventorDTO.getSenha_cont()) + "'";
            rs = null;
            rs = stmt.executeQuery(comando);
            if (rs.next()) {
                return rs.getString("tipo_cont");
            } else {
                return "";
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return "";
        } finally {
            ConexaoDAO.CloseDB();
        }
    }
}
