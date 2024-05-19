package pro.naumov.home001;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {

    private static final Set<Integer> treeSet = new TreeSet<>();

    public static synchronized void addNumber(int number) {
        treeSet.add(number);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("Меню:");
            System.out.println("0. TODO: add params :)");
            System.out.println("1. Старт с одним потоком");
            System.out.println("2. Старт с двумя потоками");
            System.out.println("3. Выход");
            System.out.print("Выберите опцию: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 0 -> System.out.println("--- Not implemented yet! ---");
                case 1 -> startSingleThread();
                case 2 -> startTwoThreads();
                case 3 -> System.out.println("Завершение программы...");
                default -> System.out.println("Некорректный выбор. Попробуйте снова.");
            }
        } while (choice != 3);
    }

    private static void startSingleThread() {
        int start = 1_000_000_000;
        int end = 2_000_000_000;
        int divideWithoutRemainder = 21;
        int digit = 3;

        Thread_ExtendsThread thread_extendsThread = new Thread_ExtendsThread(start, end, divideWithoutRemainder, digit);
        thread_extendsThread.start();
        try {
            thread_extendsThread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        outputTreeSet();
    }
    private static void startTwoThreads() {
        int start = 1_000_000_000;
        int end = 1_500_000_000;
        int divideWithoutRemainder = 21;
        int digit = 3;

        Thread thread_extendsThread = new Thread_ExtendsThread(start, end, divideWithoutRemainder, digit);
        thread_extendsThread.start();

        start = 1_500_000_001;
        end = 2_000_000_000;

        Thread thread_implementRunnable = new Thread(new Thread_ImplementRunnable(start, end, divideWithoutRemainder, digit)) ;
        thread_implementRunnable.start();

        try {
            thread_extendsThread.join();
            thread_implementRunnable.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        outputTreeSet();
    }



    private static void outputTreeSet() {
        AtomicInteger index = new AtomicInteger(1);
        treeSet.forEach(number -> System.out.println(index.getAndIncrement() + ": " + number));
    }

}
