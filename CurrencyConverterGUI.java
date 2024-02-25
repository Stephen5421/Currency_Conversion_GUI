import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CurrencyConverterGUI extends JFrame {
    private JTextField amountField;
    private JComboBox<String> sourceCurrencyCombo;
    private JComboBox<String> targetCurrencyCombo;
    private JLabel resultLabel;

    public CurrencyConverterGUI() {
        setTitle("Currency Converter");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        JLabel amountLabel = new JLabel("Amount:");
        amountLabel.setBounds(20, 20, 100, 25);
        add(amountLabel);

        amountField = new JTextField();
        amountField.setBounds(120, 20, 200, 25);
        add(amountField);

        JLabel sourceCurrencyLabel = new JLabel("Source Currency:");
        sourceCurrencyLabel.setBounds(20, 50, 100, 25);
        add(sourceCurrencyLabel);

        sourceCurrencyCombo = new JComboBox<>(new String[]{"USD", "EUR", "GBP", "INR", "KWD", "JPY", "CNY", "KRW"});
        sourceCurrencyCombo.setBounds(120, 50, 200, 25);
        add(sourceCurrencyCombo);

        JLabel targetCurrencyLabel = new JLabel("Target Currency:");
        targetCurrencyLabel.setBounds(20, 80, 100, 25);
        add(targetCurrencyLabel);

        targetCurrencyCombo = new JComboBox<>(new String[]{"USD", "EUR", "GBP", "INR", "KWD", "JPY", "CNY", "KRW"});
        targetCurrencyCombo.setBounds(120, 80, 200, 25);
        add(targetCurrencyCombo);

        JButton convertButton = new JButton("Convert");
        convertButton.setBounds(150, 110, 100, 25);
        add(convertButton);

        resultLabel = new JLabel("");
        resultLabel.setBounds(20, 140, 300, 25);
        add(resultLabel);

        convertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                convertCurrency();
            }
        });
    }

    private void convertCurrency() {
        String amountText = amountField.getText();
        if (amountText.isEmpty()) {
            showError("Please enter the amount.");
            return;
        }

        double amount;
        try {
            amount = Double.parseDouble(amountText);
        } catch (NumberFormatException ex) {
            showError("Invalid amount format.");
            return;
        }

        String sourceCurrency = (String) sourceCurrencyCombo.getSelectedItem();
        String targetCurrency = (String) targetCurrencyCombo.getSelectedItem();

        double convertedAmount;
        switch (sourceCurrency) {
            case "USD":
                convertedAmount = convertFromUSD(amount, targetCurrency);
                break;
            case "EUR":
                convertedAmount = convertFromEUR(amount, targetCurrency);
                break;
            case "GBP":
                convertedAmount = convertFromGBP(amount, targetCurrency);
                break;
            case "INR":
                convertedAmount = convertFromINR(amount, targetCurrency);
                break;
            case "KWD":
                convertedAmount = convertFromKWD(amount, targetCurrency);
                break;
            case "JPY":
                convertedAmount = convertFromJPY(amount, targetCurrency);
                break;
            case "CNY":
                convertedAmount = convertFromCNY(amount, targetCurrency);
                break;
            case "KRW":
                convertedAmount = convertFromKRW(amount, targetCurrency);
                break;
            default:
                showError("Source currency not supported.");
                return;
        }

        resultLabel.setText(String.format("%.2f %s is equal to %.2f %s", amount, sourceCurrency, convertedAmount, targetCurrency));
    }
// USD
    private double convertFromUSD(double amount, String targetCurrency) {
        switch (targetCurrency) {
            case "USD":
                return amount;
            case "EUR":
                return amount * 0.88;
            case "GBP":
                return amount * 0.72;
            case "INR":
                return amount * 73.08;
            case "KWD":
                return amount * 0.30;
            case "JPY":
                return amount * 113.16;
            case "CNY":
                return amount * 6.36;
            case "KRW":
                return amount * 1187.10;
            default:
                showError("Target currency not supported.");
                return 0;
        }
    }
