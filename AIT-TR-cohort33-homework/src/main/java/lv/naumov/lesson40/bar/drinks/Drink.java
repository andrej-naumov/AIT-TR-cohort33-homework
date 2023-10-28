package lv.naumov.lesson40.bar.drinks;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

/**
 * Создайте класс Drink со следующими полями:
 * <p>
 * String name (название)
 * String type (тип напитка: алкогольный, безалкогольный и т.д.)
 * double volume (объем в мл)
 */
@Getter
@AllArgsConstructor
@ToString
public class Drink {
    private String name;
    private String type;
    private double volume;
}
