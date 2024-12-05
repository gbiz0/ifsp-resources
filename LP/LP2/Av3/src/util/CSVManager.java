package util;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CSVManager {
    private static CSVManager instance;
    private String filePath;

    // Construtor privado (Singleton)
    private CSVManager(String filePath) {
        this.filePath = filePath;
    }

    // Método estático para obter a instância Singleton
    public static CSVManager getInstance(String filePath) {
        if (instance == null) {
            instance = new CSVManager(filePath);
            try {
                instance.createFileIfNotExists();
            } catch (IOException e) {
                System.err.println("Erro ao garantir que o arquivo existe: " + e.getMessage());
            }
        }
        return instance;
    }

    // Cria o arquivo CSV caso ele não exista
    private void createFileIfNotExists() throws IOException {
        File file = new File(filePath);
        if (!file.exists()) {
            if (file.createNewFile()) {
                System.out.println("Arquivo CSV criado: " + filePath);
            } else {
                throw new IOException("Falha ao criar o arquivo CSV: " + filePath);
            }
        }
    }

    // Método para carregar os dados do CSV
    public List<String[]> loadCSV() throws IOException {
        File file = new File(filePath);

        // Verifica se o arquivo pode ser lido
        if (!file.exists()) {
            throw new FileNotFoundException("Arquivo CSV não encontrado no caminho: " + filePath);
        }
        if (!file.canRead()) {
            throw new IOException("Não é possível ler o arquivo CSV. Verifique as permissões: " + filePath);
        }

        // Lê os dados do arquivo
        List<String[]> data = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                data.add(line.split(","));
            }
        }
        return data;
    }

    // Método para salvar dados no CSV
    public void saveCSV(List<String[]> data) throws IOException {
        File file = new File(filePath);

        // Verifica se o arquivo pode ser gravado
        if (!file.exists()) {
            throw new FileNotFoundException("Arquivo CSV não encontrado no caminho: " + filePath);
        }
        if (!file.canWrite()) {
            throw new IOException("Não é possível escrever no arquivo CSV. Verifique as permissões: " + filePath);
        }

        // Salva os dados no arquivo
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
            for (String[] row : data) {
                bw.write(String.join(",", row));
                bw.newLine();
            }
        }
    }

    // Teste da classe (opcional, pode ser removido)
    public static void main(String[] args) {
        try {
            // Inicializa o CSVManager
            CSVManager manager = CSVManager.getInstance("personagens.csv");

            // Testa a leitura do CSV
            System.out.println("Carregando dados do CSV...");
            List<String[]> data = manager.loadCSV();
            for (String[] row : data) {
                System.out.println(String.join(", ", row));
            }

            // Testa a escrita no CSV
            System.out.println("\nAdicionando uma nova linha...");
            data.add(new String[]{"novo", "personagem", "teste"});
            manager.saveCSV(data);

            System.out.println("Dados salvos com sucesso!");
        } catch (IOException e) {
            System.err.println("Erro: " + e.getMessage());
        }
    }
}
