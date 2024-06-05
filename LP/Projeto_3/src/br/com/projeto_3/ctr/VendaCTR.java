/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.projeto_3.ctr;
import br.com.projeto_3.dao.VendaDAO;
import br.com.projeto_3.dto.VendaDTO;
import br.com.projeto_3.dao.ConexaoDAO;
import br.com.projeto_3.dto.ClienteDTO;
import javax.swing.JTable;

/**
 *
 * @author gbiz0
 */
public class VendaCTR {
    VendaDAO vendaDAO = new VendaDAO();

    public VendaCTR() {
    }
    
    public String inserirVenda (VendaDTO vendaDTO, ClienteDTO clienteDTO, JTable produtos){
        try {
            if (vendaDAO.inserirVenda(vendaDTO, clienteDTO, produtos)){
                return "Venda cadastrada com sucesso!";
            } else {
                return "Venda NÂO cadastrada!";
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return "Venda NÂO cadastrada!";
        }
    }
    public void CloseDB(){
        ConexaoDAO.CloseDB();
    }
    
}
