package lv.naumov.lesson47.currency;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

public class CurrencyConverter {

    private static Map<String, Double> exchangeRates;

    static {
        exchangeRates = new HashMap<>();
        loadExchangeRates();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Введите сумму: ");
            int amount = readPositiveInt(scanner);

            System.out.print("Введите исходную валюту (например, USD): ");
            String sourceCurrency = scanner.next().toUpperCase();

            System.out.print("Введите целевую валюту (например, EUR): ");
            String targetCurrency = scanner.next().toUpperCase();

            double result = convertCurrency(amount, sourceCurrency, targetCurrency);
            System.out.println("Результат конвертации: " + result + " " + targetCurrency);

        } catch (IOException e) {
            System.err.println("Ошибка при вводе: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.err.println("Ошибка: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }

    private static void loadExchangeRates() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(
                Objects.requireNonNull(CurrencyConverter.class.getResourceAsStream("/exchange_rates.txt"))))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(" ");
                if (parts.length == 2) {
                    String currency = parts[0];
                    double rate = Double.parseDouble(parts[1]);  // Используйте Double.parseDouble() для курса
                    exchangeRates.put(currency, rate);
                }
            }
        } catch (IOException | NumberFormatException e) {
            System.err.println("Ошибка при чтении курсов валют: " + e.getMessage());
            System.exit(1);
        }
    }

    private static int readPositiveInt(Scanner scanner) throws IOException {
        int value;
        while (true) {
            try {
                value = Integer.parseInt(scanner.next());
                if (value > 0) {
                    break;
                } else {
                    System.out.print("Введите положительное число: ");
                }
            } catch (NumberFormatException e) {
                System.out.print("Введите корректное число: ");
            } catch (IllegalArgumentException e) {
                System.out.print("Введите положительное число: ");
            }
        }
        return value;
    }

    private static double convertCurrency(int amount, String sourceCurrency, String targetCurrency) {
        if (!exchangeRates.containsKey(sourceCurrency) || !exchangeRates.containsKey(targetCurrency)) {
            throw new IllegalArgumentException("Неверная валюта");
        }

        double sourceRate = exchangeRates.get(sourceCurrency);
        double targetRate = exchangeRates.get(targetCurrency);

        return (amount / sourceRate) * targetRate;
    }
}


