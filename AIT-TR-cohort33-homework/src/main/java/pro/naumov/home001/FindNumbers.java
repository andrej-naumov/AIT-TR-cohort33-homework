package pro.naumov.home001;

public class FindNumbers {

    public static void inRangeWithConditions(int start, int end, int divideWithoutRemainder, int digit ){
        // Find the first number in the range that is a multiple of divideWithoutRemainder
        int number = start;
        if (number % divideWithoutRemainder != 0) {
            number += (divideWithoutRemainder - number % divideWithoutRemainder);
        }

        // Iteration with step divideWithoutRemainder
        while (number <= end) {
            if (containsDigit(number, digit)) {
                Main.addNumber(number);
            }
            number += divideWithoutRemainder;
        }
    }

    private static boolean containsDigit(int number, int digit) {
        while (number != 0) {
            if (number % 10 == digit) {
                return true;
            }
            number /= 10;
        }
        return false;
    }

}
