package pro.naumov.home001;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_BLUE = "\u001B[34m";

    private static final Set<Integer> treeSet = new TreeSet<>();

    public static synchronized void addNumber(int number) {
        treeSet.add(number);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        // Default parameters
        int start = 0;
        int end = 2000;
        int divideWithoutRemainder = 21;
        int digit = 3;

        do {
            // empty set
            treeSet.clear();
            System.out.println("Текущие параметры:");
            System.out.println("Старт: " + start);
            System.out.println("Конец: " + end);
            System.out.println("Делитель: " + divideWithoutRemainder);
            System.out.println("Цифра: " + digit);

            System.out.println("\nМеню:");
            System.out.println("0. Поменять параметры");
            System.out.println("1. Старт с одним потоком");
            System.out.println("2. Старт с двумя потоками");
            System.out.println("3. Выход");
            System.out.print("Выберите опцию: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 0 -> {
                    System.out.print("Введите старт: [" + start + "]/");
                    start = scanner.nextInt();
                    System.out.print("Введите конец: [" + end + "]/");
                    end = scanner.nextInt();
                    System.out.print("Введите делитель: [" + divideWithoutRemainder + "/");
                    divideWithoutRemainder = readDivideWithoutRemainder(scanner);
                    System.out.print("Введите цифру: [" + digit + "]/");
                    digit = scanner.nextInt();
                }
                case 1 -> startSingleThread(start, end, divideWithoutRemainder, digit);
                case 2 -> startTwoThreads(start, end, divideWithoutRemainder, digit);
                case 3 -> System.out.println("Завершение программы...");
                default -> System.out.println("Некорректный выбор. Попробуйте снова.");
            }
        } while (choice != 3);
    }

    private static int readDivideWithoutRemainder(Scanner scanner) {
        int divide;
        do {
            System.out.print("Введите делитель (не может быть 0): ");
            divide = scanner.nextInt();
            if (divide == 0) {
                System.out.println("Делитель не может быть 0. Попробуйте снова.");
            }
        } while (divide == 0);
        return divide;
    }

    private static void startSingleThread(int start, int end, int divideWithoutRemainder, int digit) {
        Thread_ExtendsThread thread_extendsThread = new Thread_ExtendsThread(start, end, divideWithoutRemainder, digit);
        thread_extendsThread.start();
        try {
            thread_extendsThread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        outputTreeSet(digit);
    }

    private static void startTwoThreads(int start, int end, int divideWithoutRemainder, int digit) {
        int mid = (start + end) / 2;

        Thread thread_extendsThread = new Thread_ExtendsThread(start, mid, divideWithoutRemainder, digit);
        thread_extendsThread.start();

        Thread thread_implementRunnable = new Thread(new Thread_ImplementRunnable(mid + 1, end, divideWithoutRemainder, digit));
        thread_implementRunnable.start();

        try {
            thread_extendsThread.join();
            thread_implementRunnable.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        outputTreeSet(digit);
    }

    private static String formatNumberWithUnderscoresAndHighlight(int number, int digit) {
        String numberStr = String.valueOf(number);
        StringBuilder formattedNumber = new StringBuilder();
        int length = numberStr.length();

        // add underscores
        for (int i = 0; i < length; i++) {
            if (i > 0 && (length - i) % 3 == 0) {
                formattedNumber.append('_');
            }
            formattedNumber.append(numberStr.charAt(i));
        }

        // return - highlight the desired digit in colour
        return formattedNumber.toString().replace(String.valueOf(digit), ANSI_BLUE + digit + ANSI_RESET);
    }

    private static void outputTreeSet(int digit) {
        AtomicInteger index = new AtomicInteger(1);
        treeSet.forEach(number -> {
            System.out.println(index.getAndIncrement() + ": " + formatNumberWithUnderscoresAndHighlight(number, digit));
        });
    }
}
