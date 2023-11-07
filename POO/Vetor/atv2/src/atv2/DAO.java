/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package atv2;

/**
 *
 * @author gbiz0
 */
public class DAO {
    private String reposta="";
    private int[] valor = new int [3];
    
    public String calcular(DTO dto) {
        int vet1[] = dto.getVet1();
        int vet2[] = dto.getVet2();
        
        for (int i = 0; i < vet1.length; ++i) {
            this.valor[i] = vet1[i] * vet2[i];
            
            this.reposta += "O valor de "+vet1[i]+" X "+vet2[i]+" = "+valor[i] + "\n";
        }
        return this.reposta;
    }
}
