package atv2;

import javax.swing.JOptionPane;

/**
 *
 * @author gbiz0
 */
public class Atv2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        DTO dto = new DTO();
        CTR ctr = new CTR();
        int  vet1[] = new int[3];
        int  vet2[] = new int[3];
        
        for(int cont=0; cont<vet1.length; cont++){
            vet1[cont] = Integer.parseInt(JOptionPane.showInputDialog("Informe um número para o Vetor 1 na posição: "+cont));
            vet2[cont] = Integer.parseInt(JOptionPane.showInputDialog("Informe um número para o Vetor 2 na posição: "+cont));
        }
        dto.setVet1(vet1);
        dto.setVet2(vet2);
        JOptionPane.showMessageDialog(null, ctr.calcular(dto));
    }
    
}
