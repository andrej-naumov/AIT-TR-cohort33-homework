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

    static boolean containsDigit(int number, int digit) {
        String numberStr = String.valueOf(number);
        for (char c : numberStr.toCharArray()) {
            if (c == (char) (digit + '0')) {
                return true;
            }
        }
        return false;
    }

}
