import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        JLabel pesoLabel, alturaLabel, resultadoLabel;
        JTextField pesoField, alturaField, resultadoField;
        JButton calcularButton;
        Container c;

        JFrame frame = new JFrame("IMC Calculator");
        frame.setSize(500, 500);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        c = frame.getContentPane();
        c.setLayout(null);

        pesoLabel = new JLabel("Digite seu peso:");
        pesoLabel.setSize(120, 20);
        pesoLabel.setLocation(100, 100);
        c.add(pesoLabel);

        pesoField = new JTextField();
        pesoField.setSize(190, 20);
        pesoField.setLocation(230, 100);
        c.add(pesoField);

        alturaLabel = new JLabel("Digite sua altura:");
        alturaLabel.setSize(120, 20);
        alturaLabel.setLocation(100, 150);
        c.add(alturaLabel);

        alturaField = new JTextField();
        alturaField.setSize(190, 20);
        alturaField.setLocation(230, 150);
        c.add(alturaField);

        calcularButton = new JButton("Calcular");
        calcularButton.setSize(100, 30);
        calcularButton.setLocation(200, 200);
        c.add(calcularButton);

        resultadoLabel = new JLabel("Seu IMC é:");
        resultadoLabel.setSize(100, 20);
        resultadoLabel.setLocation(100, 250);
        c.add(resultadoLabel);

        resultadoField = new JTextField();
        resultadoField.setSize(190, 20);
        resultadoField.setLocation(230, 250);
        resultadoField.setEditable(false);
        c.add(resultadoField);

        calcularButton.addActionListener(e -> {
            try {
                double peso = Double.parseDouble(pesoField.getText());
                double altura = Double.parseDouble(alturaField.getText());
                double imc = peso / (altura * altura);
                resultadoField.setText(String.format("%.2f", imc));
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "Por favor, insira valores válidos!", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        });

        frame.setVisible(true);
    }
}
