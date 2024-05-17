package java.basic.naumov.lesson48.bank;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BankAccountTest {
    @Test
    void testDeposit() {
        BankAccount account = new BankAccount("123456789", "John Doe", 100.0);
        account.deposit(50.0);
        assertEquals(150.0, account.getBalance());
    }

    @Test
    void testWithdrawSufficientFunds() {
        BankAccount account = new BankAccount("123456789", "John Doe", 100.0);
        account.withdraw(50.0);
        assertEquals(50.0, account.getBalance());
    }

    @Test
    void testWithdrawInsufficientFunds() {
        BankAccount account = new BankAccount("123456789", "John Doe", 50.0);
        assertThrows(InsufficientFundsException.class, () -> account.withdraw(100.0));
    }
}