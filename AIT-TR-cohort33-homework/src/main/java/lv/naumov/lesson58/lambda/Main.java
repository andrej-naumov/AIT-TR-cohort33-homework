package lv.naumov.lesson58.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        /**
        * Фильтрация списка:
        * Создайте список строк.
        * Используя лямбда-выражения и метод filter из Stream API,
        *   отфильтруйте и выведите на экран все строки,
        *   которые начинаются на букву "А".
        * */

        List<String> strings = Arrays.asList("Америка", "Англия", "Африка", "Afganistan");
        System.out.println(strings);
        System.out.println(filteredA(strings));
        System.out.println("_________________________________________");

        /**
         * Имеется список целых чисел.
         * Используя лямбда-выражение ->
         * преобразуйте каждое число в его квадрат и сохраните результаты в новом списке.
         */
        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9,0);
        System.out.println(numbers);
        System.out.println(squareAllNumbersInList(numbers));
        System.out.println("_________________________________________");

        /**
         * Используя поток данных (Stream) из списка целых чисел,
         * напишите лямбда-выражение для фильтрации всех четных чисел и их последующего вывода на экран.
         */
        System.out.println(squareAllNumbersInList(numbers));
        System.out.println(filteredMod2(numbers));
        System.out.println("_________________________________________");

        /**
         * Имеется список целых чисел.
         * Используя лямбда-выражение в методе forEach,
         * напечатайте каждый элемент списка.
         */
        squareAllNumbersInList(numbers).forEach( number -> System.out.print(" --> " + String.format("%,d",number)));
        System.out.println("\r\n_________________________________________");

        /**
         * Работа с потоками (Streams):
         * Используйте потоки для обработки коллекций с помощью лямбда-выражений,
         * преобразуйте все строки в списке в верхний регистр.
         */
        System.out.println(strings);
        System.out.println(toUpperString(strings));
        System.out.println("_________________________________________");
    }

    private static List<String> toUpperString(List<String> strings) {
        strings.replaceAll(String::toUpperCase);
        return strings;
    }

    private static List<Integer> filteredMod2(List<Integer> numbers) {
        return numbers.stream().filter(number -> number%2 == 0).sorted(Integer::compare).toList();
    }

    private static List<Integer> squareAllNumbersInList(List<Integer> numbers) {
        numbers.replaceAll(number -> number * number);
        return new ArrayList<>(numbers); // numbers - не поменялся !
    }

    private static List<String> filteredA(List<String> strings) {
        return  strings.stream().filter(string -> string.startsWith("А")).toList();
    }

}

