package java.basic.naumov.lesson36.superhero.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import java.basic.naumov.lesson36.superhero.Superhero;

public class SuperheroTest {

    @Test
    public void testAddPowerIncorrectly() {
        // Создаем супергероя с некорректным уровнем силы (0)
        Superhero superhero = new Superhero("Волк", 0, 17);

        // Проверяем, что уровень силы был установлен в значение по умолчанию (5)
        assertEquals(5, superhero.getPower());

        // Создаем другого супергероя с некорректно высоким уровнем силы (100)
        Superhero superhero2 = new Superhero("Заяц", 100, 15);

        // Проверяем, что уровень силы был установлен в значение по умолчанию (5)
        assertEquals(5, superhero2.getPower());
    }

    @Test
    public void testSetPowerCorrectly() {
        // Создаем супергероя с корректным уровнем силы (от 1 до 10)
        Superhero superhero = new Superhero("Сокол", 7, 25);

        // Проверяем, что уровень силы был установлен корректно
        assertEquals(7, superhero.getPower());
    }

    @Test
    public void testSetName() {
        // Создаем супергероя
        Superhero superhero = new Superhero("Лев", 8, 30);

        // Устанавливаем новое имя для супергероя
        superhero.setName("Гепард");

        // Проверяем, что имя супергероя было изменено
        assertEquals("Гепард", superhero.getName());
    }

}
