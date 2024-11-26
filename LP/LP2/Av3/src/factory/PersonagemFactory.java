package factory;

import model.Personagem;
import model.Ninja;
import model.Kage;

public class PersonagemFactory {
    public static Personagem criarPersonagem(String tipo, String nome, String vila, String rank) {
        if (tipo.equalsIgnoreCase("ninja")) {
            return new Ninja(nome, vila, rank);
        } else if (tipo.equalsIgnoreCase("kage")) {
            return new Kage(nome, vila, rank);
        }
        throw new IllegalArgumentException("Tipo de personagem inválido: " + tipo);
    }
}
