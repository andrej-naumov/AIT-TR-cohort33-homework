package java.basic.naumov.lesson40.bar.drinks.test;

import java.basic.naumov.lesson40.bar.drinks.Drink;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class DrinkTest {
    @Test
    public void testCreateDrink() {
        Drink drink = new Drink("Кола", "Безалкогольный", 330.0);
        assertNotNull(drink);
    }

    @Test
    public void testGetters() {
        Drink drink = new Drink("Сок апельсиновый", "Безалкогольный", 250.0);
        assertEquals("Сок апельсиновый", drink.getName());
        assertEquals("Безалкогольный", drink.getType());
        assertEquals(250.0, drink.getVolume(), 0.01);
    }
}
