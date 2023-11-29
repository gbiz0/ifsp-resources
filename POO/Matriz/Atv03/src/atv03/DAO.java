/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package atv03;
import java.util.Random;
/**
 *
 * @author gbiz0
 */
public class DAO {
    private static final Random rand = new Random();
    
    public void mostrarMatriz(DTO dto){
        int n[][] = dto.getN();
        for(int i = 0; i<5; i++){
            for(int j = 0; j<5; j++){
                dto.getN()[i][j] = this.rand.nextInt(100);
            }
        }
    }
    
    public void calcular (DTO dto){
        int[][] mat = new int [5][5];
        
        for(int i = 0; i<5; i++){
            for(int j = 0; j<5; j++){
                mat[i][j] = dto.getN()[i][i] * dto.getN()[i][j];
            }
        } 
        dto.setN(mat);
    }
    
    public void mostrar(DTO dto){
        for(int i = 0; i<5; i++){
            for(int j = 0; j<5; j++){
                
            }
        } 
    }
}
