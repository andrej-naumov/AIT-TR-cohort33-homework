package lv.naumov.stream;

import com.github.javafaker.Faker;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
public class Main {
    /**
     * генерируем листы различной длины
     * */
    private static final List<FakeEmployee> FAKE_EMPLOYEE_LIST_100 = generateFakeEmployees(100);
    private static final List<FakeEmployee> FAKE_EMPLOYEE_LIST_1K = generateFakeEmployees(1_000);
    //private static final List<FakeEmployee> FAKE_EMPLOYEE_LIST_10K = generateFakeEmployees(10_000);
    //private static final List<FakeEmployee> FAKE_EMPLOYEE_LIST_100K = generateFakeEmployees(100_000);
   // private static final List<FakeEmployee> FAKE_EMPLOYEE_LIST_1M = generateFakeEmployees(1_000_000);

    private static final List<List<FakeEmployee>> SUPER_LIST = new ArrayList<>(
            Arrays.asList(
                    FAKE_EMPLOYEE_LIST_100
                    ,FAKE_EMPLOYEE_LIST_1K
                    //,FAKE_EMPLOYEE_LIST_10K
                    //,FAKE_EMPLOYEE_LIST_100K
                    //,FAKE_EMPLOYEE_LIST_1M
            )
    );

    public static void main(String[] args) throws InterruptedException {
        log.info("--- sleep 30sec");
        Thread.sleep(30000);

        log.info("Go!");
        long startTimeStream = System.nanoTime(); // Засекаем время до выполнения метода
        List<Double> averageRatesForEachListWithStream = averageRatesForEachListWithStream();
        long endTimeStream = System.nanoTime(); // Засекаем время после выполнения метода

        long startTimeFor = System.nanoTime(); // Засекаем время до выполнения метода
        List<Double> averageRatesForEachListWithFor = averageRatesForEachListWithFor();
        long endTimeFor = System.nanoTime(); // Засекаем время после выполнения метода

        // Выводим результаты
        log.info("with stream:   " + averageRatesForEachListWithStream);
        log.info("with for loop: " + averageRatesForEachListWithFor);

        // Вычисляем время выполнения для каждого метода
        long streamExecutionTime = endTimeStream - startTimeStream;
        long forExecutionTime = endTimeFor - startTimeFor;

        log.info("Execution time nanoseconds with Stream method:   {}",String.format("%10.4f", (double) streamExecutionTime));
        log.info("Execution time nanoseconds with For loop method: {}",String.format("%10.4f", (double) forExecutionTime));

        log.info("--- sleep 30sec");
        Thread.sleep(30000);

        log.info("Go! Go!");
        startTimeStream = System.nanoTime();
        averageRatesForEachListWithStream = averageRatesForEachListWithStream();
        endTimeStream = System.nanoTime();

        startTimeFor = System.nanoTime();
        averageRatesForEachListWithFor = averageRatesForEachListWithFor();
        endTimeFor = System.nanoTime();



        // Выводим результаты
        log.info("with stream:   " + averageRatesForEachListWithStream);
        log.info("with for loop: " + averageRatesForEachListWithFor);

        streamExecutionTime = endTimeStream - startTimeStream;
        forExecutionTime = endTimeFor - startTimeFor;

        log.info("Execution time nanoseconds with Stream method:   {}",String.format("%10.4f", (double) streamExecutionTime));
        log.info("Execution time nanoseconds with For loop method: {}",String.format("%10.4f", (double) forExecutionTime));

    }


    private static List<Double>  averageRatesForEachListWithStream(){
      return SUPER_LIST.stream()
              .mapToDouble(list -> list.stream()
                      .mapToDouble(FakeEmployee::getHourRate)
                      .average()
                      .orElse(0.0)) // Если список пуст, средняя ставка будет 0.0
              .boxed()
              .toList();
    }

    private static List<Double> averageRatesForEachListWithFor() {
        List<Double> averageRatesForEachListWithFor = new ArrayList<>();

        for (List<FakeEmployee> list : SUPER_LIST) {
            double sum = 0.0;
            int count = 0;

            for (FakeEmployee employee : list) {
                sum += employee.getHourRate();
                count++;
            }

            double averageRate = count > 0 ? sum / count : 0.0; // Избегаем деления на 0

            averageRatesForEachListWithFor.add(averageRate);
        }

        return averageRatesForEachListWithFor;
    }


    private static List<FakeEmployee> generateFakeEmployees(int count) {
        Faker faker = new Faker();
        List<FakeEmployee> fakeEmployees = new ArrayList<>(count);

        for (int i = 0; i < count; i++) {
            String firstName = faker.name().firstName();
            String lastName = faker.name().lastName();
            String employeeNumber = faker.idNumber().valid();
            double hourRate = faker.number().randomDouble(2, 10, 50); // Генерация случайной ставки в час

            FakeEmployee fakeEmployee = new FakeEmployee(firstName, lastName, employeeNumber, hourRate);
            fakeEmployees.add(fakeEmployee);
        }

        return fakeEmployees;
    }
}


