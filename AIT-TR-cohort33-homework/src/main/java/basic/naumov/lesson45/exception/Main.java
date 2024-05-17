package basic.naumov.lesson45.exception;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
// Создайте массив строк с различными значениями (минимум 5 элементов).
        String[] books = new String[5];
        books[0] = "Яблоко";
        books[1] = "Груша";
        books[2] = "Вишня";
        books[3] = "Слива";
        books[4] = "Апельсин";

     //Запросите у пользователя индекс элемента, который нужно извлечь из массива.
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите индекс массива");


        String number = scanner.next();

        // Напишите метод для безопасного извлечения элемента из массива по индексу.
        while (!safeMethod(number, books)){
            System.out.println("Попробуйте снова");
            number = scanner.next();
        };
    }

    private static boolean safeMethod(String number, String[] books) {
        System.out.println("Номер: " + number);
        // Используйте блок try-catch для обработки исключений
        try {
            int i = Integer.parseInt(number);
            // Если извлечение прошло успешно, выведите элемент массива.
            System.out.println("Элемент массива с индексом " + i + " равен: " + books[i]);
            System.out.println();
            return true;
        }catch(ArrayIndexOutOfBoundsException exception){
            //  Обработайте следующие типы исключений
            // ArrayIndexOutOfBoundsException - если пользователь вводит индекс, который выходит за пределы массива.
            System.out.println("Дурачина ты, простофиля... такого индекса нет! ");
        } catch (NumberFormatException exception) {
            System.out.println("Ну ты горе математик, строка не может быть таким числом");
        } finally {
            // В блоке finally выведите сообщение о том, что операция поиска завершена
            System.out.println("Все операции с массивом закончены");
        }
        return  false;
    }
}
