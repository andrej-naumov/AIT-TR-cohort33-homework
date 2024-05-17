package basic.naumov.lesson48.bank;

import java.util.logging.Level;
import java.util.logging.Logger;

// Класс банковского аккаунта
class BankAccount {
    private final String accountNumber;
    private final String ownerName;
    private double balance;

    public BankAccount(String accountNumber, String ownerName, double balance) {
        this.accountNumber = accountNumber;
        this.ownerName = ownerName;
        this.balance = balance;
    }

    public void deposit(double amount) {
        balance += amount;
        logInfo("Deposit: " + amount);
    }

    public void withdraw(double amount) throws InsufficientFundsException {
        if (amount > balance) {
            logError("Insufficient funds. Current balance: " + balance + ", requested amount: " + amount);
            throw new InsufficientFundsException(balance, amount);
        } else {
            balance -= amount;
            logInfo("Withdrawal: " + amount);
        }
    }

    public double getBalance() {
        return balance;
    }

    // Пример использования java.util.logging для логирования
    private void logInfo(String message) {
        Logger.getLogger(BankAccount.class.getName()).log(Level.INFO, message);
    }

    private void logError(String message) {
        Logger.getLogger(BankAccount.class.getName()).log(Level.SEVERE, message);
    }
}
