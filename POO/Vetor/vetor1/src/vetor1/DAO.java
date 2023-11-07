/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vetor1;

/**
 *
 * @author gbiz0
 */
public class DAO {
    private String reposta="";
    public String verificarPosicao(DTO dto) {
        int n[] = dto.getN();
        for (int i = 0; i < n.length; ++i) {
            
            if(i % 2 == 0){
                this.reposta += n[i] + "\n";
            }
        }
        return this.reposta;
    }
}