// EUR
    private double convertFromEUR(double amount, String targetCurrency) {
        switch (targetCurrency) {
            case "EUR":
                return amount;
            case "USD":
                return amount / 0.88;
            case "GBP":
                return amount * 0.81;
            case "INR":
                return amount * 80.44;
            case "KWD":
                return amount * 0.27;
            case "JPY":
                return amount * 127.87;
            case "CNY":
                return amount * 7.18;
            case "KRW":
                return amount * 1344.23;
            default:
                showError("Target currency not supported.");
                return 0;
        }
    }
// GBP
    private double convertFromGBP(double amount, String targetCurrency) {
        switch (targetCurrency) {
            case "GBP":
                return amount;
            case "USD":
                return amount / 0.72;
            case "EUR":
                return amount / 0.81;
            case "INR":
                return amount * 100.42;
            case "KWD":
                return amount * 0.22;
            case "JPY":
                return amount * 144.26;
            case "CNY":
                return amount * 8.11;
            case "KRW":
                return amount * 1516.13;
            default:
                showError("Target currency not supported.");
                return 0;
        }
    }
// INR
    private double convertFromINR(double amount, String targetCurrency) {
        switch (targetCurrency) {
            case "INR":
                return amount;
            case "USD":
                return amount / 73.08;
            case "EUR":
                return amount / 80.44;
            case "GBP":
                return amount / 100.42;
            case "KWD":
                return amount * 0.0037;
            case "JPY":
                return amount / 113.16;
            case "CNY":
                return amount * 0.010;
            case "KRW":
                return amount * 0.106;
            default:
                showError("Target currency not supported.");
                return 0;
        }
    }
// KWD
    private double convertFromKWD(double amount, String targetCurrency) {
        switch (targetCurrency) {
            case "KWD":
                return amount;
            case "USD":
                return amount / 0.30;
            case "EUR":
                return amount / 0.27;
            case "GBP":
                return amount / 0.22;
            case "INR":
                return amount / 0.0037;
            case "JPY":
                return amount * 376.97;
            case "CNY":
                return amount * 21.21;
            case "KRW":
                return amount * 3982.54;
            default:
                showError("Target currency not supported.");
                return 0;
        }
    }
// JPY
    private double convertFromJPY(double amount, String targetCurrency) {
        switch (targetCurrency) {
            case "JPY":
                return amount;
            case "USD":
                return amount / 113.16;
            case "EUR":
                return amount / 127.87;
            case "GBP":
                return amount / 144.26;
            case "INR":
                return amount / 113.16;
            case "KWD":
                return amount / 376.97;
            case "CNY":
                return amount * 17.82;
            case "KRW":
                return amount * 10.57;
            default:
                showError("Target currency not supported.");
                return 0;
        }
    }
// CNY
    private double convertFromCNY(double amount, String targetCurrency) {
        switch (targetCurrency) {
            case "CNY":
                return amount;
            case "USD":
                return amount / 6.36;
            case "EUR":
                return amount / 7.18;
            case "GBP":
                return amount / 8.11;
            case "INR":
                return amount / 0.010;
            case "KWD":
                return amount / 21.21;
            case "JPY":
                return amount / 17.82;
            case "KRW":
                return amount * 187.78;
            default:
                showError("Target currency not supported.");
                return 0;
        }
    }
// KRW
    private double convertFromKRW(double amount, String targetCurrency) {
        switch (targetCurrency) {
            case "KRW":
                return amount;
            case "USD":
                return amount / 1187.10;
            case "EUR":
                return amount / 1344.23;
            case "GBP":
                return amount / 1516.13;
            case "INR":
                return amount / 0.106;
            case "KWD":
                return amount / 3982.54;
            case "JPY":
                return amount / 10.57;
            case "CNY":
                return amount / 187.78;
            default:
                showError("Target currency not supported.");
                return 0;
        }
    }

    private void showError(String message) {
        JOptionPane.showMessageDialog(this, message, "Error", JOptionPane.ERROR_MESSAGE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new CurrencyConverterGUI().setVisible(true);
            }
        });
    }
}
