package com.example.CurrencyConverter.UI;

import com.example.CurrencyConverter.Model.Currency;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.Objects;

public class MainFrame extends JDialog {
    private JPanel contentPane;
    private JTextField currencyInput;
    private JComboBox<String> currencyInputButton;
    private JComboBox<String> currencyOutputButton;
    private JButton convertButton;
    private String date;
    private long timestamp;
    private CurrencyStatus outputType;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    private enum CurrencyStatus {
        USD,
        JPY
    }

    public MainFrame() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(convertButton);

        convertButton.addActionListener(e -> onConvert());

        //Call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        //Call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(e -> onCancel(), KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    private void onConvert() {
        //Update currency button states
        CurrencyStatus inputType = CurrencyStatus.valueOf(Objects.requireNonNull(currencyInputButton.getSelectedItem()).toString());
        CurrencyStatus outputType = CurrencyStatus.valueOf(Objects.requireNonNull(currencyOutputButton.getSelectedItem()).toString());

        try{
            double inputDouble = Double.parseDouble(currencyInput.getText());

            JOptionPane.showMessageDialog(this,
                    String.format("%,.2f", inputDouble) + " " + inputType + " in " + outputType +
                            " is " + String.format("%,.2f", USDtoOutput(inputToUSD(inputDouble, inputType), outputType)));

        }
        catch(NumberFormatException e){
            JOptionPane.showMessageDialog(this, "Please enter a numeric value");
        }
    }

    private double inputToUSD(double inputDouble, CurrencyStatus inputType)  {
        return switch (inputType) {
            case USD -> inputDouble;
            case JPY -> inputDouble * .0073;
        };

    }

    private double getRate(CurrencyStatus inputType) throws IOException{
        OkHttpClient client = new OkHttpClient().newBuilder().build();

        Request request = new Request.Builder()
                .url("http://localhost:8989//getRate/" + inputType)
                .method("GET", null)
                .build();
        return Double.parseDouble(client.newCall(request).execute().body().string());
    }

    private double USDtoOutput(double outputDouble, CurrencyStatus outputType) {
        return switch (outputType) {
            case USD -> outputDouble;
            case JPY -> outputDouble * 137.37;
        };
    }

    private void onCancel() {
        dispose();
    }

    public static void main(String[] args) {
        MainFrame dialog = new MainFrame();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
