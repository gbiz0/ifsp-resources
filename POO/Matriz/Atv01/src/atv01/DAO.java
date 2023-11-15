/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package atv01;

/**
 *
 * @author gbiz0
 */
public class DAO {
    String resposta = "";
    public String mostrarMatriz(DTO dto){
        int n[][] = dto.getN();
        for(int i = 0; i<2; i++){
            for(int j = 0; j<3; j++){
                this.resposta += n [i][j] + " ";
            }
            this.resposta += "\n";
        }
        return this.resposta;
    }
}
