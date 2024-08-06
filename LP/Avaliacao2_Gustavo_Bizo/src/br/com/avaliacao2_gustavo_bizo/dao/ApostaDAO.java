package br.com.avaliacao2_gustavo_bizo.dao;

import java.sql.*;
import br.com.avaliacao2_gustavo_bizo.dto.ApostaDTO;
import br.com.avaliacao2_gustavo_bizo.dto.ClienteDTO;
import javax.swing.JTable;

/**
 *
 * @author gbiz0
 */
public class ApostaDAO {

    public ApostaDAO() {
    }

    private ResultSet rs = null;
    private Statement stmt = null;
    private Statement stmt1 = null;
    private PreparedStatement pstmt = null;

    public boolean inserirAposta(ApostaDTO apostaDTO, ClienteDTO clienteDTO, JTable bicho) {
        try {
            ConexaoDAO.ConnectDB();

            stmt = ConexaoDAO.con.createStatement();
            stmt1 = ConexaoDAO.con.createStatement();
            
            String comando1 = "INSERT INTO aposta (valor_aposta, id_cli) values ("
                    + apostaDTO.getVal_aposta() + ", "
                    + clienteDTO.getId_cli() + ")";
            stmt.execute(comando1.toUpperCase(), Statement.RETURN_GENERATED_KEYS);
            rs = stmt.getGeneratedKeys();
            rs.next();
            
            for (int cont = 0; cont < bicho.getRowCount(); cont++) {
                String comando2 = "INSERT INTO bicho_aposta (id_aposta, id_bicho, val_bicho, qtd_bicho) values ("
                    + rs.getInt("id_aposta") + ", "
                    + bicho.getValueAt(cont, 0) + ", "
                    + bicho.getValueAt(cont, 2) + ", "
                    + bicho.getValueAt(cont, 3) + "); ";
                
                stmt1.execute(comando2);
            }
            ConexaoDAO.con.commit();
            stmt.close();
            stmt1.close();
            rs.close();
            return true;
        } catch (Exception e) {
            System.out.println("Problema ao abrir base de dados! " + e.getMessage());
            return false;
        } finally {
            ConexaoDAO.CloseDB();
        }
    }
}
