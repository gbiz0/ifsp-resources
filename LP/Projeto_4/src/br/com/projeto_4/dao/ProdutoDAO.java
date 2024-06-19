/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.projeto_4.dao;

import br.com.projeto_4.dto.ProdutoDTO;
import br.com.projeto_4.dto.FornecedorDTO;
import java.sql.*;

/**
 *
 * @author gbiz0
 */
public class ProdutoDAO {

    public ProdutoDAO() {
    }
    
    private ResultSet rs = null;
    private Statement stmt = null;
    private PreparedStatement pstmt = null;

    public boolean inserirProduto(ProdutoDTO produtoDTO, FornecedorDTO fornecedorDTO) {
        try {
            ConexaoDAO.ConnectDB();

            stmt = ConexaoDAO.con.createStatement();
            String comando = "INSERT INTO produto (nome_prod, desc_prod, cod_bar_prod, p_custo_prod, p_venda_prod, id_for)"
                    + "values ("
                    + "'" + produtoDTO.getNome_prod() + "', "
                    + "'" + produtoDTO.getDesc_prod()+ "', "
                    + "'" + produtoDTO.getCod_bar_prod()+ "', "
                    + produtoDTO.getP_custo_prod() + ", "
                    + produtoDTO.getP_venda_prod() + ", "
                    + fornecedorDTO.getId_for() + ")";
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

    public boolean alterarProduto(ProdutoDTO produtoDTO, FornecedorDTO fornecedorDTO) {
        try {
            // chama o metodo que esta na ConexaoDAO para abrir o banco de dados
            ConexaoDAO.ConnectDB();
            // Instancia o Statment que sera responsavel por executar alguma coisa no BD
            stmt = ConexaoDAO.con.createStatement();

            // Comando SQL que sera executado no banco de dados
            String comando = "Update produto set "
                    + "nome_prod = '" + produtoDTO.getNome_prod() + "', "
                    + "desc_prod = '" + produtoDTO.getDesc_prod() + "', "
                    + "cod_bar_prod = " + produtoDTO.getCod_bar_prod() + ", "
                    + "p_custo_prod = " + produtoDTO.getP_custo_prod() + ", "
                    + "p_venda_prod = " + produtoDTO.getP_venda_prod() + ", "
                    + "id_for = " + fornecedorDTO.getId_for() + ", "
                    + "where id_cli = " + fornecedorDTO.getId_for();
            System.out.println(comando);
            //Executa o comando SQL no bando de Dados
            stmt.execute(comando.toUpperCase());
            ConexaoDAO.con.commit();
            return true;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        } finally {
            ConexaoDAO.CloseDB();
        }
    }

    public ResultSet consultarProduto(ProdutoDTO produtoDTO, int opcao) {
        try {
            ConexaoDAO.ConnectDB();
            stmt = ConexaoDAO.con.createStatement();
            String comando = "";
            
            switch (opcao) {
                case 1:
                    comando = "Select p.* "+
                              "from produto p" +
                              "where p.nome_prod ilike '" + produtoDTO.getNome_prod() + "%' "+
                              "order by p.nome_prod";
                    
                    break;
                case 2:
                    comando = "Select p.*, f.nome_for, f.id_for "+
                              "from produto p, fornecedor f "+
                              "where p.id_for = f.id_for and p.id_prod = " + produtoDTO.getId_prod();
                    
                    break;
                default:
                    throw new AssertionError();
            }
            //Executa o comando SQL no bando de Dados
            rs = stmt.executeQuery(comando.toUpperCase());
            return rs;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return rs;
        }
    }
    
    public boolean excluirProduto (ProdutoDTO produtoDTO){
        try {
            ConexaoDAO.ConnectDB();
            
            pstmt = ConexaoDAO.con.prepareStatement("DELETE FROM produto where id_prod = ?");
            pstmt.setInt(1, produtoDTO.getId_prod());            
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
