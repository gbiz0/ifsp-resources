package com.gbizo.model;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class baralho {
public static void main(String[] args) {
        String arquivoCSV = "../util/trunfo.csv"; // Substitua pelo caminho correto
        ArrayList<Carta> baralho = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(arquivoCSV))) {
            String linha;
            br.readLine(); // Ignora o cabeçalho

            while ((linha = br.readLine()) != null) {
                String[] dados = linha.split(",");
                String nome = dados[0];
                int forca = Integer.parseInt(dados[1]);
                int inteligencia = Integer.parseInt(dados[2]);
                int agilidade = Integer.parseInt(dados[3]);

                Carta carta = new Carta(nome, forca, inteligencia, agilidade);
                baralho.add(carta);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Exibe as cartas lidas
        for (Carta carta : baralho) {
            System.out.println(carta);
        }
    }
}
