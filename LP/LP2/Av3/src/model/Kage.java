package model;

public class Kage extends Personagem {
    public Kage(String nome, String vila, String rank) {
        super(nome, vila, rank);
    }

    @Override
    public void mostrarInfo() {
        System.out.println("Kage: " + getNome() + " | Vila: " + getVila() + " | Rank: " + getRank());
    }
}