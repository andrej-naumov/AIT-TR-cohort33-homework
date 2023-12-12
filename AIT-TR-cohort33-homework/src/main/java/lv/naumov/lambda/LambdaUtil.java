package lv.naumov.lambda;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class LambdaUtil {
    // (arguments) -> {body}
    // Implementing interfaces: Runnable, Callable, Comparator, Consumer, Supplier, Function, Predicate
    public static void main(String[] args) {

        System.out.println("\r\n-------- Example 1");
        List<String> strings = Arrays.asList("PHP", "Java", "Python");
        iterateOverList(strings);

        System.out.println("\r\n-------- Example 2");
        List<Integer> integers = Arrays.asList(1,2,3,4,5,6,7,8,9,0,1,2,3,4,5,6,7,8,9,0);
        filterDistinctElements(integers);

        System.out.println("\r\n-------- Example 3");
        dropWhileCondition(integers);

        System.out.println("\r\n-------- Example 4");
        filterWithCondition(integers);

        System.out.println("\r\n-------- Example 5");
        performReductionOperation(integers);

        System.out.println("\r\n-------- Example 6");
        convertToUpperCase(strings);

        System.out.println("\r\n-------- Example 7");
        removeElementAndModifyList(strings);

        System.out.println("\r\n-------- Example 8");
        findMaxAndMin(integers);

        System.out.println("\r\n-------- Example 9");
        squareNumbers(integers);

        System.out.println("\r\n-------- Example 10");
        findFirstElementGreaterThan(integers);

        System.out.println("--------");
    }

    private static void iterateOverList(List<String> strings) {
        AtomicInteger count = new AtomicInteger();
        strings.forEach(element -> {
            count.getAndIncrement(); System.out.println(count + " ---> " + element);
        });
    }

    private static void filterDistinctElements(List<Integer> integers) {
        List<Integer> distinctIntegers = integers.stream().distinct().toList();
        System.out.println(distinctIntegers);
    }

    private static void dropWhileCondition(List<Integer> integers) {
        List<Integer> droppedList = integers.stream().dropWhile(number -> number < 5).toList();
        System.out.println(droppedList);
    }

    private static void filterWithCondition(List<Integer> integers) {
        List<Integer> filteredList = integers.stream().filter(number -> number < 5 || number > 8).collect(Collectors.toList());
        System.out.println(filteredList);
    }

    private static void performReductionOperation(List<Integer> integers) {
        System.out.println(integers.stream().reduce(10, Integer::sum));
    }

    private static void convertToUpperCase(List<String> strings) {
        System.out.println(strings.stream().map(String::toUpperCase).collect(Collectors.toList()));
    }

    private static void removeElementAndModifyList(List<String> strings) {
        System.out.println(strings.stream().dropWhile(str -> str.equals("PHP")).collect(Collectors.toList()));
        List<String> list = new ArrayList<>(strings);
        System.out.println(list);
        final String php = "PHP";
        System.out.println("is " + php + " removed? -"  + list.removeIf(str -> str.equals(php)));
        System.out.println(list);
    }

    private static void findMaxAndMin(List<Integer> integers) {
        System.out.println("Max number: " + Collections.max(integers, Integer::compare));
        System.out.println("Min number: " + Collections.min(integers, Integer::compare));
    }

    private static void squareNumbers(List<Integer> integers) {
        integers.replaceAll(number -> number * number);
        System.out.println("New numbers: " + integers);
    }

    private static void findFirstElementGreaterThan(List<Integer> integers) {
        System.out.println(integers.stream().distinct().sorted(Integer::compare).filter(number -> number > 50).findFirst().orElse(0));
    }
}

