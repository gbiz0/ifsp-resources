package com.gbizo.model;

public class carta {
    private String nome;
    private int forca;
    private int inteligencia;
    private int agilidade;

    public Carta(String nome, int forca, int inteligencia, int agilidade) {
        this.nome = nome;
        this.forca = forca;
        this.inteligencia = inteligencia;
        this.agilidade = agilidade;
    }

    @Override
    public String toString() {
        return "Carta [Nome=" + nome + ", Força=" + forca + ", Inteligência=" + inteligencia + ", Agilidade=" + agilidade + "]";
    }

    public String getNome() {
        return nome;
    }

    public int getForca() {
        return forca;
    }

    public int getInteligencia() {
        return inteligencia;
    }

    public int getAgilidade() {
        return agilidade;
    }
}
