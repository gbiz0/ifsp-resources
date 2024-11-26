package model;

public abstract class Personagem {
    private String nome;
    private String vila;
    private String rank;

    public Personagem(String nome, String vila, String rank) {
        this.nome = nome;
        this.vila = vila;
        this.rank = rank;
    }

    public abstract void mostrarInfo();

    public String getNome() {
        return nome;
    }

    public String getVila() {
        return vila;
    }

    public String getRank() {
        return rank;
    }
}
