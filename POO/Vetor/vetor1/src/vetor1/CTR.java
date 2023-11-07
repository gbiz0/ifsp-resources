/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vetor1;

/**
 *
 * @author gbiz0
 */
public class CTR {
    DAO dao = new DAO();
    public String verificarPosicao(DTO dto){
        return dao.verificarPosicao(dto);
    }
}
