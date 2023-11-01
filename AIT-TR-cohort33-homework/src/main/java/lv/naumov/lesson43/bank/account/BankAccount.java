package lv.naumov.lesson43.bank.account;

import lombok.AllArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

/**
 * Создание класса BankAccount
 * Создайте новый класс BankAccount с приватными полями:
 *
 * String owner — владелец аккаунта.
 * double balance — текущий баланс.
 * Добавьте конструктор для инициализации обоих полей.
 */
@Slf4j
@AllArgsConstructor
@ToString
public class BankAccount {
    private String owner;
    private double balance;

    /*
    Добавьте метод deposit(double amount):
    Увеличьте balance на значение amount.
    Логируйте операцию на уровне INFO, указывая владельца аккаунта и сумму пополнения.*/
    public void deposit(double amount) {
        balance += amount;
        log.info("Пополнение счёта на сумму {} для владельца аккаунта: {}", amount, owner);
    }

    /*
    Добавьте метод withdraw(double amount):
    Проверьте, достаточно ли средств на аккаунте.
    Если не достаточно, залогируйте это как ERROR, указывая владельца аккаунта и требуемую сумму.
    */
    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            log.info("Снятие средств в размере {} для владельца аккаунта: {}", amount, maskOwnerName(owner));
        } else {
            log.error("Недостаточно средств для снятия {} для владельца аккаунта: {}", amount, maskOwnerName(owner));
        }
    }
    /*
    Добавьте метод checkBalance():
    Верните текущий баланс.
    Логируйте запрос баланса на уровне DEBUG, указывая владельца аккаунта.
    */
    public double checkBalance() {
        log.debug("Запрос баланса для владельца аккаунта: {}", maskOwnerName(owner));
        return balance;
    }

    private String maskOwnerName(String owner) {
        if (owner.length() <= 2) {
            return owner; // Если имя состоит из двух символов или меньше, не выполнять маскировку
        }
        char firstChar = owner.charAt(0);
        char lastChar = owner.charAt(owner.length() - 1);
        return firstChar + "*".repeat(owner.length() - 2) + lastChar;
    }
}
