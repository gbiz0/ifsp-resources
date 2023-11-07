package atv1;

/**
 *
 * @author gbiz0
 */
public class DAO {
private String reposta="";
    public String ordenar(DTO dto) {
        int n[] = dto.getN();
        for (int i = n.length - 1; i >=0; --i) {
            this.reposta += n[i] + "\n";
        }
        return this.reposta;
    }
    
}
