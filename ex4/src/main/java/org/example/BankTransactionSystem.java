package org.example;

import javax.swing.*;
import java.awt.*;
import java.util.*;

public class BankTransactionSystem extends JFrame {
    private final Map<String, BankAccount> accounts;
    private final JTextArea transactionLog;

    public BankTransactionSystem() {
        super("Bank Transaction System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        accounts = new HashMap<>();
        transactionLog = new JTextArea(20, 50);
        transactionLog.setEditable(false);

        initializeGUI();
        createAccounts();
    }

    private void initializeGUI() {
        setLayout(new BorderLayout());

        // Transaction log panel
        JPanel logPanel = new JPanel(new BorderLayout());
        logPanel.add(new JScrollPane(transactionLog), BorderLayout.CENTER);
        logPanel.setBorder(BorderFactory.createTitledBorder("Transaction Log"));

        // Control panel
        JPanel controlPanel = new JPanel();
        JButton startButton = new JButton("Start Simulation");
        startButton.addActionListener(e -> startSimulation());

        JButton clearButton = new JButton("Clear Log");
        clearButton.addActionListener(e -> transactionLog.setText(""));

        controlPanel.add(startButton);
        controlPanel.add(clearButton);

        add(logPanel, BorderLayout.CENTER);
        add(controlPanel, BorderLayout.SOUTH);

        pack();
        setLocationRelativeTo(null);
    }

    private void createAccounts() {
        accounts.put("Account1", new BankAccount("Account1", 1000.0, transactionLog));
        accounts.put("Account2", new BankAccount("Account2", 1500.0, transactionLog));
    }

    private void startSimulation() {
        transactionLog.append("Starting new simulation...\n");

        // Create multiple clients for each account
        for (BankAccount account : accounts.values()) {
            for (int i = 1; i <= 3; i++) {
                new ClientThread(account, "Client" + i, 5).start();
            }
        }
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new BankTransactionSystem().setVisible(true);
        });
    }
}