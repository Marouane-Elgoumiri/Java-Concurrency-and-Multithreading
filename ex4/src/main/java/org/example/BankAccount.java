package org.example;
import javax.swing.*;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.atomic.AtomicInteger;

// Account class to store balance and handle transactions
class BankAccount {
    private double balance;
    private final ReentrantLock lock;
    private final String accountId;
    private final JTextArea transactionLog;

    public BankAccount(String accountId, double initialBalance, JTextArea transactionLog) {
        this.accountId = accountId;
        this.balance = initialBalance;
        this.lock = new ReentrantLock();
        this.transactionLog = transactionLog;
    }

    public boolean withdraw(double amount, String clientId) {
        lock.lock();
        try {
            if (balance >= amount) {
                // Simulate some processing time
                Thread.sleep(100);
                balance -= amount;
                logTransaction(clientId, "Withdrawal", amount);
                return true;
            }
            return false;
        } catch (InterruptedException e) {
            return false;
        } finally {
            lock.unlock();
        }
    }

    public void deposit(double amount, String clientId) {
        lock.lock();
        try {
            Thread.sleep(100);
            balance += amount;
            logTransaction(clientId, "Deposit", amount);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    private void logTransaction(String clientId, String type, double amount) {
        SwingUtilities.invokeLater(() -> {
            transactionLog.append(String.format("%s - Client %s: %s %.2f - Balance: %.2f%n",
                    accountId, clientId, type, amount, balance));
        });
    }

    public double getBalance() {
        lock.lock();
        try {
            return balance;
        } finally {
            lock.unlock();
        }
    }
}

// Client thread to simulate transactions
class ClientThread extends Thread {
    private final BankAccount account;
    private final String clientId;
    private final AtomicInteger operationCount;
    private final int maxOperations;

    public ClientThread(BankAccount account, String clientId, int maxOperations) {
        this.account = account;
        this.clientId = clientId;
        this.maxOperations = maxOperations;
        this.operationCount = new AtomicInteger(0);
    }

    @Override
    public void run() {
        while (operationCount.get() < maxOperations) {
            // Randomly choose between deposit and withdrawal
            if (Math.random() < 0.5) {
                double amount = Math.random() * 100;
                account.deposit(amount, clientId);
            } else {
                double amount = Math.random() * 50;
                account.withdraw(amount, clientId);
            }
            operationCount.incrementAndGet();

            try {
                Thread.sleep((long) (Math.random() * 500));
            } catch (InterruptedException e) {
                break;
            }
        }
    }
}