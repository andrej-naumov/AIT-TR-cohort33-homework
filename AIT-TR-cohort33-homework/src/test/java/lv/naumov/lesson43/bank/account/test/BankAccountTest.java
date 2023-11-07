package lv.naumov.lesson43.bank.account.test;

import lv.naumov.lesson43.bank.account.BankAccount;
import nl.altindag.log.LogCaptor;
import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
class BankAccountTest {
    private BankAccount account1;
    private BankAccount account2;
    private BankAccount account3;

    private final LogCaptor logCaptor  = LogCaptor.forClass(BankAccount.class);

    @BeforeEach
    public void setup() {
        account1 = new BankAccount("Иванов", 1000.0);
        account2 = new BankAccount("Петров", 500.0);
        account3 = new BankAccount("Сидоров", -100_000.0);
    }

    @Test
    public void testDeposit() {
        account1.deposit(500.0);
        assertEquals(1500.0, account1.checkBalance(), 0.01); // Проверка, что баланс увеличился на 500.0
    }

    @Test
    void testDepositAmountPositivSuccess() {
        logCaptor.setLogLevelToInfo();
        account1.deposit(100);
        assertEquals(1100, account1.checkBalance());

        String expectedInfoMessage = "Пополнение счёта на сумму 100.0 для владельца аккаунта: И****в";
        assertTrue(logCaptor.getInfoLogs().contains(expectedInfoMessage));
    }

    @Test
    public void testWithdraw() {
        account2.withdraw(200.0);
        assertEquals(300.0, account2.checkBalance(), 0.01); // Проверка, что баланс уменьшился на 200.0
        account3.withdraw(200.0);
        assertEquals(-100_000.0, account3.checkBalance(), 0.01);// Проверка, что баланс не изменился
    }

    @Test
    public void testCheckBalance() {
        assertEquals(1000.0, account1.checkBalance(), 0.01); // Проверка баланса аккаунта 1
        assertEquals(500.0, account2.checkBalance(), 0.01); // Проверка баланса аккаунта 2
        assertEquals(-100_000.0, account3.checkBalance(), 0.01); // Проверка баланса аккаунта 3
    }
}