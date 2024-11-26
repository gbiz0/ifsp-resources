import java.io.*;

public class Main {
    public static void main(String[] args) {
        String input = System.getProperty("user.dir") + "/src/csv/operacoes.csv";
        String output = System.getProperty("user.dir") + "/src/csv/resultado.csv";

        try (BufferedReader br = new BufferedReader(new FileReader(input));
                PrintWriter pw = new PrintWriter(new FileWriter(output))) {

            br.readLine();

            pw.println("RESULTADOS: ");

            String linha;
            while ((linha = br.readLine()) != null) {
                String[] campos = linha.split(",");
                char operacao = campos[0].charAt(0);
                int valor1 = Integer.parseInt(campos[1]);
                int valor2 = Integer.parseInt(campos[2]);

                int resultado = calcular(operacao, valor1, valor2);
                pw.println(resultado);
            }

            System.out.println("Finalizado! Resultados impressos em " + output);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static int calcular(char operacao, int valor1, int valor2) {
        switch (operacao) {
            case '+':
                return valor1 + valor2;
            case '-':
                return valor1 - valor2;
            case '*':
                return valor1 * valor2;
            case '/':
                if (valor2 == 0) {
                    return 1;
                }
                return valor1 / valor2;
            default:
                throw new IllegalArgumentException("Operação inválida: " + operacao);
        }
    }
}