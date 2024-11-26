package model;

public class Ninja extends Personagem {
    public Ninja(String nome, String vila, String rank) {
        super(nome, vila, rank);
    }

    @Override
    public void mostrarInfo() {
        System.out.println("Ninja: " + getNome() + " | Vila: " + getVila() + " | Rank: " + getRank());
    }
}
