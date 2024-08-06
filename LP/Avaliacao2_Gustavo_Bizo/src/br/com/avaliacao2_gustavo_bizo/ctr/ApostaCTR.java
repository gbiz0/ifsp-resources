package br.com.avaliacao2_gustavo_bizo.ctr;

import java.sql.ResultSet;
import br.com.avaliacao2_gustavo_bizo.dto.ApostaDTO;
import br.com.avaliacao2_gustavo_bizo.dto.ClienteDTO;
import br.com.avaliacao2_gustavo_bizo.dao.ApostaDAO;
import br.com.avaliacao2_gustavo_bizo.dao.ConexaoDAO;
import javax.swing.JTable;

/**
 *
 * @autor gbiz0
 */
public class ApostaCTR {
    ApostaDAO apostaDAO = new ApostaDAO();

    public ApostaCTR() {
    }

    public String inserirAposta(ApostaDTO apostaDTO, ClienteDTO clienteDTO, JTable bicho) {
        try {
            if (apostaDAO.inserirAposta(apostaDTO, clienteDTO, bicho)) {
                return "Aposta Cadastrada com Sucesso!";
            } else {
                return "Aposta NÃO Cadastrada!";
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return "Aposta não cadastrada";
        }
    }



    public void CloseDB() {
        ConexaoDAO.CloseDB();
    }
}
