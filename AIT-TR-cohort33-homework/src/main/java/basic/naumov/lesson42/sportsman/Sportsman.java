package basic.naumov.lesson42.sportsman;

import lombok.*;
import lombok.extern.slf4j.Slf4j;

/**
 * a. Создайте класс Sportsman со следующими полями:
 * - String name (имя спортсмена)
 * - int age (возраст)
 * - String sport (вид спорта)
 * - int records (рекорд спортсмена)
 *
 * b. Реализуйте для класса Sportsman геттеры, сеттеры, конструкторы и метод toString.
 * Аннотация @Slf4j создает логгер для класса,
 * @Getter и @Setter генерируют геттеры и сеттеры,
 * @AllArgsConstructor и @NoArgsConstructor генерируют конструкторы с аргументами и без аргументов соответственно,
 * а @ToString генерирует метод toString.
 */
@Slf4j
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Sportsman {
    private String name;
    private int age;
    private String sport;
    private int record;

    /*
    Реализуйте метод updateRecord(int newRecord),
     который будет обновлять рекорд спортсмена,
     если newRecord больше текущего рекорда.
     */
    public void updateRecord(int newRecord) {
        if (newRecord > this.record) {
            log.info("Спортсмен {} установил свой новый рекорд {} -- старый рекорд {} ",name, newRecord, record);
            this.record = newRecord;
            return;
        }
        log.info("Спортсмен {} НЕ смог установить новый рекорд {}, действует старый рекорд {}", name, newRecord, record);
    }
    /*
     Реализуйте метод isEligibleForCompetition(int minAge, int maxAge), который проверяет,
      соответствует ли возраст спортсмена допустимому диапазону для участия в соревнованиях.
     */
    public boolean isAgeOk(int minAge, int maxAge) {
        log.info("Проверка возраста для спортсмена {} с возрастом {}, нужен минимальный возраст {} и максимальный возраст {}",
                name, age, minAge, maxAge);
        return (age >= minAge) && (age <= maxAge);
    }
}
