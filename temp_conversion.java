import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.text.DecimalFormat;

public class temp_conversion {

    // Declare GUI Elements
    public static JFrame frmMain;
    public static JLabel lblInput;
    public static JLabel lblResult;
    public static JTextField textInput;
    public static JTextField textResult;
    public static JRadioButton celsiusToFahrenheitRadio;
    public static JRadioButton fahrenheitToCelsiusRadio;
    public static JRadioButton celsiusToKelvinRadio;
    public static JRadioButton kelvinToCelsiusRadio;
    public static JRadioButton fahrenheitToKelvinRadio;
    public static JRadioButton kelvinToFahrenheitRadio;
    public static JButton btnConvert;
    public static JButton btnClear; // Added Clear button

    public static void main(String[] args) {

        frmMain = new JFrame("TEMPERATURE CONVERTER");
        frmMain.setSize(500, 200);
        frmMain.setLayout(new FlowLayout());
        frmMain.setVisible(true);
        frmMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmMain.getContentPane().setBackground(Color.BLACK);

        lblInput = new JLabel("Enter Temperature:");
        lblResult = new JLabel("Result:");
        lblInput.setForeground(Color.WHITE);
        lblResult.setForeground(Color.WHITE);
        textInput = new JTextField(10);
        textResult = new JTextField(10);
        textResult.setEditable(false);

        // Create radio buttons for temperature conversion direction
        celsiusToFahrenheitRadio = new JRadioButton("Celsius to Fahrenheit");
        fahrenheitToCelsiusRadio = new JRadioButton("Fahrenheit to Celsius");
        celsiusToKelvinRadio = new JRadioButton("Celsius to Kelvin");
        kelvinToCelsiusRadio = new JRadioButton("Kelvin to Celsius");
        fahrenheitToKelvinRadio = new JRadioButton("Fahrenheit to Kelvin");
        kelvinToFahrenheitRadio = new JRadioButton("Kelvin to Fahrenheit");


        celsiusToFahrenheitRadio.setForeground(Color.white);
        fahrenheitToCelsiusRadio.setForeground(Color.white);
        celsiusToKelvinRadio.setForeground(Color.white);
        kelvinToCelsiusRadio.setForeground(Color.white);
        fahrenheitToKelvinRadio.setForeground(Color.white);
        kelvinToFahrenheitRadio.setForeground(Color.white);


        celsiusToFahrenheitRadio.setBackground(Color.red);
        fahrenheitToCelsiusRadio.setBackground(Color.red);
        celsiusToKelvinRadio.setBackground(Color.red);
        kelvinToCelsiusRadio.setBackground(Color.red);
        fahrenheitToKelvinRadio.setBackground(Color.red);
        kelvinToFahrenheitRadio.setBackground(Color.red);


        btnConvert = new JButton("Convert");
        btnConvert.setForeground(Color.WHITE);
        btnConvert.setBackground(Color.blue);

        btnClear = new JButton("Clear");
        btnClear.setForeground(Color.WHITE);
        btnClear.setBackground(Color.blue);

        // Create a button group for radio buttons
        ButtonGroup conversionGroup = new ButtonGroup();
        conversionGroup.add(celsiusToFahrenheitRadio);
        conversionGroup.add(fahrenheitToCelsiusRadio);
        conversionGroup.add(celsiusToKelvinRadio);
        conversionGroup.add(kelvinToCelsiusRadio);
        conversionGroup.add(fahrenheitToKelvinRadio);
        conversionGroup.add(kelvinToFahrenheitRadio);

        btnConvert.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                convertTemperature();
            }
        });

        btnClear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearFields();
            }
        });

        frmMain.add(lblInput);
        frmMain.add(textInput);
        frmMain.add(lblResult);
        frmMain.add(textResult);
        frmMain.add(celsiusToFahrenheitRadio);
        frmMain.add(fahrenheitToCelsiusRadio);
        frmMain.add(celsiusToKelvinRadio);
        frmMain.add(kelvinToCelsiusRadio);
        frmMain.add(fahrenheitToKelvinRadio);
        frmMain.add(kelvinToFahrenheitRadio);
        frmMain.add(btnConvert);
        frmMain.add(btnClear); // Add Clear button
    }

    private static void convertTemperature() {
        try {
            double temperature = Double.parseDouble(textInput.getText());
            double result = 0.0;

            if (celsiusToFahrenheitRadio.isSelected()) {
                result = celsiusToFahrenheit(temperature);
            } else if (fahrenheitToCelsiusRadio.isSelected()) {
                result = fahrenheitToCelsius(temperature);
            } else if (celsiusToKelvinRadio.isSelected()) {
                result = celsiusToKelvin(temperature);
            } else if (kelvinToCelsiusRadio.isSelected()) {
                result = kelvinToCelsius(temperature);
            } else if (fahrenheitToKelvinRadio.isSelected()) {
                result = fahrenheitToKelvin(temperature);
            } else if (kelvinToFahrenheitRadio.isSelected()) {
                result = kelvinToFahrenheit(temperature);
            }

            textResult.setText(formatTemperature(result));
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Invalid input. Please enter a valid number.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private static void clearFields() {
        textInput.setText("");
        textResult.setText("");
    }

    private static String formatTemperature(double temperature) {
        DecimalFormat df = new DecimalFormat("#.##");
        return df.format(temperature);
    }

    // Temperature conversion functions
    private static double celsiusToFahrenheit(double celsius) {
        return (celsius * 9.0 / 5.0) + 32;
    }

    private static double fahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5 / 9;
    }

    private static double celsiusToKelvin(double celsius) {
        return celsius + 273.15;
    }

    private static double kelvinToCelsius(double kelvin) {
        return kelvin - 273.15;
    }

    private static double fahrenheitToKelvin(double fahrenheit) {
        double celsius = (fahrenheit - 32) * 5 / 9;
        return celsiusToKelvin(celsius);
    }

    private static double kelvinToFahrenheit(double kelvin) {
        double celsius = kelvinToCelsius(kelvin);
        return (celsius * 9 / 5) + 32;
    }
}

