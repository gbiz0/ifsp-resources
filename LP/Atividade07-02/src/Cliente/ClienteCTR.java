/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Cliente;

/**
 *
 * @author gbiz0
 */
public class ClienteCTR {
    ClienteDAO clienteDAO = new ClienteDAO();
    
    public String mostrarNomeRg(ClienteDTO clienteDTO){
        return clienteDAO.mostrarNomeIdade(clienteDTO);
    }
    
    public String mostrarNomeIdade(ClienteDTO clienteDTO) {
        return clienteDAO.mostrarNomeIdade(clienteDTO);
    }
    
}
