package c_for_ex01;

/**
 *
 * @author gbiz0
 */
public class Tabuada {
    private int number;
    private String imprimir = "";
    public String calcular_Tabuada(int number){
        this.number = number;
        
        for (int i = 0; i < 10; i++) {
            this.imprimir = this.imprimir + "\n" + i + "x" + this.number + "=" + i*this.number;
        }
        return this.imprimir;
    }
}
