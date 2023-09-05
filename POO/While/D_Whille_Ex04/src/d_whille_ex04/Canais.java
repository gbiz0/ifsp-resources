/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package d_whille_ex04;

/**
 *
 * @author gbiz0
 */
public class Canais {
    private int canal;
    private String resp;
    private int c9, c12, c23, c40, outro;
    
    public void verificar (int canal){
        this.canal = canal;
        
        if (this.canal == 9) {
            this.c9++;
        }else if(this.canal == 12) {
            this.c12++;
        }else if(this.canal == 23) {
            this.c23++;
        }else if(this.canal == 40) {
            this.c40++;
        }else {
            this.outro++;
        }  
    }
    public String mostra(){
        this.resp = "\nCanal 9: "+this.c9 +
                    "\nCanal 12: "+this.c12 + 
                    "\nCanal 23: "+this.c23 +
                    "\nCanal 40: "+this.c40 +
                    "\nOutros Canais: "+this.outro;  
        
        return this.resp;
    }
}
