import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // hashmap implementa o collections framework
        HashMap<String, String> dicionario = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("-------- OPÇÕES --------");
            System.out.println("(1) Imprimir todo dicionário");
            System.out.println("(2) Buscar palavra");
            System.out.println("(3) Remover palavra");
            System.out.println("(4) Inserir palavra");
            System.out.println("(0) Sair");
            System.out.print("Insira uma opção: ");

            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    imprimirDicionario(dicionario);
                    break;
                case 2:
                    buscarPalavra(dicionario, scanner);
                    break;
                case 3:
                    removerPalavra(dicionario, scanner);
                    break;
                case 4:
                    inserirPalavra(dicionario, scanner);
                    break;
                case 0:
                    System.out.println("Tchau ;)");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 0);

        scanner.close();
    }

    public static void imprimirDicionario(HashMap<String, String> dicionario) {
        if (dicionario.isEmpty()) {
            System.out.println("O dicionário está vazio.");
        } else {
            System.out.println("Conteúdo do dicionário:");
            for (var entrada : dicionario.entrySet()) {
                System.out.println(entrada.getKey() + ": " + entrada.getValue());
            }
        }
    }

    public static void buscarPalavra(HashMap<String, String> dicionario, Scanner scanner) {
        System.out.print("Insira a palavra que deseja buscar: ");
        String palavra = scanner.nextLine();
        if (dicionario.containsKey(palavra)) {
            System.out.println(palavra + ": " + dicionario.get(palavra));
        } else {
            System.out.println("A palavra não foi encontrada no dicionário.");
        }
    }

    public static void removerPalavra(HashMap<String, String> dicionario, Scanner scanner) {
        System.out.print("Insira a palavra que deseja remover: ");
        String palavra = scanner.nextLine();
        if (dicionario.containsKey(palavra)) {
            dicionario.remove(palavra);
            System.out.println("Palavra removida com sucesso.");
        } else {
            System.out.println("A palavra não foi encontrada no dicionário.");
        }
    }

    public static void inserirPalavra(HashMap<String, String> dicionario, Scanner scanner) {
        System.out.print("Insira a nova palavra: ");
        String palavra = scanner.nextLine();
        System.out.print("Insira a definição: ");
        String definicao = scanner.nextLine();
        dicionario.put(palavra, definicao);
        System.out.println("Palavra adicionada com sucesso.");
    }
}