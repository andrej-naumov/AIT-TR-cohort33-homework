package basic.naumov.lesson.code.review;

/**Провести code review для следующего кода на Java.
//Пример кода для ревью:

public class Calculator {
public int addValues(int a, int b) {
   return a + b;
}
public int substractValues(int a, int b) {
   return a - b;
}
public int multiplyValues(int a, int b) {
   return a * b;
}
public int divideValues(int a, int b) {
   return a / b;
}
public double percentage(int total, int percent) {
   return (total / 100) * percent;
   }
}
//```
//Инструкции:
//1.  Ознакомьтесь с кодом.
//2.  Обратите внимание на стиль кодирования, именование переменных и методов, структуру
//кода, логику работы программы.
//3.  Выпишите все замечания, которые у вас возникли по коду, и предложите свои
//корректировки.
//4.  Объясните причины ваших предложений
*/


public class Calculator {
    public int addValues(int a, int b) {
        return a + b;
    }

    public int subtractValues(int a, int b) {
        return a - b;
    }

    public int multiplyValues(int a, int b) {
        return a * b;
    }

    public int divideValues(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("Division by zero is not allowed");
        }
        return a / b;
    }

    public double calculatePercentage(int total, int percent) {
        if (percent == 0) {
            throw new IllegalArgumentException("Percent cannot be zero");
        }
        return (total * percent) / 100.0;
    }
}
