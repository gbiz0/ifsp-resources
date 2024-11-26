import factory.PersonagemFactory;
import model.Ninja;
import model.Personagem;
import util.CSVManager;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CSVManager csvManager = CSVManager.getInstance("personagens.csv");
        List<Personagem> personagens = new ArrayList<>();

        try {
            List<String[]> data = csvManager.loadCSV();
            for (String[] row : data) {
                personagens.add(PersonagemFactory.criarPersonagem(row[0], row[1], row[2], row[3]));
            }
        } catch (IOException e) {
            System.out.println("Erro ao carregar o arquivo CSV: " + e.getMessage());
        }

        // Menu
        int opcao;
        do {
            System.out.println("1. Listar personagens");
            System.out.println("2. Adicionar personagem");
            System.out.println("3. Salvar e sair");
            System.out.print("Digite sua opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar buffer

            switch (opcao) {
                case 1:
                    for (Personagem personagem : personagens) {
                        personagem.mostrarInfo();
                    }
                    break;
                case 2:
                    System.out.print("Digite o tipo (ninja/kage): ");
                    String tipo = scanner.nextLine();
                    System.out.print("Digite o nome: ");
                    String nome = scanner.nextLine();
                    System.out.print("Digite a vila: ");
                    String vila = scanner.nextLine();
                    System.out.print("Digite o rank: ");
                    String rank = scanner.nextLine();
                    personagens.add(PersonagemFactory.criarPersonagem(tipo, nome, vila, rank));
                    break;
                case 3:
                    // Salvar dados no CSV
                    List<String[]> data = new ArrayList<>();
                    for (Personagem personagem : personagens) {
                        String tipoPersonagem = (personagem instanceof Ninja) ? "ninja" : "kage";
                        data.add(new String[]{tipoPersonagem, personagem.getNome(), personagem.getVila(), personagem.getRank()});
                    }
                    try {
                        csvManager.saveCSV(data);
                        System.out.println("Dados salvos com sucesso.");
                    } catch (IOException e) {
                        System.out.println("Erro ao salvar os dados: " + e.getMessage());
                    }
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 3);

        scanner.close();

    }
}
