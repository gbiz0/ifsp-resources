package util;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CSVManager {
    private static CSVManager instance;
    private String filePath;

    private CSVManager(String filePath) {
        this.filePath = filePath;
    }

    public static CSVManager getInstance(String filePath) {
        if (instance == null) {
            instance = new CSVManager(filePath);
        }
        return instance;
    }

    public List<String[]> loadCSV() throws IOException {
        List<String[]> data = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                data.add(line.split(","));
            }
        }
        return data;
    }

    public void saveCSV(List<String[]> data) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
            for (String[] row : data) {
                bw.write(String.join(",", row));
                bw.newLine();
            }
        }
    }
}
