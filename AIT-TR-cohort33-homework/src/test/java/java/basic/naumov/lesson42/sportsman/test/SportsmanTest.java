package java.basic.naumov.lesson42.sportsman.test;

import basic.naumov.lesson42.sportsman.Sportsman;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SportsmanTest {

    @Test
    public void testSportsmanCreation() {
        Sportsman sportsman = new Sportsman("Заяц", 25, "Бег", 100);
        assertNotNull(sportsman);
        assertEquals("Заяц", sportsman.getName());
        assertEquals(25, sportsman.getAge());
        assertEquals("Бег", sportsman.getSport());
        assertEquals(100, sportsman.getRecord());
    }

    @Test
    public void testUpdateRecordWhenNewRecordIsHigher() {
        Sportsman sportsman = new Sportsman("Кенгуру", 30, "Прыжки", 50);
        sportsman.updateRecord(60);
        assertEquals(60, sportsman.getRecord());
    }

    @Test
    public void testUpdateRecordWhenNewRecordIsNotHigher() {
        Sportsman sportsman = new Sportsman("Медведь", 22, "Велосипед", 75);
        sportsman.updateRecord(60);
        assertEquals(75, sportsman.getRecord());
    }

    @Test
    public void testGetterAndSetter() {
        Sportsman sportsman = new Sportsman();
        sportsman.setName("Колобок");
        sportsman.setAge(28);
        sportsman.setSport("Гольф");
        sportsman.setRecord(200);
        assertEquals("Колобок", sportsman.getName());
        assertEquals(28, sportsman.getAge());
        assertEquals("Гольф", sportsman.getSport());
        assertEquals(200, sportsman.getRecord());
    }

    @Test
    public void testIsAgeOk() {
        Sportsman youngSportsman = new Sportsman("Мальчик с пальчик", 18, "Прятки", 50);
        Sportsman middleAgedSportsman = new Sportsman("Иван Дурак", 35, "Езда на печи", 70);
        Sportsman oldSportsman = new Sportsman("Баба Яга", 50, "Полёты на метле", 30);

        assertTrue(youngSportsman.isAgeOk(18, 25)); // Допустимый возраст 18-25 лет.
        assertTrue(middleAgedSportsman.isAgeOk(25, 40)); // Допустимый возраст 25-40 лет.
        assertTrue(oldSportsman.isAgeOk(40, 60)); // Допустимый возраст 40-60 лет.

        assertFalse(youngSportsman.isAgeOk(26, 30)); // Недопустимый возраст 26-30 лет.
        assertFalse(middleAgedSportsman.isAgeOk(18, 25)); // Недопустимый возраст 18-25 лет.
        assertFalse(oldSportsman.isAgeOk(18, 40)); // Недопустимый возраст 18-40 лет.
    }
}

