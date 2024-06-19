/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.projeto_4.ctr;

import br.com.projeto_4.dao.ProdutoDAO;
import br.com.projeto_4.dto.ProdutoDTO;
import br.com.projeto_4.dto.FornecedorDTO;
import br.com.projeto_4.dao.ConexaoDAO;
import java.sql.ResultSet;

/**
 *
 * @author gbiz0
 */
public class ProdutoCTR {
    
    ProdutoDAO produtoDAO = new ProdutoDAO();

    public ProdutoCTR() {
    }
    public String inserirProduto(ProdutoDTO produtoDTO, FornecedorDTO fornecedorDTO){
        try {
            if (produtoDAO.inserirProduto(produtoDTO, fornecedorDTO)){
                return "Produto cadastrado com sucesso!";
            } else {
                return "Produto NÃO cadastrado!";
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return "Produto NÃO cadastrado!"; 
        }
    }
    
    public String alterarProduto(ProdutoDTO produtoDTO, FornecedorDTO fornecedorDTO){
        try {
            if (produtoDAO.alterarProduto(produtoDTO, fornecedorDTO)){
                return "Produto alterado com sucesso!";
            } else {
                return "Produto NÃO alterado!";
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return "Produto NÃO alterado!"; 
        }
    }
    
    public String excluirProduto(ProdutoDTO produtoDTO){
        try { 
            if (produtoDAO.excluirProduto(produtoDTO)){
                return "Produto excluido com sucesso!";
            } else {
                return "Produto NÃO excluido!";
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return "Fornecedor NÃO excluido!"; 
        }
    }
    
    public ResultSet consultarProduto (ProdutoDTO produtoDTO, int opcao){
        ResultSet rs = null;
        rs = produtoDAO.consultarProduto(produtoDTO, opcao);
        return rs;
    }
    
    public void CloseDB(){
        ConexaoDAO.CloseDB();
    }
}
