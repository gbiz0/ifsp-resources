package br.com.projeto_2.dao;

import java.sql.*;
import br.com.projeto_2.dto.FornecedorDTO;
import java.text.SimpleDateFormat;

/**
 *
 * @author gbiz0
 */
public class FornecedorDAO {

    public FornecedorDAO() {
    }

    SimpleDateFormat data_format = new SimpleDateFormat("dd/mm/yyyy");
    private ResultSet rs = null;
    private Statement stmt = null;
    private PreparedStatement pstmt = null;

    public boolean inserirFornecedor(FornecedorDTO fornecedorDTO) {
        try {
            ConexaoDAO.ConnectDB();

            stmt = ConexaoDAO.con.createStatement();
            String comando = "INSERT INTO bicho (nome_for, cnpj_for, tel_for, data_cad_for"
                    + "values ("
                    + "'" + fornecedorDTO.getNome_for() + "', "
                    + "'" + fornecedorDTO.getCnpj_for() + "', "
                    + "'" + fornecedorDTO.getTel_for() + "', "
                    + "'" + "to_date('" + data_format.format(fornecedorDTO.getData_cad_for()) + "', 'dd/mm/yyy'))";
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

    public boolean alterarFornecedor(FornecedorDTO fornecedorDTO) {
        try {
            // chama o metodo que esta na ConexaoDAO para abrir o banco de dados
            ConexaoDAO.ConnectDB();
            // Instancia o Statment que sera responsavel por executar alguma coisa no BD
            stmt = ConexaoDAO.con.createStatement();

            // Comando SQL que sera executado no banco de dados
            String comando = "Update fornecedor set "
                    + "nome_for = '" + fornecedorDTO.getNome_for() + "', "
                    + "cnpj_for = '" + fornecedorDTO.getCnpj_for() + "', "
                    + "tel_for = " + fornecedorDTO.getTel_for() + ", "
                    + "data_cad_for = to_date('" + data_format.format(fornecedorDTO.getData_cad_for()) + "', 'dd/mm/yyy') "
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

    public ResultSet consultarFornecedor(FornecedorDTO fornecedorDTO, int opcao) {
        try {
            ConexaoDAO.ConnectDB();
            stmt = ConexaoDAO.con.createStatement();
            String comando = "";
            
            switch (opcao) {
                case 1:
                    comando = "Select f.id_for, f.nome_for "+
                              "from fornecedor f" +
                              "where f.nome_for ilike '" + fornecedorDTO.getNome_for() + "%' "+
                              "order by f.nome_for";
                    
                    break;
                case 2:
                    comando = "Select f.nome_for, f.cnpj_for, f.tel_for, "+
                              "to_char(f.data_cad_for, 'dd/mm/yyyy') as data_cad_for " +
                              "from fornecedor f "+
                              "where f.id_for ilike '" + fornecedorDTO.getId_for();
                    
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
    
    public boolean excluirFornecedor (FornecedorDTO fornecedorDTO){
        try {
            ConexaoDAO.ConnectDB();
            
            pstmt = ConexaoDAO.con.prepareStatement("DELETE FROM fornecedor where id_for = ?");
            pstmt.setInt(1, fornecedorDTO.getId_for());            
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
